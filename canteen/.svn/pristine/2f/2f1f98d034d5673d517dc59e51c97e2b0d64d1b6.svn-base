package com.zhongzhou.controller.canteen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.service.canteen.UserService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;

/**
 *	用户 Controller
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *  注入 dao对象
	 */
	@Autowired
	UserService userService;
	
	
	/**
	 *	用户分页查询
	 *	参数 : pageNumber 和 pageSize
	 *	返回 : List<User>
	 */
	@RequestMapping(value="/queryUserPage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult queryUserPage(  Integer pageNumber, Integer pageSize) {
		Integer startPage = (pageNumber-1) * pageSize;
		Integer endPage = pageSize;
		
		List<User> list = userService.queryUserPage(startPage, endPage);
		
		Long count =  userService.queryUserPageCount();
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", list);
		httpResult.setCount(count);
		
		return httpResult;
	}
	
	
	/**
	 *	用户分页查询
	 *	参数 : pageNumber 和 pageSize
	 *	返回 : List<User>
	 */
	@RequestMapping(value="/queryUserNamePage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult queryUserNamePage(String name,  Integer pageNumber, Integer pageSize) {
		Integer startPage = (pageNumber-1) * pageSize;
		Integer endPage = pageSize;
		
		List<User> list = userService.queryUserName(name, startPage, endPage);
		
		Long count =  userService.queryUserNameCount(name);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", list);
		httpResult.setCount(count);
		
		return httpResult;
	}
	
	
	/**
	 *	添加用户
	 */
	@RequestMapping(value="/addUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult addUser( User user) {
		Long id  = userService.insert(user);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "添加成功", user);
		return httpResult;
	}
	
	/**
	 *	删除用户
	 */
	@RequestMapping(value="/deleteUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult deleteUser( Integer id) {
		Long value  = userService.deleteId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", value);
		return httpResult;
	}
	
	/**
	 *	查询用户id
	 */
	@RequestMapping(value="/userDetail",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult userDetail( Integer id) {
		User user  = userService.queryId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", user);
		return httpResult;
	}
	
	
	/**
	 *	修改用户
	 */
	@RequestMapping(value="/userUpdate",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody HttpResult userUpdate( User user) {
		Long count  = userService.update(user);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "修改成功", user);
		return httpResult;
	}
	
	
}
