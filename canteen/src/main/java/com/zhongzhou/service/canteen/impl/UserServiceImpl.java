package com.zhongzhou.service.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhongzhou.dao.canteen.UserDao;
import com.zhongzhou.entity.canteen.Corporate;
import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.service.canteen.UserService;

/**
 * 用户service  impl
 *
 */
@Service
public class UserServiceImpl implements UserService{

	/**
	 *  注入 dao对象
	 */
	@Autowired
	UserDao userDao;
	
	/**
	 *  查询对象 返回对象
	 */
	@Override
	public User queryUser(User user) {
		return userDao.queryUser(user);
	}
	
	@Override
	public Corporate queryCorporateInfo(){
		return userDao.queryCorporateInfo();
	}
	
	public User queryUserByWeixinid(String weixinid){
		return userDao.queryUserByWeixinid(weixinid);
	}
	public Long insert(User user){
		return userDao.insert(user);
	}

	
	/**
	 *  分页查询用户
	 */
	@Override
	public List<User> queryUserPage(Integer startPage, Integer endPage) {
		return userDao.queryUserPage(startPage, endPage);
	}

	
	/**
	 *	查询用户  总数
	 */
	@Override
	public Long queryUserPageCount() {
		return userDao.queryUserPageCount();
	}

	

	@Override
	public Long deleteId(Integer id) {
		return userDao.deleteId(id);
	}

	
	/**
	 *   查询用户 name
	 */
	@Override
	public List<User> queryUserName(String name, Integer startPage, Integer endPage) {
		return userDao.queryUserName(name, startPage, endPage);
	}

	/**
	 *	查询用户 name 总数
	 */
	@Override
	public Long queryUserNameCount(String name) {
		return userDao.queryUserNameCount(name);
	}

	
	/**
	 *  查询对象 id
	 */
	@Override
	public User queryId(Integer id) {
		return userDao.queryId(id);
	}

	@Override
	public Long update(User record) {
		return userDao.update(record);
	}
	
	
}
