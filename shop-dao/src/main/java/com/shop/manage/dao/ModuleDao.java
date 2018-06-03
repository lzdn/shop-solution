package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.Module;
import com.shop.manage.dto.ModuleDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 系统模块数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ModuleDao extends BaseDao {

	int deleteByPrimaryKey(Integer moduleId);
	
	ModuleDTO selectByPrimaryKey(Integer moduleId);

	int insertSelective(Module record);

	int updateByPrimaryKeySelective(Module record);

	List<ModuleDTO> findSplitPage(Map<String, Object> map); 
	
}