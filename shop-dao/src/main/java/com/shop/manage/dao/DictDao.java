package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.Dict;
import com.shop.manage.dto.DictDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 系统字典数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface DictDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	DictDTO selectByPrimaryKey(Integer id);

	int insertSelective(Dict record);

	int updateByPrimaryKeySelective(Dict record);

	List<DictDTO> findSplitPage(Map<String, Object> map); 
	
}