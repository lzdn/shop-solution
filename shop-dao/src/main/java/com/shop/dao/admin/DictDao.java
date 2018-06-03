package com.shop.dao.admin;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Dict;
import com.shop.dto.admin.DictDTO;


/**
* @date 20180602
* @author 张林
* @description 系统字典数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface DictDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	DictDTO selectByPrimaryKey(Integer id);

	int insertSelective(Dict dict);

	int updateByPrimaryKeySelective(Dict dict);

	List<DictDTO> findSplitPage(Map<String, Object> map); 
	
}