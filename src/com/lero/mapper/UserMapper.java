package com.lero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.lero.model.User;

/**
 * BookMapper�ӿ�
 * */
public interface UserMapper {

	@Select("select * from user where loginname = #{loginname} and password = #{password}")
	User findWithLoginnameAndPassword(@Param("loginname")String loginname,
			@Param("password") String password);
	
	
	@Select("select * from user where loginname = #{loginname}")
	User boolz(@Param("loginname")String loginname);
	
	@Insert("INSERT INTO USER(loginname,password,name,mailbox,phonenumber) VALUES(#{loginname},#{password},#{name},#{mailbox},#{phonenumber})")
	void saveUser(User user);
}

