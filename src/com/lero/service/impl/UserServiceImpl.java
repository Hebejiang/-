package com.lero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lero.mapper.UserMapper;
import com.lero.model.User;
import com.lero.service.UserService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper usermapper;
	
	@Transactional(readOnly=true)
	public User login(String loginname, String password) {
		
		return usermapper.findWithLoginnameAndPassword(loginname, password);
	}

	@Override
	public User boolZ(String loginname) {
		// TODO Auto-generated method stub
		return usermapper.boolz(loginname);
	}

	@Override
	public void saveuser(User user) {
		usermapper.saveUser(user);
		
	}

	
	
}
