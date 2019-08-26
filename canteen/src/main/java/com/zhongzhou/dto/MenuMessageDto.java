package com.zhongzhou.dto;

import java.util.Date;

/**
 *	菜单消息dto
 */
public class MenuMessageDto {

	public MenuMessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 *	菜单消息id
	 */
	private Integer menuMessageId;
	
	/**
	 * 	发送消息时间
	 */
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
	 *	真实姓名
	 */
	private String name;
	
	/**
	 *	性别 0表示未定义，1表示男性，2表示女性
	 */
	private Integer gender;
	
	/**
	 *	手机号码
	 */
	private String mobile;
	
	/**
	 *	邮箱
	 */
	private String email;
	
	/**
	 *	头像
	 */
	private String avatar;

	
	
	/**
	 * @return
	 */
	public Integer getMenuMessageId() {
		return menuMessageId;
	}

	public void setMenuMessageId(Integer menuMessageId) {
		this.menuMessageId = menuMessageId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
