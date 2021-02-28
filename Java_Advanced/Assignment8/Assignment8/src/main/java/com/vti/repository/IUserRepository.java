package com.vti.repository;


import com.vti.entity.User;

public interface IUserRepository {
	public User getUserByName(String username);
}
