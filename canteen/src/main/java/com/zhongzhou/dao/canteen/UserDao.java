package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.Corporate;
import com.zhongzhou.entity.canteen.User;

/**
 * 用户dao
 */
@Repository
public interface UserDao  extends SelfMapper<User, Integer>{
	
	/**
	 *  查询对象 返回对象
	 */
	User queryUser(User user);
	
	/**
	 *	查询用户  总数
	 */
	Long queryUserPageCount();
	
	/**
	 *  分页查询用户
	 */
	List<User> queryUserPage(@Param("startPage")Integer startPage, @Param("endPage")Integer endPage);
	
	/**
	 *   查询用户 name
	 */
	List<User> queryUserName(@Param("name")String  name , @Param("startPage")Integer startPage, @Param("endPage")Integer endPage);

	/**
	 *	查询用户 name 总数
	 */
	Long queryUserNameCount(@Param("name")String  name);
	
	

	Corporate queryCorporateInfo();
	
	User queryUserByWeixinid(String weixinid);

	@Override
	User queryId(@Param("id")Integer id);

	@Override
	Long update(User record);
	
	

}
