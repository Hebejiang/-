package com.lero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lero.mapper.FindMapper;
import com.lero.mapper.LostMapper;
import com.lero.model.FindInformation;
import com.lero.model.LostInformation;
import com.lero.model.User;
import com.lero.service.FindService;
import com.lero.service.LostService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("lostService")
public class LostServiceImpl implements LostService{

	@Autowired
	private LostMapper lostMapper;
	
	@Override
	public List<LostInformation> getMyAllLost(String loginname) {
		// TODO Auto-generated method stub
		return lostMapper.findMyAllLost(loginname);
	}

	@Override
	public void removelost(int id) {
		lostMapper.deleteLost(id);
		
	}

	

	/**
	 * BookService�ӿ�getAll����ʵ��
	 * @see { BookService }
	 * */
	@Transactional(readOnly=true)
	
	public List<LostInformation> getAll(int a,int b) {
		
		return lostMapper.findAll(a,b);
	}

	@Override
	public List<LostInformation> getAlllist() {
		// TODO Auto-generated method stub
		return lostMapper.findAlllist();
	}

	@Override
	public User selectUser(String loginname) {
		// TODO Auto-generated method stub
		return lostMapper.selectuser(loginname);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return lostMapper.selectcount();
	}

	@Override
	public List<LostInformation> getMyAll(String loginname, int a, int b) {
		// TODO Auto-generated method stub
		return lostMapper.findMyALL(loginname, a, b);
	}

	@Override
	public int selectMyCount(String loginname) {
		// TODO Auto-generated method stub
		return lostMapper.selectmycount(loginname);
	}

	@Override
	public void savelost(LostInformation lost) {
		lostMapper.saveLost(lost);
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return lostMapper.getid();
	}

	@Override
	public List<LostInformation> getmune(String type,int a,int b) {
		// TODO Auto-generated method stub
		return lostMapper.findmune(type, a, b);
	}

	@Override
	public List<LostInformation> getmymune(String type,String loginname, int a, int b) {
		// TODO Auto-generated method stub
		return lostMapper.findmymnue(type, loginname, a, b);
	}

	
	
	
		
}