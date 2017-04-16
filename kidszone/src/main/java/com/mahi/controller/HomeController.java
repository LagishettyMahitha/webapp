package com.mahi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.dao.CartDao;
import com.mahi.dao.CartItemDao;
import com.mahi.dao.CategoryDao;
import com.mahi.dao.ProductDao;
import com.mahi.dao.UserDao;
import com.mahi.model.Cart;
import com.mahi.model.CartItem;
import com.mahi.model.Product;
import com.mahi.model.User;

@Controller
public class HomeController 
{
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDAO;
	@Autowired
	ProductDao productDAO;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemDao cartItemDao;
	
	
	@RequestMapping({"/","/home"})
	public String home(Principal principal,ModelMap model)
	{
		System.out.println("i am in home controller login");
		User userobj=null;
	if(principal!=null)
	{
		userobj=userDao.getUserByEmail(principal.getName());
		System.out.println("user data="+userobj.getEmail());
		if(userobj.getRole().equals("ROLE_ADMIN"))
		{
			return "redirect:/adminpage";
		}
		else
		{
			model.addAttribute("catlist,categoryDAO.allCategories()");
			return "Home";
		}
		
	}
	else
	{
		return "Home";
	}	
	}
	@RequestMapping("/adminpage")
	public ModelAndView AdminPage()
	{
		return new ModelAndView("AdminHome");
	}
	@GetMapping("/login")
	public String Login(@RequestParam(value="error",required=false)String error,ModelMap model)
	{
		System.out.println(error);
		if(error!=null)
		{
			model.addAttribute("error","Authentication Failed");
			return "loginform";
		}
		model.addAttribute("title","Login");
		model.addAttribute("loginform",true);
		return "loginform";
	}

	@RequestMapping("cat/{id}/products")
	public String getProducts(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("id",id);
		model.addAttribute("products", productDAO.allProducts());
		return "Products";
	}
	
	@RequestMapping("/{id}/catproducts")
	public @ResponseBody List<Product> allProducts(@PathVariable Integer id)
	{
		
		return productDAO.getCatProducts(id);
	}
	
	@RequestMapping("/{id}/viewproduct")
	public String viewProduct(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("product",productDAO.get(id));
		
		
		return "CustViewProduct";
	}
	
	
	@RequestMapping("customer/{id}/addcart")
	public String addCart(@PathVariable Integer id,Principal principal)
	{
		if(principal!=null)
		{
		 User user=userDao.getUserByEmail(principal.getName());
		Cart cart= user.getCart();
		CartItem cartItem =cartItemDao.getExistingCartItemCount(id, cart.getId());
		System.out.println("cartItem item object"+cartItem);
		Product product=productDAO.get(id);
		if(cartItem==null)
		{
		  cartItem=new CartItem();
		  cartItem.setQuantity(1);
		  cartItem.setProduct(product);
		  cartItem.setGrandTotal(product.getProductPrice());
		  cartItem.setCart(cart);
		  cartItemDao.addCartItem(cartItem);
		  cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
		  cart.setQuantity(cart.getQuantity()+1);
		  cartDao.updateCart(cart);
		}else
		{
			cartItem.setQuantity(cartItem.getQuantity()+1);
			cartItem.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
			cart.setGrandTotal(cart.getGrandTotal()+product.getProductPrice());
			  cart.setQuantity(cart.getQuantity()+1);
			  
			  
			  cartDao.updateCart(cart);
			  cartItemDao.updateCartItem(cartItem);
		}
		
		   
		}
		
		return "redirect:/cat/"+id+"/products";
	}
	
	
	@RequestMapping("/about")
	public ModelAndView AboutPage()
	{
		return new ModelAndView("About");
	}
	
	@RequestMapping("/cont")
	public ModelAndView ContactPage()
	{
		return new ModelAndView("Contact");
	}
	
}
