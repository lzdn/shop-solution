package com.shop.manage.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.base.IBaseService;
import com.shop.manage.dto.RoleDTO;

/**
* @date 20180602
* @author 张林
* @description 角色 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IRoleService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Role
    */
	void deleteByPk(Integer roleId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Role
    */
    RoleDTO findByPk(Integer roleId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Role
    */
    void insertRole(RoleDTO roleDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Role
    */
    void updateRole(RoleDTO roleDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Role
    */
	PageInfo<RoleDTO> findSplitPage(RoleDTO roleDTO);
}