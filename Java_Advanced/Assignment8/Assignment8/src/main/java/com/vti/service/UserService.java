package com.vti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.entity.User;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository repository;
	
	
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		return repository.getUserByName(username);
	}
}
