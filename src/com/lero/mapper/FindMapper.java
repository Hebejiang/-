package com.lero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.lero.model.FindInformation;
import com.lero.model.LostInformation;
import com.lero.model.User;;

/**
 * BookMapper�ӿ�
 * */
public interface FindMapper {

	
	@Select(" select * from finding limit #{a},#{b}")
	List<FindInformation> findAll1(@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from finding")
	List<FindInformation> findAlllist1();
	
	@Select(" select * from finding where findloginname=#{loginname} ")
	List<FindInformation> findMyAllFind1(String loginname);
	
	@Select(" select * from finding where findloginname=#{loginname} limit #{a},#{b}")
	List<FindInformation> findMyALL1(@Param("loginname") String loginname,@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from finding where type=#{type} limit #{a},#{b}")
	List<FindInformation> findmune1(@Param("type") String type,@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from finding where findloginname=#{loginname} and type=#{type} limit #{a},#{b}")
	List<FindInformation> findmymnue1(@Param("type") String type,@Param("loginname") String loginname,@Param("a") int a,@Param("b") int b);
	
	
	@Delete(" delete from finding where findid = #{id} ")
	void deleteFind1(int id);
	
	@Select(" select * from user where loginname=#{loginname}")
	User selectuser1(String loginname);
	
	@Select("select COUNT(*) from finding")
	int selectcount1();
	
	@Select("select COUNT(*) from finding where findloginname=#{loginname}")
	int selectmycount1(@Param("loginname") String loginname);
	
	@Insert("INSERT INTO FINDING(findid,findphoto,findtitle,finddetail,type,findloginname) VALUES(#{findid},#{findphoto},#{findtitle},#{finddetail},#{type},#{findloginname})")
	void saveFind(FindInformation find);
	
	@Select("select MAX(findid) from finding")
	int getid1();
}

