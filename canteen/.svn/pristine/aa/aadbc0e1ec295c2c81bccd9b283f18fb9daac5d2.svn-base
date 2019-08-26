package com.zhongzhou.dao.canteen;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zhongzhou.dao.SelfMapper;
import com.zhongzhou.entity.canteen.Notice;

/**
 *	通知dao
 */
@Repository
public interface NoticeDao extends SelfMapper<Notice, Integer>{

	
	/**
	 *	查询指定id
	 */
	@Override
	Notice queryId(@Param("id") Integer id);

	/**
	 *	添加obj
	 */
	@Override
	Long insert(Notice record);

	/**
	 *	删除指定id
	 */
	@Override
	Long deleteId(Integer id);

	/**
	 *	删除obj
	 */
	Long deleteObj(Notice record);
	
	/**
	 *	修改
	 */
	@Override
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
	List<Notice> queryListPage(@Param("startpage")Integer startpage , @Param("endpage")Integer endpage);
	
	/**
	 *  查询指定flag  asc排序
	 */
	List<Notice> queryFlagAscList(@Param("flag")Integer flag);
	
	/**
	 *  查询指定flag  desc排序
	 */
	List<Notice> queryFlagDescList(@Param("flag")Integer flag);
	
}
