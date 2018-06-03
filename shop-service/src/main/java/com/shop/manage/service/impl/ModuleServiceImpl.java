package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.ModuleDao;
import  com.shop.manage.dto.ModuleDTO;
import  com.shop.manage.service.IModuleService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

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

  
	public void deleteByPk(Integer moduleId){
	
		moduleDao.deleteByPrimaryKey(moduleId);
	}

    public ModuleDTO findByPk(Integer moduleId){
    
    	return moduleDao.selectByPrimaryKey(moduleId);
    }
    
	
	public void insertModule(ModuleDTO moduleDTO) throws Exception{
	
		moduleDao.insertSelective(moduleDTO);
	}
	
	public void updateModule(ModuleDTO moduleDTO) throws Exception{
		
		moduleDao.updateByPrimaryKeySelective(moduleDTO);
	}
	
	public PageInfo<ModuleDTO> findSplitPage(ModuleDTO moduleDTO){
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
		List<ModuleDTO> list = moduleDao.findSplitPage(map);
		return new PageInfo<ModuleDTO>(list);
	}
	
}