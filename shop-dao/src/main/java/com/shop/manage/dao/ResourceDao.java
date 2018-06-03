package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.Resource;
import com.shop.manage.dto.ResourceDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 系统资源数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ResourceDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	ResourceDTO selectByPrimaryKey(Integer id);

	int insertSelective(Resource record);

	int updateByPrimaryKeySelective(Resource record);

	List<ResourceDTO> findSplitPage(Map<String, Object> map); 
	
}