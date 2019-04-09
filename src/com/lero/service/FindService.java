package com.lero.service;

import java.util.List;

import com.lero.model.FindInformation;
import com.lero.model.LostInformation;
import com.lero.model.User;;

public interface FindService {
	
	List<FindInformation> getAll1(int a,int b);
	
	List<FindInformation> getAlllist1();
	
	List<FindInformation> getMyAllFind1(String loginname);
	
	List<FindInformation> getmune1(String type,int a,int b);
	
	List<FindInformation> getmymune1(String type ,String loginname,int a, int b);
	
	int selectCount1();
	
	int selectMyCount1(String loginname);
	
	void removefind1(int id);
	
	User selectUser1(String loginname);
	
	List<FindInformation> getMyAll1(String loginname,int a,int b);
	
	void savefind(FindInformation find);
	
	int getId1();
}
