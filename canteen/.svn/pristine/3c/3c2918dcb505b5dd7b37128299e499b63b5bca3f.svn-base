package com.zhongzhou.service.canteen;

import java.util.List;


import com.zhongzhou.dto.MenuRankDto;

/**
 *	菜单排名
 */
public interface MenuRankService {

	/**
	 *	查询菜单排名 分页 (好评 差评 ) 
	 * 
	 * @param goodState
	 * @param startTime
	 * @param endTime
	 * @param startPage
	 * @param endPage
	 * @return
	 */
	List<MenuRankDto> queryMenuRank(Integer goodState, String startTime, String endTime, Integer startPage, Integer endPage);
	
	
	/**
	 *	查询菜单排名 分页 (好评 差评 )  总数
	 * 
	 * @param goodState
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Long queryMenuRankCount( Integer goodState,  String startTime,  String endTime);
	
}
