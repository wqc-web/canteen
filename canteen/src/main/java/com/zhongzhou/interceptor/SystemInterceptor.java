package com.zhongzhou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhongzhou.entity.canteen.User;

/**
 * 系统拦截器
 * 验证登录情况
 */

public class SystemInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception err)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView mav) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

    	
//    	return true;
    	
        return isLogin(request, response, obj);

    }
    
    
    /**
     *	判断是否登录
     */
    public boolean isLogin(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception{
    	
    	//response.get
    	
    	String path = request.getContextPath();
        String BASE_URL = path+"/";
       
        request.getSession().setAttribute("BASE_URL",BASE_URL);
        //判断是否登录
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            return true;
            
        }else {
            String basePath = request.getContextPath();
            response.sendRedirect(basePath+"/login");
        }
        return false;
    }
    
}
