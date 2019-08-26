package com.zhongzhou.service.canteen.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.dao.canteen.NoticeDao;
import com.zhongzhou.entity.canteen.Notice;
import com.zhongzhou.service.canteen.NoticeService;

/**
 *	通知 service impl
 */
@Service
public class NoticeServiceImpl  implements NoticeService{

	/**
	 *  注入 dao对象
	 */
	@Autowired
	NoticeDao noticeDao;
	
	
	
	
	/**
	 *	添加obj
	 */
	@Override
	public Long insert(Notice record) {
		return noticeDao.insert(record);
	}

	/**
	 *	删除指定id
	 */
	@Override
	public Long deleteId(Integer id) {
		return noticeDao.deleteId(id);
	}

	/**
	 *	删除obj
	 */
	@Override
	public Long deleteObj(Notice record) {
		return noticeDao.deleteObj(record);
	}

	/**
	 *  查询所有
	 */
	@Override
	public List<Notice> queryList() {
		return noticeDao.queryList();
	}

	/**
	 *	查询总数
	 */
	@Override
	public Long queryCount() {
		return noticeDao.queryCount();
	}

	/**
	 *  分页查询
	 */
	@Override
	public List<Notice> queryListPage(Integer startpage, Integer endpage) {
		return noticeDao.queryListPage(startpage, endpage);
	}

	/**
	 *  查询指定flag  asc排序
	 */
	@Override
	public List<Notice> queryFlagAscList(Integer flag) {
		return noticeDao.queryFlagAscList(flag);
	}

	/**
	 *  查询指定flag  desc排序
	 */
	@Override
	public List<Notice> queryFlagDescList(Integer flag) {
		return noticeDao.queryFlagDescList(flag);
	}

	/**
	 *	修改
	 */
	@Override
	public Long update(Notice record) {
		return noticeDao.update(record);
	}

	
	/**
	 *	查询指定id
	 */
	@Override
	public Notice queryId(Integer id) {
		return noticeDao.queryId(id);
	}

	
}
