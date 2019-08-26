package com.zhongzhou.service.canteen;

import java.util.List;

import com.zhongzhou.entity.canteen.TimeSlot;

/**
 * 	时间段  Service
 */
public interface TimeSlotService {

	/**
	 *	查询所有
	 * @return
	 */
	List<TimeSlot> queryList();
	
	TimeSlot queryId(Integer id);

	Long update(TimeSlot record);
}
