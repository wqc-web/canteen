package com.zhongzhou.service.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.dao.canteen.TimeSlotDao;
import com.zhongzhou.entity.canteen.TimeSlot;
import com.zhongzhou.service.canteen.TimeSlotService;

/**
 * 	时间段  Service impl
 */
@Service
public class TimeSlotServiceImpl implements TimeSlotService{

	/**
	 *  注入 dao对象
	 */
	@Autowired
	TimeSlotDao timeSlotDao;

	
	/**
	 *	查询所有
	 * @return
	 */
	@Override
	public List<TimeSlot> queryList() {
		return timeSlotDao.queryList();
	}


	@Override
	public TimeSlot queryId(Integer id) {
		return timeSlotDao.queryId(id);
	}


	@Override
	public Long update(TimeSlot record) {
		return timeSlotDao.update(record);
	}
	
	
	
	
	
}
