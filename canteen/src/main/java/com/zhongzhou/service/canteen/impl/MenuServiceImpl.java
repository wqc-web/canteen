package com.zhongzhou.service.canteen.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.holders.StringHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.tools.internal.ws.processor.model.Model;
import com.zhongzhou.dao.canteen.MenuDao;
import com.zhongzhou.dao.canteen.MenuListDao;
import com.zhongzhou.dao.canteen.MenuTypeDao;
import com.zhongzhou.dao.canteen.TimeSlotDao;
import com.zhongzhou.dao.canteen.WeeklyDao;
import com.zhongzhou.dao.canteen.WeeklyMenuListDao;
import com.zhongzhou.dto.MenuDto;
import com.zhongzhou.dto.MenuFeedbackDto;
import com.zhongzhou.dto.MenuSelectDto;
import com.zhongzhou.dto.MenuTypeDto;
import com.zhongzhou.dto.WeeklyMenuDto;
import com.zhongzhou.entity.canteen.Menu;
import com.zhongzhou.entity.canteen.MenuFeedback;
import com.zhongzhou.entity.canteen.MenuList;
import com.zhongzhou.entity.canteen.TimeSlot;
import com.zhongzhou.entity.canteen.Weekly;
import com.zhongzhou.entity.canteen.WeeklyMenuList;
import com.zhongzhou.service.canteen.MenuService;
import com.zhongzhou.dao.canteen.MenuFeedbackDao;

/**
 *	菜单 service impl
 */
@Service
public class MenuServiceImpl implements MenuService{
	
	public MenuServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *  注入 dao对象
	 */
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	WeeklyMenuListDao weeklyMenuListDao;
	
	@Autowired
	MenuTypeDao menuTypeDao;
	
	@Autowired
	WeeklyDao weeklyDao;
	
	@Autowired
	MenuListDao menuListDao;
	
	@Autowired
	MenuFeedbackDao menuFeedbackDao;
	
	@Autowired
	TimeSlotDao timeSlotDao;
	
	
	
	
	/**
	 *	查询菜单Dto 
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	public List<MenuDto> queryMenuTypeIsMenu( Integer menuTypeId){
		return menuDao.queryMenuTypeIsMenu( menuTypeId);
	}
	
	
	/**
	 *	查询菜单Dto Page 
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@Override
	public List<MenuDto> queryMenuTypeIsMenuPage(Integer timeSlotId, Integer menuTypeId, Integer pageStart,
			Integer pageSize, String menuName) {
		return menuDao.queryMenuTypeIsMenuPage(timeSlotId, menuTypeId, pageStart, pageSize ,  menuName);
	}

	
	/**
	 *	查询菜单Dto count
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	@Override
	public Integer queryMenuTypeIsMenuCount(Integer timeSlotId, Integer menuTypeId ,String menuName) {
		return menuDao.queryMenuTypeIsMenuCount(timeSlotId, menuTypeId , menuName);
	}
	
	/**
	 * 	查询指定星期 时间段  菜单类型
	 * 	参数 : timeSlotId 和 menuTypeId 和 weeklyId
	 *	返回 : List<MenuDto>
	 */
	@Override
	public List<MenuDto> queryWeeklyMenuList(Integer timeSlotId, Integer menuTypeId, Integer weeklyId) {
		return menuDao.queryWeeklyMenuList(timeSlotId, menuTypeId, weeklyId);
	}


	/**
	 *	添加周几菜单列表数据
	 */
	@Override
	public Long addWeeklyMenuListObj(WeeklyMenuList weeklyMenuList) {
		return weeklyMenuListDao.insert(weeklyMenuList);
	}


	/**
	 *	删除周几菜单列表 id
	 */
	@Override
	public Long deleteWeeklyMenuListId(Integer id) {
		return weeklyMenuListDao.deleteId(id);
	}

	/**
	 * 	查询指定星期 时间段  菜单名称
	 * 	参数 : timeSlotId 和  weeklyId 和 menuName
	 *	返回 : List<MenuDto>
	 */
	@Override
	public List<MenuDto> queryWeeklyMenuName(Integer timeSlotId, Integer weeklyId, String menuName) {
		return menuDao.queryWeeklyMenuName(timeSlotId, weeklyId, menuName);
	}


	/**
	 *	每周菜谱页面 数据
	 * @param timeSlotId
	 * @return
	 */
	@Override
	public List<WeeklyMenuDto> weeklyMenuPageList(Integer timeSlotId) {
		
		//菜单类型list
		List<MenuTypeDto> menuTypeDtoList = menuTypeDao.querySlotId(timeSlotId);
		
		//所有星期
		List<Weekly> weeklyList =  weeklyDao.queryIdAsc();
		
		
		//返回的页面数据
		List<WeeklyMenuDto> weeklyMenuDtoList = new ArrayList<WeeklyMenuDto>();
		
		
		//星期 
		for (int i = 0; i < weeklyList.size(); i++) {
			
			//周几对象
			Weekly weekly = weeklyList.get(i);
			
			Integer weeklyId =  weekly.getId();
			
			//创建返回的对象
			WeeklyMenuDto weeklyMenuDto = new WeeklyMenuDto();
			
			//赋值 周几
			weeklyMenuDto.setWeekly(weekly);
			
			//菜单类型  下的  菜单集合
			Map map = new HashMap();
			
			//菜单类型
			for (int j = 0; j < menuTypeDtoList.size(); j++) {
				
				MenuTypeDto menuTypeDto = menuTypeDtoList.get(j);
				Integer menuTypeId = menuTypeDto.getMenuTypeId();
				String menuTypeName = menuTypeDto.getMenuTypeName();
				
				List<MenuDto> menuDtoList =  menuDao.queryWeeklyMenuList(timeSlotId, menuTypeId, weeklyId);
				
				String menuNameArr = "";
				
				for (int k = 0; k < menuDtoList.size(); k++) {
					menuNameArr += menuDtoList.get(k).getMenuName();
					
					if(k < menuDtoList.size()-1) {
						menuNameArr += "、";
					}
				}
				
				map.put(menuTypeName, menuNameArr);
			}
			
			weeklyMenuDto.setMap(map);
			
			//添加
			weeklyMenuDtoList.add(weeklyMenuDto);
		}
		
		
		return weeklyMenuDtoList;
	}


	/**
	 * 	查询指定星期 时间段 
	 * 	参数 : timeSlotId  和 weeklyId
	 *	返回 : List<MenuDto>
	 */
	@Override
	public List<MenuDto> queryWeeklySlotMenuList(Integer timeSlotId, Integer weeklyId) {
		return menuDao.queryWeeklySlotMenuList(timeSlotId, weeklyId);
	}


	/**
	 *	删除周几菜单列表 Obj
	 */
	@Override
	public Long deleteWeeklyMenuListObj(WeeklyMenuList weeklyMenuList) {
		return weeklyMenuListDao.deleteObj(weeklyMenuList);
	}


	/**
	 *	添加菜单
	 */
	@Override
	public MenuDto addMenu(String menuName, String menuPicUrl, BigDecimal menuPrice, Integer menuTypeId) {
		
		Menu menu = new Menu( menuName,  menuPicUrl,  menuPrice);
		Long menuCount = menuDao.insert(menu);
		
		Integer menuId = menu.getId();
		
		MenuList menuList = new MenuList( menuTypeId,  menuId);
		Long menuListCount = menuListDao.insert(menuList);
		
		Integer menuListId =  menuList.getId();
		
		
		//创建返回对象
		MenuDto dto = new MenuDto();
		dto.setMenuName(menuName);
		dto.setMenuPicUrl(menuPicUrl);
		dto.setMenuPrice(menuPrice);
		dto.setMenuTypeId(menuTypeId);
		dto.setMenuId(menuId);
		dto.setMenuListId(menuListId);
		
		return dto;
	}


	/**
	 * 	删除 菜单 
	 *	删除 :  menu,  menu_list , weekly_menu_list , menu_feedback
	 */
	@Override
	public String deleteMenuId(Integer menuId) {
		
		//menu_list
		MenuList menuList = new MenuList();
		menuList.setMenuId(menuId);
		menuListDao.deleteObj(menuList);
		
		//weekly_menu_list
		WeeklyMenuList weeklyMenuList = new WeeklyMenuList();
		weeklyMenuList.setMenuId(menuId);
		weeklyMenuListDao.deleteObj(weeklyMenuList);
		
		//menu_feedback
		MenuFeedback menuFeedback  = new MenuFeedback();
		menuFeedback.setMenuId(menuId);
		menuFeedbackDao.deleteObj(menuFeedback);
		
		//menu
		menuDao.deleteId(menuId);
		
		return "success";
	}


	/**
	 *	根据id查询对象 修改
	 */
	@Override
	public Long updateMenu(Menu record) {
		return menuDao.update(record);
	}


	
	/**
	 * 	app 菜单页面分页
	 */
	@Override
	public List<MenuFeedbackDto> appMenuListPage(Integer timeSlotId, Integer menuTypeId, Integer weeklyId, String wxid,
			String goodTime, Integer startPage, Integer endPage) {
		return menuDao.appQueryWeeklyMenuListPage(timeSlotId, menuTypeId, weeklyId, wxid, goodTime, startPage, endPage);
	}


	/**
	 * 	app 菜单页面
	 */
	@Override
	public List<MenuFeedbackDto> appMenuList(Integer timeSlotId, Integer menuTypeId, Integer weeklyId, String wxid,
			String goodTime) {
		return menuDao.appQueryWeeklyMenuList(timeSlotId, menuTypeId, weeklyId, wxid, goodTime);
	}


	/**
	 * 	app 菜单页面 点赞
	 */
	@Override
	public MenuFeedback appMenuClickGood(Integer menuId, String wxid, String goodTime , Integer goodState) {
		
		//查询是否点击过
		Long count =  menuFeedbackDao.queryMenuFeedbackIsExist(goodTime, menuId, wxid);
		
		//存在
		if(count>0) {
			MenuFeedback menuFeedback = menuFeedbackDao.queryMenuFeedbackObj(null, null, goodTime, menuId, wxid);
			
			Integer goodStateQ =  menuFeedback.getGoodState();
			
			//1好评 2差评
			if(goodStateQ == 1 || goodStateQ == 2) {
				
				//取消点击
				if(goodStateQ == goodState) {
					menuFeedback.setGoodState(-1);
				}else {
					menuFeedback.setGoodState(goodState);
				}
				
			}else{
				menuFeedback.setGoodState(goodState);
			}
			
			menuFeedbackDao.update(menuFeedback);
			
			return menuFeedback;
			
		//不存在
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date goodTimeDate = null;
			try {
				goodTimeDate = sdf.parse(goodTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MenuFeedback menuFeedback = new MenuFeedback(goodState, goodTimeDate, menuId, wxid);
			menuFeedbackDao.insert(menuFeedback);
			
			return menuFeedback;
		}
		
	}

	

	/**
	 *	根据weeklyId timeSlotId menuId 进行修改
	 */
	@Override
	public Long updateWeeklyMenuList(Integer weeklyId, Integer timeSlotId, String[] menuIdArr) {
		
		//删除 指定 时间段 和 周几的 菜单列表信息
		weeklyMenuListDao.deleteWeeklyAndTimeslot(weeklyId, timeSlotId);
		
		//如果没有传递的menuId 直接返回
		if(menuIdArr == null || menuIdArr.length == 0) {
			return null;
		}
		
		Long count = Long.valueOf( menuIdArr.length );
		
		for (int i = 0; i < menuIdArr.length; i++) {
			Integer menuId = Integer.valueOf(menuIdArr[i]);
			
			MenuList menuList =  menuListDao.queryMenuId(menuId);
			Integer menuTypeId = menuList.getMenuTypeId();
			
			
			WeeklyMenuList weeklyMenuList = new WeeklyMenuList( weeklyId,  timeSlotId,  menuTypeId,  menuId);
			weeklyMenuListDao.insert(weeklyMenuList);
		}
		 
		
		
		return count;
	}


	/**
	 * 	查询 哪个时间段
	 * @param time
	 * @return
	 */
	@Override
	public TimeSlot queryTimeSlot(String time) {
		return timeSlotDao.queryTimeSlot(time);
	}

	/**
	 *	查询修改菜单 列表  
	 *	参数 : timeSlotId  weeklyId
	 *	返回 : List<MenuSelectDto>
	 */
	@Override
	public List<MenuSelectDto> querySelectMenuList(Integer timeSlotId , Integer weeklyId) {
		
		List<MenuSelectDto> menuSelectDtoList = new ArrayList<>();
		
		//查询指定时间段的菜单类型
		List<MenuTypeDto> menuTypeDtoList = menuTypeDao.querySlotId(timeSlotId);
		for (int i = 0; i < menuTypeDtoList.size(); i++) {
			MenuTypeDto menuTypeDto = menuTypeDtoList.get(i);
			Integer menuTypeId = menuTypeDto.getMenuTypeId();
			String menuTypeName = menuTypeDto.getMenuTypeName();
			
			MenuSelectDto menuSelectDto = new MenuSelectDto(); 
			menuSelectDto.setWeeklyId(weeklyId);
			menuSelectDto.setTimeSlotId(timeSlotId);
			menuSelectDto.setMenuTypeId(menuTypeId);
			menuSelectDto.setName(menuTypeName);
			menuSelectDto.setType("optgroup");
			
			menuSelectDtoList.add(menuSelectDto);
			
			//查询指定 菜单类型 的菜单
			List<MenuDto> menuDtoList = menuDao.queryMenuAllMenuTypeId( menuTypeId );
			for (int j = 0; j < menuDtoList.size(); j++) {
				MenuDto menuDto  = menuDtoList.get(j);
				Integer menuId = menuDto.getMenuId();
				String menuName = menuDto.getMenuName();
				
				MenuSelectDto son = new MenuSelectDto(); 
				son.setWeeklyId(weeklyId);
				son.setTimeSlotId(timeSlotId);
				son.setMenuTypeId(menuTypeId);
				son.setType("");
				son.setMenuId(menuId);
				son.setName(menuName);
				
				menuSelectDtoList.add(son);
			}
		}
		
		
		//查询选中的菜单
		List<MenuDto> sonList = menuDao.queryWeeklySlotMenuList(timeSlotId, weeklyId);
		
		//存在选中菜单 赋值
		for (int i = 0; i < menuSelectDtoList.size(); i++) {
			 
			 for (int j = 0; j < sonList.size(); j++) {
				 if( sonList.get(j).getMenuId().equals(menuSelectDtoList.get(i).getMenuId() ) ) {
					 menuSelectDtoList.get(i).setSelected("selected");;
				 }
			}
		}
		
		return menuSelectDtoList;
	}


	
}
