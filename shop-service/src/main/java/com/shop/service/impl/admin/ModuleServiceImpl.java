package com.shop.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.ModuleDao;
import com.shop.dao.admin.ResourceDao;
import com.shop.dao.admin.RoleDao;
import com.shop.domain.admin.Module;
import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ModuleDTO;
import com.shop.service.BaseServiceImpl;
import com.shop.service.admin.IModuleService;



/**
* @date 20180602
* @author 张林
* @description 系统模块 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class ModuleServiceImpl extends BaseServiceImpl implements IModuleService {

    @Autowired
    private ModuleDao moduleDao;
    
    @Autowired
    private ResourceDao resourceDao;
    
    @Autowired
    private RoleDao roleDao;
  
    @Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer moduleId){
    	//删除模块下面的权限和资源
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("moduleId", moduleId);
    	List<Resource> list = resourceDao.findAll(map);
    	if(!CollectionUtils.isEmpty(list)) {
    		for (Resource resource : list) {
    			roleDao.deleteRightByResourceId(resource.getId());
    			resourceDao.deleteByPrimaryKey(resource.getId());
			}
    	}
		moduleDao.deleteByPrimaryKey(moduleId);
	}

    public Module findByPk(Integer moduleId){
    
    	return moduleDao.selectByPrimaryKey(moduleId);
    }
    
    @Transactional(value = "manageTransactionManager")
	public void insertModule(ModuleDTO moduleDTO) throws Exception{
	
		moduleDao.insertSelective(moduleDTO);
	}
	
    @Transactional(value = "manageTransactionManager")
	public void updateModule(ModuleDTO moduleDTO) throws Exception{
		
		moduleDao.updateByPrimaryKeySelective(moduleDTO);
	}
    
	@Override
	public List<Module> findModuleRoleResource(Integer roleId) {
		return moduleDao.findModuleRoleResource(roleId);
	}

	
	public PageInfo<Module> findSplitPage(ModuleDTO moduleDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(moduleDTO!=null){
			if(moduleDTO.getModuleId()!=null){
				map.put("moduleId",moduleDTO.getModuleId());
			}
			if(moduleDTO.getIcon()!=null){
				map.put("icon",moduleDTO.getIcon());
			}
			if(moduleDTO.getModuleName()!=null){
				map.put("moduleName",moduleDTO.getModuleName());
			}
			if(moduleDTO.getDescription()!=null){
				map.put("description",moduleDTO.getDescription());
			}
			if(moduleDTO.getOrderBy()!=null){
				map.put("orderBy",moduleDTO.getOrderBy());
			}
			if(moduleDTO.getStatus()!=null){
				map.put("status",moduleDTO.getStatus());
			}
			if(moduleDTO.getCreateTime()!=null){
				map.put("createTime",moduleDTO.getCreateTime());
			}
			if(moduleDTO.getUpdateTime()!=null){
				map.put("updateTime",moduleDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(moduleDTO.getPageNo(), moduleDTO.getPageSize());
		List<Module> list = moduleDao.findSplitPage(map);
		return new PageInfo<Module>(list);
	}
	
	public List<Module> findAll(ModuleDTO moduleDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(moduleDTO!=null){
			if(moduleDTO.getModuleId()!=null){
				map.put("moduleId",moduleDTO.getModuleId());
			}
			if(moduleDTO.getIcon()!=null){
				map.put("icon",moduleDTO.getIcon());
			}
			if(moduleDTO.getModuleName()!=null){
				map.put("moduleName",moduleDTO.getModuleName());
			}
			if(moduleDTO.getDescription()!=null){
				map.put("description",moduleDTO.getDescription());
			}
			if(moduleDTO.getOrderBy()!=null){
				map.put("orderBy",moduleDTO.getOrderBy());
			}
			if(moduleDTO.getStatus()!=null){
				map.put("status",moduleDTO.getStatus());
			}
			if(moduleDTO.getCreateTime()!=null){
				map.put("createTime",moduleDTO.getCreateTime());
			}
			if(moduleDTO.getUpdateTime()!=null){
				map.put("updateTime",moduleDTO.getUpdateTime());
			}
		}
		List<Module> list = moduleDao.findAll(map);
		return list;
	}
	
}