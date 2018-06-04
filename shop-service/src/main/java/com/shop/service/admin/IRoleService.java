package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Role;
import com.shop.dto.admin.RoleDTO;
import com.shop.service.IBaseService;

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
	Role findByPk(Integer roleId);

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
	PageInfo<Role> findSplitPage(RoleDTO roleDTO);

	/**
	 * @date 20180602
	 * @author 张林 描述：查询全部Role
	 */
	List<Role> findAll(RoleDTO roleDTO);

	/**
	 * @date 20180602
	 * @author 张林 描述：根据用户ID 查询角色的权限资源
	 */
	List<Role> findRoleResource(Integer userId);

	/**
	 * 授权
	 * 
	 * @param resouresId
	 * @param roleId
	 */
	void grant(Integer[] resouresId, Integer roleId);

	/**
	 * 查询角色
	 * 
	 * @param userId
	 * @return
	 */
	Role findRoleOneByUserId(Integer userId);

	/**
	 * 查询角色
	 * 
	 * @param roleKey
	 * @return
	 */
	Role findRoleOneByRoleKey(String roleKey);

}