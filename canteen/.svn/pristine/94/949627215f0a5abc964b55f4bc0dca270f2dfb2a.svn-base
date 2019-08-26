package com.zhongzhou.entity.canteen;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *	通知
 */
public class Notice {

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *	id
	 */
	private Integer id;
	
	/**
	 *	消息
	 */
	private String message;
	
	/**
	 *	添加时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date addtime;

	/**
	 *	 1开启，2禁用
	 */
	private Integer flag;
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
	
}
