package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.dto.MenuMessageDto;
import com.zhongzhou.entity.canteen.MenuMessage;

/**
 *	菜单 消息 dao
 */
@Repository
public interface MenuMessageDao extends SelfMapper<MenuMessage, Integer>{

	/**
	 *	菜单消息分页查询
	 */
	List<MenuMessageDto> queryMenuMessagePage(@Param("lr")Integer lr, @Param("startPage")Integer startPage, @Param("endPage")Integer endPage);

	
	/**
	 *	菜单消息 id
	 */
	MenuMessageDto queryMenuMessageId(@Param("id")Integer id);
	
	/**
	 *	菜单消息分页 总数
	 */
	Long queryMenuMessagePageCount(@Param("lr")Integer lr);
	
	/**
	 * 	删除指定id
	 */
	@Override
	Long deleteId(@Param("id")Integer id);

	@Override
	Long insert(MenuMessage record);
	
}
