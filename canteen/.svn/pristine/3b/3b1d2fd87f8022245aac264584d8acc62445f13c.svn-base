package com.zhongzhou.controller.canteen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhou.entity.canteen.TimeSlot;
import com.zhongzhou.service.canteen.TimeSlotService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;

/**
 *	 时间类型
 */
@Controller
@RequestMapping(value = "/slot")
public class SlotController {

	
	/**
	 *  注入 service对象
	 */
	@Autowired
	TimeSlotService timeSlotService;
	
	
	/**
	 * 	添加 菜单 
	 * 	参数 : timeSlotId 
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryList(  HttpServletRequest request, HttpSession session) {
		
		List<TimeSlot> list = timeSlotService.queryList();
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", list);
		httpResult.setCount(Long.valueOf(list.size()));
		
		return httpResult;
	}
	
	/**
	 * 	查询 菜单详情 
	 */
	@RequestMapping(value="/queryDetail",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryDetail( Integer id, HttpServletRequest request, HttpSession session) {
		
		TimeSlot timeSlot = timeSlotService.queryId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", timeSlot);
		
		return httpResult;
	}
	
	
	/**
	 * 	添加 菜单 
	 * 	参数 : timeSlotId 
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/update",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult update(TimeSlot timeSlot, HttpServletRequest request, HttpSession session) {
		
		Long count  = timeSlotService.update(timeSlot);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "修改成功", count);
		
		return httpResult;
	}
	
}
