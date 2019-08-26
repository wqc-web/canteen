package com.zhongzhou.entity.canteen;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *	菜单 消息
 */
public class MenuMessage {

	/**
	 * 
	 */
	public MenuMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private Integer id;
	
	/**
	 * 	发送消息时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date time;
	
	/**
	 * 	内容
	 */
	private String content;
	
	/**
	 * 	wxid
	 */
	private String wxid;

	/**
	 *	1显示 2匿名
	 */
	private Integer anonymous;
	
	/**
	 *	图片地址
	 */
	private String picurl;

	/**
	 * 1工作日 2节假日
	 */
	private Integer lr;
	
	
	
	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public Integer getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public Integer getLr() {
		return lr;
	}

	public void setLr(Integer lr) {
		this.lr = lr;
	}
	
	
	
}
