package com.zhongzhou.controller.canteen;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhou.dto.MenuMessageDto;
import com.zhongzhou.entity.canteen.MenuMessage;
import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.service.canteen.MenuMessageService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;

/**
 *	菜单消息
 */
@RequestMapping(value = "/message")
@Controller
public class MenuMessageController {

	/**
	 *  注入 service对象
	 */
	@Autowired
	MenuMessageService menuMessageService;
	
	
	/**
	 * 
	 * 	查询 菜单消息
	 * @param lr 1工作日 2节假日
	 * @return
	 */
	@RequestMapping(value="/queryMenuMessagePage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryMenuMessagePage(Integer pageNumber, Integer pageSize, Integer lr, HttpSession session,HttpServletRequest request) {

		Integer startPage = (pageNumber - 1) * pageSize;
		Integer endPage = pageSize;
		
		List<MenuMessageDto> list =  menuMessageService.queryMenuMessagePage(lr, startPage, endPage);
		Long count = menuMessageService.queryMenuMessagePageCount(lr);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", list);
		httpResult.setCount(count);
		return httpResult;
	}
	
	
	/**
	 * 
	 *	删除指定id
	 * @param timeSlotId
	 * @return
	 */
	@RequestMapping(value="/deleteMenuMessageId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult deleteMenuMessageId(Integer id, HttpSession session,HttpServletRequest request) {

		Long count = menuMessageService.deleteId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", count);
		
		return httpResult;
	}
	
	
	/**
	 *	添加
	 */
	@RequestMapping(value="/addMessage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult addMessage(MenuMessage menuMessage, HttpSession session,HttpServletRequest request) {

		String wxid = ( (User)session.getAttribute("user") ).getWxid();
		menuMessage.setWxid(wxid);
		
		Long id = menuMessageService.insert(menuMessage);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "添加成功", menuMessage);
		
		return httpResult;
	}
	
	/**
	 *	详情
	 */
	@RequestMapping(value="/messageDetail",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult messageDetail(Integer id, HttpSession session,HttpServletRequest request) {

		MenuMessageDto menuMessageDto = menuMessageService.queryMenuMessageId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", menuMessageDto);
		
		return httpResult;
	}
	
}
