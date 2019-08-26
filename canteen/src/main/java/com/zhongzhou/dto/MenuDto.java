package com.zhongzhou.dto;

import java.math.BigDecimal;

/**
 *	菜单 dto
 */
public class MenuDto extends MenuTypeDto{

	public MenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *	周几菜单列表 id
	 */
	private Integer weeklyMenuListId;
	
	/**
	 *	周几 id
	 */
	private Integer weeklyId;
	
	/**
	 *	菜单 id
	 */
	private Integer menuId;
	
	/**
	 *	菜单名称
	 */
	private String menuName;
	
	/**
	 *	餐单图片地址
	 */
	private String menuPicUrl;
	
	/**
	 *	菜单价格
	 */
	private BigDecimal menuPrice;

	
	
	
	/**
	 * @return
	 */
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPicUrl() {
		return menuPicUrl;
	}

	public void setMenuPicUrl(String menuPicUrl) {
		this.menuPicUrl = menuPicUrl;
	}

	public BigDecimal getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(BigDecimal menuPrice) {
		this.menuPrice = menuPrice;
	}

	public Integer getWeeklyMenuListId() {
		return weeklyMenuListId;
	}

	public void setWeeklyMenuListId(Integer weeklyMenuListId) {
		this.weeklyMenuListId = weeklyMenuListId;
	}

	public Integer getWeeklyId() {
		return weeklyId;
	}

	public void setWeeklyId(Integer weeklyId) {
		this.weeklyId = weeklyId;
	}
	
	
}
