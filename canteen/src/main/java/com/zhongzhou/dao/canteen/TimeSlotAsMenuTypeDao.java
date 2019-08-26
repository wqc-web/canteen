package com.zhongzhou.dao.canteen;

import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.TimeSlotAsMenuType;

/**
 *	时间段 和 菜单类型 关联表 dao
 */
@Repository
public interface TimeSlotAsMenuTypeDao extends SelfMapper<TimeSlotAsMenuType, Integer>{

}
