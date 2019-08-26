package com.zhongzhou.dao.canteen;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.WeeklyMenuList;

/**
 *	周几 菜单
 */
@Repository
public interface WeeklyMenuListDao extends SelfMapper<WeeklyMenuList, Integer>{

	 /**
     *	删除 传递的对象
     */
    public Long deleteObj(WeeklyMenuList weeklyMenuList);
    
    /**
     *	删除 传递的对象
     */
    public Long deleteWeeklyAndTimeslot(@Param("weeklyId")Integer weeklyId, @Param("timeSlotId")Integer timeSlotId);
    
    /**
     *	修改指定menuId 的 菜单类型id
     */
    public Long updateMenuTypeId(@Param("menuTypeId")Integer menuTypeId, @Param("menuId")Integer menuId);
    
}
