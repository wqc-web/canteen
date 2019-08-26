package com.zhongzhou.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *	菜单类型 dto
 */
public class MenuTypeDto {
	
	public MenuTypeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *	菜单列表 id
	 */
	private Integer menuListId;
	
	/**
	 * 	时间段 和 菜单类型 关联表 id
	 */
	private Integer timeSlotMenuTypeId;
	
	
	/**
	 *	菜单类型 id
	 */
	private Integer menuTypeId;

	
	/**
	 *	时间段 id
	 */
	private Integer timeSlotId;
	
	
	/**
	 *	菜单类型 名称
	 */
	private String menuTypeName;
	
	
	/**
	 *	时间段 名称
	 */
	private String slotName;
	
	/**
	 *	开始时间
	 */
	private Date startDate;
	
	/**
	 *	结束时间
	 */
	private Date endDate;

	
	
	
	/**
	 * @return
	 */
	public Integer getTimeSlotMenuTypeId() {
		return timeSlotMenuTypeId;
	}

	public void setTimeSlotMenuTypeId(Integer timeSlotMenuTypeId) {
		this.timeSlotMenuTypeId = timeSlotMenuTypeId;
	}

	public Integer getMenuTypeId() {
		return menuTypeId;
	}

	public void setMenuTypeId(Integer menuTypeId) {
		this.menuTypeId = menuTypeId;
	}

	public Integer getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(Integer timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public String getMenuTypeName() {
		return menuTypeName;
	}

	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getMenuListId() {
		return menuListId;
	}

	public void setMenuListId(Integer menuListId) {
		this.menuListId = menuListId;
	}
	
		
}
