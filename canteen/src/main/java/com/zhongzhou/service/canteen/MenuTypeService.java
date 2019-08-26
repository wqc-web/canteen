package com.zhongzhou.service.canteen;

import java.util.List;

import com.zhongzhou.dto.MenuTypeDto;
import com.zhongzhou.entity.canteen.MenuList;
import com.zhongzhou.entity.canteen.MenuType;

/**
 * 	菜单类型 Service
 */
public interface MenuTypeService {

	/**
	 * 
	 * 查询 时间段id 
	 * @param timeSlotId
	 * @return
	 */
	List<MenuTypeDto> querySlotId(Integer timeSlotId);
	
	
	/**
	 *	查询所有
	 */
	List<MenuType> queryList();
}
