package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Module;


/**
* @date 20180602
* @author 张林
* @description 系统模块数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ModuleDao extends BaseDao {

	int deleteByPrimaryKey(Integer moduleId);
	
	Module selectByPrimaryKey(Integer moduleId);

	int insertSelective(Module module);

	int updateByPrimaryKeySelective(Module module);

	List<Module> findSplitPage(Map<String, Object> map); 
	
	List<Module> findAll(Map<String, Object> map);
	
	List<Module> findModuleRoleResource(@Param("roleId") Integer roleId);
}