package com.shop.service.admin;

import com.shop.service.IBaseService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.dto.admin.RoleDTO;

/**
 * @date 20180602
 * @author 张林
 * @description 角色 服务接口
 * @gitHub:https://github.com/lzdn
 */
public interface IRoleService extends IBaseService {

	/**
	 * @date 20180602
	 * @author 张林 描述：根据主键删除Role
	 */
	void deleteByPk(Integer roleId);

	/**
	 * @date 20180602
	 * @author 张林 描述：根据主键查询Role
	 */
	RoleDTO findByPk(Integer roleId);

	/**
	 * @date 20180602
	 * @author 张林 描述：新增Role
	 */
	void insertRole(RoleDTO roleDTO) throws Exception;

	/**
	 * @date 20180602
	 * @author 张林 描述：修改Role
	 */
	void updateRole(RoleDTO roleDTO) throws Exception;

	/**
	 * @date 20180602
	 * @author 张林 描述：分页Role
	 */
	PageInfo<RoleDTO> findSplitPage(RoleDTO roleDTO);

	/**
	 * @date 20180602
	 * @author 张林 描述：根据用户ID 查询角色的权限资源
	 */
	List<RoleDTO> findRoleResource(Integer userId);

	/**
	 * @date 20180602
	 * @author 张林 描述：
	 */
	List<RoleDTO> findRoleList(RoleDTO roleDTO);

	/**
	 * 授权
	 * 
	 * @param resouresId
	 * @param roleId
	 */
	void grant(Integer[] resouresId, Integer roleId);

}