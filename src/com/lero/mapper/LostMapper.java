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
 * BookMapper锟接匡拷
 * */
public interface LostMapper {

	/**
	 * 锟斤拷询锟斤拷锟斤拷图锟斤拷
	 * @return 图锟斤拷锟斤拷蠹锟�
	 * */
	@Select(" select * from lostting limit #{a},#{b}")
	List<LostInformation> findAll(@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from lostting")
	List<LostInformation> findAlllist();
	
	@Select(" select * from lostting where lostloginname=#{loginname} ")
	List<LostInformation> findMyAllLost(String loginname);
	
	@Select(" select * from lostting where lostloginname=#{loginname} limit #{a},#{b}")
	List<LostInformation> findMyALL(@Param("loginname") String loginname,@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from lostting where type=#{type} limit #{a},#{b}")
	List<LostInformation> findmune(@Param("type") String type,@Param("a") int a,@Param("b") int b);
	
	@Select(" select * from lostting where lostloginname=#{loginname} and type=#{type} limit #{a},#{b}")
	List<LostInformation> findmymnue(@Param("type") String type,@Param("loginname") String loginname,@Param("a") int a,@Param("b") int b);
	
	
	@Delete(" delete from lostting where lostid = #{id} ")
	void deleteLost(int id);
	
	@Select(" select * from user where loginname=#{loginname}")
	User selectuser(String loginname);
	
	@Select("select COUNT(*) from lostting")
	int selectcount();
	
	@Select("select COUNT(*) from lostting where lostloginname=#{loginname}")
	int selectmycount(@Param("loginname") String loginname);
	
	@Insert("INSERT INTO LOSTTING(lostid,lostphoto,losttitle,lostdetail,type,lostloginname) VALUES(#{lostid},#{lostphoto},#{losttitle},#{lostdetail},#{type},#{lostloginname})")
	void saveLost(LostInformation lost);
	
	@Select("select max(lostid) from lostting")
	int getid();
}