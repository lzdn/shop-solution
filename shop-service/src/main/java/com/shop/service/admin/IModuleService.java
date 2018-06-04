package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Module;
import com.shop.dto.admin.ModuleDTO;
import com.shop.service.IBaseService;

/**
* @date 20180602
* @author 张林
* @description 系统模块 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IModuleService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Module
    */
	void deleteByPk(Integer moduleId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Module
    */
    Module findByPk(Integer moduleId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Module
    */
    void insertModule(ModuleDTO moduleDTO) throws Exception;
    
	/**
	* @date 20180602
	* @author 张林
    * 描述：根据角色查询资源权限
    */
	List<Module> findModuleRoleResource(Integer roleId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Module
    */
    void updateModule(ModuleDTO moduleDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Module
    */
	PageInfo<Module> findSplitPage(ModuleDTO moduleDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部Module
    */
	List<Module> findAll(ModuleDTO moduleDTO);
}