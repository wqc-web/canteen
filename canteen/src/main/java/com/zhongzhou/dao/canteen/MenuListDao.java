package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.MenuList;

/**
 * 	菜单列表 dao
 */
@Repository
public interface MenuListDao extends SelfMapper<MenuList, Integer>{

	@Override
	Long insert(MenuList record);

	@Override
	Long deleteId(@Param("id")Integer id);

	
	Long deleteObj(MenuList obj);
	
	
	
	
	@Override
	Long update(MenuList record);

	/**
	 *	查询指定menuId 只返回第一条
	 */
	MenuList queryMenuId(@Param("menuId")Integer menuId);
	
	
	/**
	 *	查询所有
	 */
	List<MenuList> queryMenuList();
}
