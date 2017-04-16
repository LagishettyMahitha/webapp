package com.mahi.dao;

import com.mahi.model.Cart;

public interface CartDao 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean resetCart(int id);

}

