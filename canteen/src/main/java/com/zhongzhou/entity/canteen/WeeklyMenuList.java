package com.zhongzhou.entity.canteen;

/**
 *	周几 菜单
 */
public class WeeklyMenuList {

	public WeeklyMenuList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public WeeklyMenuList(Integer weeklyId, Integer timeSlotId, Integer menuTypeId, Integer menuId) {
		super();
		this.weeklyId = weeklyId;
		this.timeSlotId = timeSlotId;
		this.menuTypeId = menuTypeId;
		this.menuId = menuId;
	}



	/**
	 * 
	 */
	private Integer id;
	
	/**
	 *	周几 id
	 */
	private Integer weeklyId;
	
	/**
	 *	时间段id
	 */
	private Integer timeSlotId;
	
	/**
	 *	菜单类型id
	 */
	private Integer menuTypeId;
	
	/**
	 *	菜单id
	 */
	private Integer menuId;

	
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWeeklyId() {
		return weeklyId;
	}

	public void setWeeklyId(Integer weeklyId) {
		this.weeklyId = weeklyId;
	}

	public Integer getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public Integer getMenuTypeId() {
		return menuTypeId;
	}

	public void setMenuTypeId(Integer menuTypeId) {
		this.menuTypeId = menuTypeId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
}
