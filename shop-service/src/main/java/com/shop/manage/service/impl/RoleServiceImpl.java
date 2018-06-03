package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.RoleDao;
import  com.shop.manage.dto.RoleDTO;
import  com.shop.manage.service.IRoleService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

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

  
	public void deleteByPk(Integer roleId){
	
		roleDao.deleteByPrimaryKey(roleId);
	}

    public RoleDTO findByPk(Integer roleId){
    
    	return roleDao.selectByPrimaryKey(roleId);
    }
    
	
	public void insertRole(RoleDTO roleDTO) throws Exception{
	
		roleDao.insertSelective(roleDTO);
	}
	
	public void updateRole(RoleDTO roleDTO) throws Exception{
		
		roleDao.updateByPrimaryKeySelective(roleDTO);
	}
	
	public PageInfo<RoleDTO> findSplitPage(RoleDTO roleDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(roleDTO!=null){
			if(roleDTO.getRoleId()!=null){
				map.put("roleId",roleDTO.getRoleId());
			}
			if(roleDTO.getRoleKey()!=null){
				map.put("roleKey",roleDTO.getRoleKey());
			}
			if(roleDTO.getRoleName()!=null){
				map.put("roleName",roleDTO.getRoleName());
			}
			if(roleDTO.getDescription()!=null){
				map.put("description",roleDTO.getDescription());
			}
			if(roleDTO.getStatus()!=null){
				map.put("status",roleDTO.getStatus());
			}
			if(roleDTO.getCreateTime()!=null){
				map.put("createTime",roleDTO.getCreateTime());
			}
			if(roleDTO.getUpdateTime()!=null){
				map.put("updateTime",roleDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(roleDTO.getPageNo(), roleDTO.getPageSize());
		List<RoleDTO> list = roleDao.findSplitPage(map);
		return new PageInfo<RoleDTO>(list);
	}
	
}