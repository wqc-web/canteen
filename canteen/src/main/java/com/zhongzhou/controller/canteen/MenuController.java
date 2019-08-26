package com.zhongzhou.controller.canteen;

import com.zhongzhou.dto.MenuDto;
import com.zhongzhou.dto.MenuFeedbackDto;
import com.zhongzhou.dto.MenuSelectDto;
import com.zhongzhou.dto.WeeklyMenuDto;
import com.zhongzhou.entity.canteen.Menu;
import com.zhongzhou.entity.canteen.MenuFeedback;
import com.zhongzhou.entity.canteen.MenuList;
import com.zhongzhou.entity.canteen.TimeSlot;
import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.entity.canteen.WeeklyMenuList;
import com.zhongzhou.service.canteen.MenuListService;
import com.zhongzhou.service.canteen.MenuService;
import com.zhongzhou.service.canteen.WeeklyMenuListService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {

	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *  注入 dao对象
	 */
	@Autowired
	MenuService menuService;
	
	@Autowired
	WeeklyMenuListService weeklyMenuListService;
	
	@Autowired
	MenuListService menuListService;
	
	
	//首页
	@RequestMapping(value="/jumpHome",method={RequestMethod.POST,RequestMethod.GET})
	public String jumpHome(ModelMap mm,HttpSession session,HttpServletRequest request){
		Object url = session.getAttribute("BASE_URL");
		if(url!=null && url!=""){
			return "system/index";
		}else{
			return "../login";
		}

	}

	//每周菜谱
	@RequestMapping(value="/week/list.html",method={RequestMethod.POST,RequestMethod.GET})
	public String weekList(ModelMap mm, HttpSession session, HttpServletRequest request){
		return "view/week/list";
	}

	//每周菜谱
	@RequestMapping(value="/week/edit",method={RequestMethod.POST,RequestMethod.GET})
	public String weekEdit(ModelMap mm, Integer timeSlotId,Integer weeklyId) {
		if(timeSlotId!=null){
			mm.addAttribute("timeSlotId",timeSlotId);
		}
		if(weeklyId!=null){
			mm.addAttribute("weeklyId",weeklyId);
		}
		return "view/week/edit";
	}

	//留言管理
	@RequestMapping(value="/message/list.html",method={RequestMethod.POST,RequestMethod.GET})
	public String messageList(ModelMap mm, HttpSession session, HttpServletRequest request){
		return "view/message/list";
	}

	//留言详情
	@RequestMapping(value="/message/details",method={RequestMethod.POST,RequestMethod.GET})
	public String messageDetails(ModelMap mm,Integer id){
		if(id!=null){
			mm.addAttribute("id",id);
		}
		return "view/message/details";
	}

	//排名管理
	@RequestMapping(value="/ranking/list.html",method={RequestMethod.POST,RequestMethod.GET})
	public String rankingList(ModelMap mm, HttpSession session, HttpServletRequest request){
		return "view/ranking/list";
	}

	//菜单管理
	@RequestMapping(value="/menu/list.html",method={RequestMethod.POST,RequestMethod.GET})
	public String menuList(ModelMap mm, HttpSession session, HttpServletRequest request){
		return "view/menu/list";
	}

	//添加/修改菜单管理
	@RequestMapping(value="/menu/edit",method={RequestMethod.POST,RequestMethod.GET})
	public String editMenu(ModelMap mm,Integer id,String menuTypeId,String name,String pictureUrl){
		if(id!=null){
			mm.addAttribute("id",id);
		}
        if(menuTypeId!=null && menuTypeId!=""){
            mm.addAttribute("menuTypeId",menuTypeId);
        }
		if(name!=null && name!=""){
			mm.addAttribute("name",name);
		}
		if(pictureUrl!=null && pictureUrl!=""){
			mm.addAttribute("pictureUrl",pictureUrl);
		}
		return "view/menu/edit";
	}

	//人员管理
	@RequestMapping(value="/user/list.html",method={RequestMethod.POST,RequestMethod.GET})
	public String userList(ModelMap mm, HttpSession session, HttpServletRequest request){
		return "view/user/list";
	}

	//添加/修改人员管理
	@RequestMapping(value="/user/edit",method={RequestMethod.POST,RequestMethod.GET})
	public String eiitUser(ModelMap mm,Integer id){
		if(id!=null){
			mm.addAttribute("id",id);
		}
		return "view/user/edit";
	}
	
	
	//时间管理页面
	@RequestMapping(value="/slot/jumpSlot",method={RequestMethod.POST,RequestMethod.GET})
	public String jumpSlot(ModelMap mm,HttpSession session,HttpServletRequest request){
		
		return "view/slot/list";
	}
	
	//修改时间管理
	@RequestMapping(value="/slot/editSlot",method={RequestMethod.POST,RequestMethod.GET})
	public String editSlot(ModelMap mm,Integer id){
		if(id!=null){
			mm.addAttribute("id",id);
		}
		return "view/slot/edit";
	}
	
	//版本历史
	@RequestMapping(value="/version",method={RequestMethod.POST,RequestMethod.GET})
	public String version(ModelMap mm,Integer id){
		return "view/version";
	}
	
	//通知管理页面
	@RequestMapping(value="/notice/jumpNotice",method={RequestMethod.POST,RequestMethod.GET})
	public String jumpNotice(ModelMap mm,HttpSession session,HttpServletRequest request){
		
		return "view/notice/list";
	}
	
	//修改通知管理
	@RequestMapping(value="/notice/editNotice",method={RequestMethod.POST,RequestMethod.GET})
	public String editNotice(ModelMap mm,Integer id){
		if(id!=null){
			mm.addAttribute("id",id);
		}
		return "view/notice/edit";
	}

	/**
	 *	查询菜单Dto 
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryMenuTypeIsMenu",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<MenuDto> queryMenuTypeIsMenu(Integer menuTypeId) {
		return menuService.queryMenuTypeIsMenu(menuTypeId);
	}
	
	
	/**
	 *	查询菜单Dto 分页
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryMenuTypeIsMenuPage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<MenuDto> queryMenuTypeIsMenuPage(Integer timeSlotId, Integer menuTypeId , Integer pageNumber, Integer pageSize ,String menuName) {
		Integer pageStart = (pageNumber-1) * pageSize;
		return menuService.queryMenuTypeIsMenuPage(timeSlotId, menuTypeId, pageStart, pageSize , menuName);
	}
	
	/**
	 *	查询菜单Dto 分页
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryMenuTypeIsMenuCount",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public Integer queryMenuTypeIsMenuCount(Integer timeSlotId, Integer menuTypeId ,String menuName) {
		return menuService.queryMenuTypeIsMenuCount(timeSlotId, menuTypeId , menuName);
	}
	
	/**
	 *	查询周几菜单Dto 
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryWeeklyMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<MenuDto> queryWeeklyMenuList(Integer timeSlotId, Integer menuTypeId, Integer weeklyId) {
		return menuService.queryWeeklyMenuList(timeSlotId, menuTypeId, weeklyId);
	}
	
	/**
	 *	每周菜谱 修改 显示数据
	 * 	查询指定星期 时间段 
	 * 	参数 : timeSlotId  和 weeklyId
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryWeeklySlotMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<MenuDto> queryWeeklySlotMenuList(Integer timeSlotId, Integer weeklyId) {
		return menuService.queryWeeklySlotMenuList(timeSlotId, weeklyId);
	}
	
	/**
	 *	添加周几菜单列表数据
	 */
	@RequestMapping(value="/addWeeklyMenuListObj",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult addWeeklyMenuListObj(WeeklyMenuList weeklyMenuList) {
		menuService.addWeeklyMenuListObj(weeklyMenuList);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "添加成功" , weeklyMenuList);
		
		return httpResult;
	}
	
	/**
	 *	删除周几菜单列表 id
	 */
	@RequestMapping(value="/deleteWeeklyMenuListId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult deleteWeeklyMenuListId(Integer id) {
		Long count = menuService.deleteWeeklyMenuListId(id);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", count);
		
		return httpResult;
	}
	
	
	/**
	 * 	查询指定星期 时间段  菜单名称
	 * 	参数 : timeSlotId 和  weeklyId 和 menuName
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/queryWeeklyMenuName",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryWeeklyMenuName(Integer timeSlotId, Integer weeklyId, String menuName) {
		List<MenuDto> dataList = menuService.queryWeeklyMenuName(timeSlotId, weeklyId, menuName);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", dataList);
		
		return httpResult;
	}
	
	
	
	/**
	 * 	每周菜谱页面 数据
	 * 	参数 : timeSlotId 
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/weeklyMenuPage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult weeklyMenuPage(Integer timeSlotId) {

		List<WeeklyMenuDto> dataList =  menuService.weeklyMenuPageList(timeSlotId);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", dataList);
		
		return httpResult;
	}
	
	
	/**
	 * 	删除周几菜单列表 Obj
	 * 	参数 : timeSlotId 
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/deleteWeeklyMenuListObj",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult deleteWeeklyMenuListObj(WeeklyMenuList weeklyMenuList) {

		Long count =  menuService.deleteWeeklyMenuListObj(weeklyMenuList);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", count);
		
		return httpResult;
	}
	
	/**
	 * 	添加 菜单 
	 * 	参数 : timeSlotId 
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/addMenu",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult addMenu( String menuPicUrl, String menuName,  BigDecimal menuPrice, Integer menuTypeId,  HttpServletRequest request, HttpSession session) {
		
		MenuDto menuDto =  menuService.addMenu(menuName, menuPicUrl, menuPrice, menuTypeId);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "添加成功", menuDto);
		
		
		return httpResult;
	}
	
	/**
	 * 	修改菜单 
	 * 	参数 :  
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/updateMenu",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult updateMenu(Menu menu, Integer menuTypeId,  HttpServletRequest request, HttpSession session) {
		
		Long count =  menuService.updateMenu(menu);
		
		//修改对应的菜单列表
		MenuList menuList =menuListService.queryMenuId(menu.getId());
		menuList.setMenuTypeId(menuTypeId);
		menuListService.update(menuList);
		
		weeklyMenuListService.updateMenuTypeId(menuTypeId, menu.getId());
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "修改成功", count);
		
		
		return httpResult;
	}
	
	
	/**
	 * 	删除菜单 
	 * 	参数 :  
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/deleteMenuId",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult deleteMenuId(Integer menuId,  HttpServletRequest request, HttpSession session) {
		
		String content =  menuService.deleteMenuId(menuId);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", content);
		
		
		return httpResult;
	}
	
	/**
	 * 	清空  指定星期 和 时间段的 关联数据
	 * 	参数 :  
	 *	返回 : List<MenuDto>
	 */
	@RequestMapping(value="/clearWeeklyMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult clearWeeklyMenuList(Integer weeklyId, Integer timeSlotId,  HttpServletRequest request, HttpSession session) {
		
		WeeklyMenuList weeklyMenuList = new WeeklyMenuList();
		weeklyMenuList.setWeeklyId(weeklyId);
		weeklyMenuList.setTimeSlotId(timeSlotId);
		
		Long count =  weeklyMenuListService.deleteObj(weeklyMenuList);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "删除成功", count);
		
		
		return httpResult;
	}
	
	
	
	
	
	/**
	 * 	每周菜单页面 修改
	 * 	参数 :  
	 *	返回 : count
	 */
	@RequestMapping(value="/updateWeeklyMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult updateWeeklyMenuList(Integer weeklyId, Integer timeSlotId, String menuIdStr,  HttpServletRequest request, HttpSession session) {
		
		String[] menuIdArr = null ;
		if(menuIdStr != null &&  !"".equals(menuIdStr)) {
			menuIdArr = menuIdStr.split(",");
		}
		
		Long count =  menuService.updateWeeklyMenuList(weeklyId, timeSlotId, menuIdArr);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "修改成功", count);
		
		
		return httpResult;
	}
	
	
	/**
	 * 	查询 哪个时间段
	 * 	参数 :  
	 *	返回 : count
	 */
	@RequestMapping(value="/queryTimeSlot",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult queryTimeSlot(HttpServletRequest request, HttpSession session) {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		TimeSlot timeSlot = menuService.queryTimeSlot(sdf.format(date));
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", timeSlot);
		
		
		return httpResult;
	}
	
	/**
	 *	查询修改菜单 列表  
	 *	参数 : timeSlotId  weeklyId
	 *	返回 : List<MenuSelectDto>
	 */
	@RequestMapping(value="/querySelectMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult querySelectMenuList(Integer weeklyId, Integer timeSlotId , HttpServletRequest request, HttpSession session) {
		
		List<MenuSelectDto>  list = menuService.querySelectMenuList(timeSlotId, weeklyId);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", list);
		
		
		return httpResult;
	}
	
	/**
	 * 	app 菜单页面
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appMenuList",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult appMenuList(Integer timeSlotId, Integer menuTypeId, Integer weeklyId,  String goodTime,  HttpServletRequest request, HttpSession session) {
		
		String wxid = ( (User)session.getAttribute("user") ).getWxid();
		
		List<MenuFeedbackDto> listData = menuService.appMenuList(timeSlotId, menuTypeId, weeklyId, wxid, goodTime);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", listData);
		
		
		return httpResult;
	}
	
	
	/**
	 * 	app 菜单页面分页
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appMenuListPage",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult appMenuListPage(Integer timeSlotId, Integer menuTypeId, Integer weeklyId, 
									 String goodTime, Integer pageNumber , Integer pageSize,  
									HttpServletRequest request, HttpSession session) {
		
		String wxid = ( (User)session.getAttribute("user") ).getWxid();
		
		Integer startPage = (pageNumber-1) * pageSize;
		Integer endPage = pageSize;
		
		List<MenuFeedbackDto> listData = menuService.appMenuListPage(timeSlotId, menuTypeId, weeklyId, wxid, goodTime, startPage, endPage);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "查询成功", listData);
		
		
		return httpResult;
	}
	
	
	/**
	 * 	app 菜单页面点赞
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appMenuClickGood",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public HttpResult appMenuClickGood(Integer menuId,  String goodTime , Integer goodState ,
									HttpServletRequest request, HttpSession session) {
		String wxid = ( (User)session.getAttribute("user") ).getWxid();
	 
		MenuFeedback menuFeedback =  menuService.appMenuClickGood(menuId, wxid, goodTime, goodState);
		
		HttpResult httpResult = new HttpResult(Consts.Code_Success, "点击成功", menuFeedback);
		
		
		return httpResult;
	}
	
	/**
	 * 	appJumpMenu
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appJumpMenu",method={RequestMethod.POST,RequestMethod.GET})
	public String appJumpMenu(HttpServletRequest request, HttpSession session) {
		
		
		return "app/appindex";
	}
	
	
	/**
	 * 	appJumpMessage
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appJumpMessage",method={RequestMethod.POST,RequestMethod.GET})
	public String appJumpMessage(HttpServletRequest request, HttpSession session) {
		
		
		return "app/appmessage";
	}
	
	/**
	 * 	appJumpRank
	 * 	参数 :  
	 *	返回 : List<MenuFeedbackDto>
	 */
	@RequestMapping(value="/appJumpRank",method={RequestMethod.POST,RequestMethod.GET})
	public String appJumpRank(HttpServletRequest request, HttpSession session) {
		
		
		return "app/apprank";
	}
	
}
