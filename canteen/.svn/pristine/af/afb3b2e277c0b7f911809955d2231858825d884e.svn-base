package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.dto.MenuTypeDto;
import com.zhongzhou.entity.canteen.MenuType;

/**
 * 	菜单类型 dao
 */
@Repository
public interface MenuTypeDao extends SelfMapper<MenuType, Integer>{

	/**
	 * 
	 * 查询 时间段id 
	 * @param timeSlotId
	 * @return
	 */
	List<MenuTypeDto> querySlotId(@Param("timeSlotId")Integer timeSlotId);
	
	/**
	 *	查询所有
	 */
	List<MenuType> queryList();
}
