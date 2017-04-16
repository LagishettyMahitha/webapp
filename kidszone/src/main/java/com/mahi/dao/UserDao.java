package com.mahi.dao;

import java.util.List;

import com.mahi.model.User;

public interface UserDao
{
	public boolean addUsers(User user);
	public User getUser(int id);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public User getUserNameByUserName(String username);
	public User getUserByEmail(String email);
	
}
