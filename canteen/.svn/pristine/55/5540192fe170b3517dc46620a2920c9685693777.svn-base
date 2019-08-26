package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.dto.MenuDto;
import com.zhongzhou.dto.MenuFeedbackDto;
import com.zhongzhou.entity.canteen.Menu;

/**
 * 	菜单dao
 */
@Repository
public interface MenuDao extends SelfMapper<Menu, Integer>{

	/**
	 *	查询菜单Dto 
	 *	参数 :  menuTypeId
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryMenuTypeIsMenu( @Param("menuTypeId")Integer menuTypeId);
	
	/**
	 *	查询菜单Dto Page 
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryMenuTypeIsMenuPage(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId ,  @Param("pageStart")Integer pageStart ,  @Param("pageSize")Integer pageSize ,  @Param("menuName")String menuName);
	
	
	/**
	 *	查询菜单Dto count
	 *	参数 : timeSlotId 和 menuTypeId
	 *	返回 : List<MenuDto>
	 */
	Integer queryMenuTypeIsMenuCount(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId ,  @Param("menuName")String menuName);
	
	
	/**
	 * 	查询 指定menuTypeId的所有菜单
	 * 	参数 : menuTypeId 
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryMenuAllMenuTypeId(@Param("menuTypeId")Integer menuTypeId );
	
	/**
	 * 	查询指定星期 时间段  菜单类型
	 * 	参数 : timeSlotId 和 menuTypeId 和 weeklyId
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryWeeklyMenuList(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId , @Param("weeklyId")Integer weeklyId);
	
	
	/**
	 * 	查询指定星期 时间段  菜单类型 page
	 * 	参数 : timeSlotId 和 menuTypeId 和 weeklyId 和 startPage 和 endPage
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryWeeklyMenuListPage(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId , @Param("weeklyId")Integer weeklyId , @Param("startPage")Integer startPage , @Param("endPage")Integer endPage);
	
	
	/**
	 * 	app查询指定星期 时间段  菜单类型 page
	 * 	参数 : timeSlotId 和 menuTypeId 和 weeklyId 和 wxid 和   goodTime  和 startPage 和 endPage
	 *	返回 : List<MenuFeedbackDto>
	 */
	List<MenuFeedbackDto> appQueryWeeklyMenuListPage(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId , @Param("weeklyId")Integer weeklyId , 
													@Param("wxid")String wxid ,  @Param("goodTime")String goodTime, 
													@Param("startPage")Integer startPage , @Param("endPage")Integer endPage);
	
	
	/**
	 * 	app查询指定星期 时间段  菜单类型  
	 * 	参数 : timeSlotId 和 menuTypeId 和 weeklyId 和 wxid 和   goodTime 
	 *	返回 : List<MenuFeedbackDto>
	 */
	List<MenuFeedbackDto> appQueryWeeklyMenuList(@Param("timeSlotId")Integer timeSlotId, @Param("menuTypeId")Integer menuTypeId , @Param("weeklyId")Integer weeklyId , 
													@Param("wxid")String wxid ,  @Param("goodTime")String goodTime);
	
	
	/**
	 * 	查询指定星期 时间段 
	 * 	参数 : timeSlotId  和 weeklyId
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryWeeklySlotMenuList(@Param("timeSlotId")Integer timeSlotId, @Param("weeklyId")Integer weeklyId);
	
	
	
	
	/**
	 * 	查询指定星期 时间段  菜单名称
	 * 	参数 : timeSlotId 和  weeklyId 和 menuName
	 *	返回 : List<MenuDto>
	 */
	List<MenuDto> queryWeeklyMenuName(@Param("timeSlotId")Integer timeSlotId, @Param("weeklyId")Integer weeklyId , @Param("menuName")String menuName);


	/**
	 *	添加
	 */
	@Override
	Long insert(Menu record);


	/**
	 *	删除
	 */
	@Override
	Long deleteId(@Param("id")Integer id);

	@Override
	Menu queryId(Integer id);

	
	@Override
	Long update(Menu record);

	
	
}
