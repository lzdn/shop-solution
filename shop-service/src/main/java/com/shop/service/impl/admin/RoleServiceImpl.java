package com.shop.service.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.RoleDao;
import com.shop.domain.admin.Role;
import com.shop.dto.admin.GrantDto;
import com.shop.dto.admin.RoleDTO;
import com.shop.service.BaseServiceImpl;
import com.shop.service.admin.IRoleService;

/**
 * @date 20180602
 * @author 张林
 * @description 角色 服务接口实现
 * @gitHub:https://github.com/lzdn
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService {

	@Autowired
	private RoleDao roleDao;

	@Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer roleId) {

		roleDao.deleteByPrimaryKey(roleId);
	}

	public Role findByPk(Integer roleId) {

		return roleDao.selectByPrimaryKey(roleId);
	}

	@Transactional(value = "manageTransactionManager")
	public void insertRole(RoleDTO roleDTO) throws Exception {
		
		roleDao.insertSelective(roleDTO);
	}

	@Transactional(value = "manageTransactionManager")
	public void updateRole(RoleDTO roleDTO) throws Exception {

		roleDao.updateByPrimaryKeySelective(roleDTO);
	}

	@Override
	public List<Role> findRoleResource(Integer userId) {
		return roleDao.findRoleResource(userId);
	}

	@Override
	public Role findRoleOneByUserId(Integer userId) {

		return roleDao.findRoleOneByUserId(userId);
	}

	@Override
	public Role findRoleOneByRoleKey(String roleKey) {
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleKey(roleKey);
		List<Role> list = findAll(roleDTO);
		if (!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Transactional(value = "manageTransactionManager")
	public void grant(Integer[] resouresId, Integer roleId) {

		roleDao.deleteRightRoleId(roleId);
		if (resouresId != null && resouresId.length > 0) {
			List<GrantDto> dtos = new ArrayList<GrantDto>();
			for (Integer integer : resouresId) {
				GrantDto dto = new GrantDto();
				dto.setResourceId(integer);
				dto.setRoleId(roleId);
				dtos.add(dto);
			}
			roleDao.insertRightBatch(dtos);
		}
	}

	public PageInfo<Role> findSplitPage(RoleDTO roleDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (roleDTO != null) {
			if (roleDTO.getRoleId() != null) {
				map.put("roleId", roleDTO.getRoleId());
			}
			if (roleDTO.getRoleKey() != null) {
				map.put("roleKey", roleDTO.getRoleKey());
			}
			if (roleDTO.getRoleName() != null) {
				map.put("roleName", roleDTO.getRoleName());
			}
			if (roleDTO.getDescription() != null) {
				map.put("description", roleDTO.getDescription());
			}
			if (roleDTO.getStatus() != null) {
				map.put("status", roleDTO.getStatus());
			}
			if (roleDTO.getCreateTime() != null) {
				map.put("createTime", roleDTO.getCreateTime());
			}
			if (roleDTO.getUpdateTime() != null) {
				map.put("updateTime", roleDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(roleDTO.getPageNo(), roleDTO.getPageSize());
		List<Role> list = roleDao.findSplitPage(map);
		return new PageInfo<Role>(list);
	}

	public List<Role> findAll(RoleDTO roleDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (roleDTO != null) {
			if (roleDTO.getRoleId() != null) {
				map.put("roleId", roleDTO.getRoleId());
			}
			if (roleDTO.getRoleKey() != null) {
				map.put("roleKey", roleDTO.getRoleKey());
			}
			if (roleDTO.getRoleName() != null) {
				map.put("roleName", roleDTO.getRoleName());
			}
			if (roleDTO.getDescription() != null) {
				map.put("description", roleDTO.getDescription());
			}
			if (roleDTO.getStatus() != null) {
				map.put("status", roleDTO.getStatus());
			}
			if (roleDTO.getCreateTime() != null) {
				map.put("createTime", roleDTO.getCreateTime());
			}
			if (roleDTO.getUpdateTime() != null) {
				map.put("updateTime", roleDTO.getUpdateTime());
			}
		}
		List<Role> list = roleDao.findAll(map);
		return list;
	}

}