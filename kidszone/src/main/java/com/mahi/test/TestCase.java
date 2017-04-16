package com.mahi.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mahi.config.ApplicationContextConfig;
import com.mahi.dao.AddressDao;
import com.mahi.dao.CartDao;
import com.mahi.dao.CartItemDao;
import com.mahi.dao.CategoryDao;
import com.mahi.dao.ProductDao;
import com.mahi.dao.UserDao;
import com.mahi.model.Address;
import com.mahi.model.Cart;
import com.mahi.model.CartItem;
import com.mahi.model.Category;
import com.mahi.model.Product;
import com.mahi.model.User;

public class TestCase {

	public static void main(String[] args)
	{
	
		@SuppressWarnings({ "resource", "unused" })
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
       
        UserDao userDao=(UserDao)context.getBean("userdao");
  
      /* User userobj=new User();
        
        userobj.setUserName("MAHITHA");
        userobj.setPassword("password");
        userobj.setEmail("mahitha123@gmail.com");
        userobj.setRole("ROLE_ADMIN");
        userobj.setIs_Active(true);
        userobj.setMobile("7893619435");
        
        userDao.addUsers(userobj);
		
		
		*/
/*	CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
		
		Category category = new Category();
		category.setCategoryName("MensWear");
		categoryDAO.newCategory(category);
  */    
        
       
/*		CategoryDao categoryDAO = (CategoryDao) context.getBean("categoryDAO");
		ProductDao productDAO= (ProductDao) context.getBean("productDAO");
		Product product = new Product();
		product.setProductName("Kids Dresses");
		product.setProductPrice(3000);
		product.setQuantity(2);
		product.setStatus(true);
		product.setProductDespription("Good");
		product.setCategory(categoryDAO.getCategory(1));
		productDAO.addProduct(product);
		
	*/	
		
		
	/*	AddressDao addressDAO = (AddressDao) context.getBean("addressDao");
		UserDao userDAO = (UserDao) context.getBean("userdao");
		
		Address address = new Address();
		address.setHouseNo("512");
		address.setStreet("colony");
		address.setCity("Knr");
		address.setState("Telangana");
		address.setCountry("India");
		address.setPin("505001");
		address.setUsers(userDAO.getUser(1));
		addressDAO.addAddress(address);
		
	*/
		
		
	CartItemDao cartItemDao=(CartItemDao)context.getBean("cartItemDao");
		CartDao cartDao=(CartDao)context.getBean("cartDao");
		
		ProductDao productDAO= (ProductDao) context.getBean("productDAO");
		
		Cart cart=new Cart();
		cart.setId(1);
		cart.setUsers(userDao.getUser(1));
		CartItem cartItem=new CartItem();
		cartItem.setCart(cart);
		cartItem.setQuantity(2);
		Product product=productDAO.get(1);
		cartItem.setProduct(product);
		cartItem.setGrandTotal(cartItem.getQuantity()*product.getProductPrice());
		List<CartItem> cartItems=new ArrayList<>();
		cartItems.add(cartItem);
		cart.setCartitems(cartItems);
		cart.setGrandTotal(cartItem.getGrandTotal()+product.getProductPrice());
		cart.setQuantity(cart.getQuantity()+cartItem.getQuantity());
		cartDao.addCart(cart);  
	
	
	}

}
