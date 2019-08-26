package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.TimeSlot;

/**
 *	时间段 (早中晚)
 */
@Repository
public interface TimeSlotDao extends SelfMapper<TimeSlot, Integer>{

	
	
	/**
	 * 	查询 哪个时间段
	 * @param time
	 * @return
	 */
	TimeSlot queryTimeSlot(@Param("time") String time);
	
	/**
	 *	查询所有
	 * @return
	 */
	List<TimeSlot> queryList();

	@Override
	TimeSlot queryId(Integer id);

	@Override
	Long update(TimeSlot record);
	
	
	
}
