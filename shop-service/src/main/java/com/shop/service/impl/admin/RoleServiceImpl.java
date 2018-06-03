package com.shop.service.impl.admin;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.admin.RoleDao;
import com.shop.dto.admin.GrantDto;
import com.shop.dto.admin.RoleDTO;
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

	public RoleDTO findByPk(Integer roleId) {

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
	public List<RoleDTO> findRoleResource(Integer userId) {
		return roleDao.findRoleResource(userId);
	}

	@Override
	public List<RoleDTO> findRoleList(RoleDTO roleDTO) {
		return roleDao.findRoleList(roleDTO);
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

	public PageInfo<RoleDTO> findSplitPage(RoleDTO roleDTO) {
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
		List<RoleDTO> list = roleDao.findSplitPage(map);
		return new PageInfo<RoleDTO>(list);
	}

}