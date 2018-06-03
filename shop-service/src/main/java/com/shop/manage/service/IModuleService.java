package com.shop.manage.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.base.IBaseService;
import com.shop.manage.dto.ModuleDTO;

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
    ModuleDTO findByPk(Integer moduleId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Module
    */
    void insertModule(ModuleDTO moduleDTO) throws Exception;

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
	PageInfo<ModuleDTO> findSplitPage(ModuleDTO moduleDTO);
}