package com.zhongzhou.service.canteen;


import com.zhongzhou.entity.canteen.MenuList;

/**
 *  menuList  Service
 */
public interface MenuListService {
	
	Long update(MenuList record);

	/**
	 *	查询指定menuId 只返回第一条
	 */
	MenuList queryMenuId(Integer menuId);

}
