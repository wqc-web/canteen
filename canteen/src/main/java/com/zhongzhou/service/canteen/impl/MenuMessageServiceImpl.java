package com.zhongzhou.service.canteen.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.dao.canteen.MenuMessageDao;
import com.zhongzhou.dto.MenuMessageDto;
import com.zhongzhou.entity.canteen.MenuMessage;
import com.zhongzhou.service.canteen.MenuMessageService;


/**
 *	菜单消息
 */
@Service
public class MenuMessageServiceImpl implements MenuMessageService{

	/**
	 *  注入 dao对象
	 */
	@Autowired
	MenuMessageDao menuMessageDao;

	
	/**
	 *	菜单消息分页查询
	 */
	@Override
	public List<MenuMessageDto> queryMenuMessagePage(Integer lr, Integer startPage, Integer endPage) {
		return menuMessageDao.queryMenuMessagePage(lr, startPage, endPage);
	}

	/**
	 * 	删除指定id
	 */
	@Override
	public Long deleteId(Integer id) {
		return menuMessageDao.deleteId(id);
	}

	@Override
	public Long insert(MenuMessage record) {
		return menuMessageDao.insert(record);
	}

	
	/**
	 *	菜单消息分页 总数
	 */
	@Override
	public Long queryMenuMessagePageCount(Integer lr) {
		return menuMessageDao.queryMenuMessagePageCount(lr);
	}

	
	/**
	 *	菜单消息 id
	 */
	@Override
	public MenuMessageDto queryMenuMessageId(Integer id) {
		return menuMessageDao.queryMenuMessageId(id);
	}
	
	
	
}
