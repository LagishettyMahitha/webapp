package com.mahi.dao;

import java.util.List;

import com.mahi.model.Address;
import com.mahi.model.User;

public interface AddressDao
{
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(int id);
	public List<Address> getAddress(User user);

}