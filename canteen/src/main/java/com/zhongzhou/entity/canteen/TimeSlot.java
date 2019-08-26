package com.zhongzhou.entity.canteen;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *	时间段 (早中晚)
 */
public class TimeSlot {

	/**
	 * 
	 */
	public TimeSlot() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private Integer id;
	
	/**
	 *  名称
	 */
	private String name;
	
	/**
	 *  开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	
	/**
	 * 	结束时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;

	
	
	
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	
}
