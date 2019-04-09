package com.lero.service;

import com.lero.model.User;

public interface UserService {
	User login(String loginname,String password);
	
	User boolZ(String loginname);
	
	void saveuser(User user);
}
