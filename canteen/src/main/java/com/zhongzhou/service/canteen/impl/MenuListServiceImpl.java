package com.zhongzhou.service.canteen.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.dao.canteen.MenuListDao;
import com.zhongzhou.entity.canteen.MenuList;
import com.zhongzhou.service.canteen.MenuListService;

/**
 *  menuList  Service Impl
 */ 
@Service
public class MenuListServiceImpl implements MenuListService{

	/**
	 *  注入 dao对象
	 */
	@Autowired
	MenuListDao menuListDao;
	
	public Long update(MenuList record) {
		return menuListDao.update(record);
	}

	/**
	 *	查询指定menuId 只返回第一条
	 */
	@Override
	public MenuList queryMenuId(Integer menuId) {
		return menuListDao.queryMenuId(menuId);
	}

}
