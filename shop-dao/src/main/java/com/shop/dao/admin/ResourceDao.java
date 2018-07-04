package com.shop.dao.admin;

import java.util.Map;


import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Resource;


/**
* @date 20180602
* @author 张林
* @description 系统资源数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ResourceDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	Resource selectByPrimaryKey(Integer id);

	int insertSelective(Resource resource);

	int updateByPrimaryKeySelective(Resource resource);

	List<Resource> findSplitPage(Map<String, Object> map); 
	
	List<Resource> findAll(Map<String, Object> map);
	
}