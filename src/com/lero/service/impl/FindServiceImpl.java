package com.lero.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lero.mapper.FindMapper;
import com.lero.model.FindInformation;
import com.lero.model.User;
import com.lero.service.FindService;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("findService")
public class FindServiceImpl implements FindService{

	
	
	@Autowired
	private FindMapper findMapper;

	/**
	 * BookService�ӿ�getAll����ʵ��
	 * @see { BookService }
	 * */
	@Transactional(readOnly=true)
	
	

	@Override
	public List<FindInformation> getMyAllFind1(String loginname) {
		return findMapper.findMyAllFind1(loginname);
	}

	

	@Override
	public void removefind1(int id) {
		// TODO Auto-generated method stub
		findMapper.deleteFind1(id);
	}



	@Override
	public User selectUser1(String loginname) {
		// TODO Auto-generated method stub
		return findMapper.selectuser1(loginname);
	}

	@Override
	public List<FindInformation> getAll1(int a, int b) {
		// TODO Auto-generated method stub
		return findMapper.findAll1(a, b);
	}

	@Override
	public List<FindInformation> getAlllist1() {
		// TODO Auto-generated method stub
		return findMapper.findAlllist1();
	}

	@Override
	public int selectCount1() {
		// TODO Auto-generated method stub
		return findMapper.selectcount1();
	}

	@Override
	public int selectMyCount1(String loginname) {
		// TODO Auto-generated method stub
		return findMapper.selectmycount1(loginname);
	}

	@Override
	public List<FindInformation> getMyAll1(String loginname, int a, int b) {
		// TODO Auto-generated method stub
		return findMapper.findMyALL1(loginname, a, b);
	}



	@Override
	public void savefind(FindInformation find) {
		// TODO Auto-generated method stub
		findMapper.saveFind(find);
	}



	@Override
	public int getId1() {
		// TODO Auto-generated method stub
		return findMapper.getid1();
	}



	@Override
	public List<FindInformation> getmune1(String type, int a, int b) {
		// TODO Auto-generated method stub
		return findMapper.findmune1(type, a, b);
	}



	@Override
	public List<FindInformation> getmymune1(String type, String loginname, int a, int b) {
		// TODO Auto-generated method stub
		return findMapper.findmymnue1(type, loginname, a, b);
	}
	
	
		
}
