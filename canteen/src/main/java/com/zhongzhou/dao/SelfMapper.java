package com.zhongzhou.dao;

import java.io.Serializable;


/**
 * 通用IMapper<M , ID>
 * M:实体类
 * ID:主键的变量类型
 */
public interface SelfMapper<M,  ID extends Serializable> {

	/**
     *	查询id
     */
    M queryId(ID id);

    /**
     *	添加
     */
    Long insert(M record);
    
    
    /**
     *	删除
     */
    Long deleteId(ID id);
	
    
    /**
     *	修改
     */
    Long update(M record);
    
    
    
}
