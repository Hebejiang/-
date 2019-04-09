package com.lero.service;

import java.util.List;

import com.lero.model.FindInformation;
import com.lero.model.LostInformation;
import com.lero.model.User;

public interface LostService {
	List<LostInformation> getAll(int a,int b);
	
	List<LostInformation> getAlllist();
	
	List<LostInformation> getmune(String type,int a,int b);
	
	List<LostInformation> getmymune(String type ,String loginname,int a, int b);
	
	int selectCount();
	
	int selectMyCount(String loginname);
	
	List<LostInformation> getMyAllLost(String loginname);
	
	List<LostInformation> getMyAll(String loginname,int a,int b);
	
	void removelost(int id);
	
	User selectUser(String loginname);
	
	void savelost(LostInformation lost);
	
	int getId();
}
