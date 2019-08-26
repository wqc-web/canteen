package com.zhongzhou.service.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhongzhou.entity.canteen.Notice;

/**
 *	通知 service
 */
public interface NoticeService {
	
	/**
	 *	查询指定id
	 */
	Notice queryId(Integer id);

	/**
	 *	添加obj
	 */
	Long insert(Notice record);

	/**
	 *	删除指定id
	 */
	Long deleteId(Integer id);

	/**
	 *	删除obj
	 */
	Long deleteObj(Notice record);
	
	/**
	 *	修改
	 */
	Long update(Notice record);
	
	/**
	 *  查询所有
	 */
	List<Notice> queryList();
	
	
	/**
	 *	查询总数
	 */
	Long queryCount();
	
	/**
	 *  分页查询
	 */
	List<Notice> queryListPage(Integer startpage , Integer endpage);
	
	/**
	 *  查询指定flag  asc排序
	 */
	List<Notice> queryFlagAscList(Integer flag);
	
	/**
	 *  查询指定flag  desc排序
	 */
	List<Notice> queryFlagDescList(Integer flag);
	
	
}
