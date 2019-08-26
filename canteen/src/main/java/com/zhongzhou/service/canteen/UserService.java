package com.zhongzhou.service.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhongzhou.entity.canteen.Corporate;
import com.zhongzhou.entity.canteen.User;

/**
 * 用户service  
 *
 */
public interface UserService {

	/**
	 *  查询对象 返回对象
	 */
	User queryUser(User user);
	
	/**
	 *  查询对象 id
	 */
	User queryId(Integer id);
	
	
	Corporate queryCorporateInfo();
	
	User queryUserByWeixinid(String weixinid);
	
	Long insert(User user);
	
	
	/**
	 *  分页查询用户
	 */
	List<User> queryUserPage( Integer startPage,  Integer endPage);
	
	/**
	 *	查询用户  总数
	 */
	Long queryUserPageCount();
	
	Long deleteId(Integer id);
	
	
	/**
	 *   查询用户 name
	 */
	List<User> queryUserName(String  name , Integer startPage, Integer endPage);
	
	
	/**
	 *	查询用户 name 总数
	 */
	Long queryUserNameCount(String  name);
	
	Long update(User record);
	
}


