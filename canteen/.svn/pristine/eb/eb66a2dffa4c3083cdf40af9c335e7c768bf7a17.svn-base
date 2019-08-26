package com.zhongzhou.controller.base;


import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.utils.HttpKit;

public class BaseController {

    protected User getUser(){
    	User user = (User) HttpKit.getRequest().getSession().getAttribute("user");
        return user;
    }
    
}
