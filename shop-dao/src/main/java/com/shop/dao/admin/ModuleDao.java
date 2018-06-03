package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Module;
import com.shop.dto.admin.ModuleDTO;


/**
* @date 20180602
* @author 张林
* @description 系统模块数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ModuleDao extends BaseDao {

	int deleteByPrimaryKey(Integer moduleId);
	
	ModuleDTO selectByPrimaryKey(Integer moduleId);

	int insertSelective(Module module);

	int updateByPrimaryKeySelective(Module module);

	List<ModuleDTO> findSplitPage(Map<String, Object> map); 
	
	List<ModuleDTO> findModuleRoleResource(@Param("roleId") Integer roleId);
	
	List<ModuleDTO> findModuleList(ModuleDTO moduleDTO);
}