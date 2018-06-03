package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.ResourceDao;
import  com.shop.manage.dto.ResourceDTO;
import  com.shop.manage.service.IResourceService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

/**
* @date 20180602
* @author 张林
* @description 系统资源 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class ResourceServiceImpl extends BaseServiceImpl implements IResourceService {

    @Autowired
    private ResourceDao resourceDao;

  
	public void deleteByPk(Integer id){
	
		resourceDao.deleteByPrimaryKey(id);
	}

    public ResourceDTO findByPk(Integer id){
    
    	return resourceDao.selectByPrimaryKey(id);
    }
    
	
	public void insertResource(ResourceDTO resourceDTO) throws Exception{
	
		resourceDao.insertSelective(resourceDTO);
	}
	
	public void updateResource(ResourceDTO resourceDTO) throws Exception{
		
		resourceDao.updateByPrimaryKeySelective(resourceDTO);
	}
	
	public PageInfo<ResourceDTO> findSplitPage(ResourceDTO resourceDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(resourceDTO!=null){
			if(resourceDTO.getId()!=null){
				map.put("id",resourceDTO.getId());
			}
			if(resourceDTO.getResourceKey()!=null){
				map.put("resourceKey",resourceDTO.getResourceKey());
			}
			if(resourceDTO.getResourceValue()!=null){
				map.put("resourceValue",resourceDTO.getResourceValue());
			}
			if(resourceDTO.getUrl()!=null){
				map.put("url",resourceDTO.getUrl());
			}
			if(resourceDTO.getParentId()!=null){
				map.put("parentId",resourceDTO.getParentId());
			}
			if(resourceDTO.getModuleId()!=null){
				map.put("moduleId",resourceDTO.getModuleId());
			}
			if(resourceDTO.getLevel()!=null){
				map.put("level",resourceDTO.getLevel());
			}
			if(resourceDTO.getAvailable()!=null){
				map.put("available",resourceDTO.getAvailable());
			}
			if(resourceDTO.getType()!=null){
				map.put("type",resourceDTO.getType());
			}
			if(resourceDTO.getMenuIcon()!=null){
				map.put("menuIcon",resourceDTO.getMenuIcon());
			}
			if(resourceDTO.getOrderBy()!=null){
				map.put("orderBy",resourceDTO.getOrderBy());
			}
			if(resourceDTO.getCreateTime()!=null){
				map.put("createTime",resourceDTO.getCreateTime());
			}
			if(resourceDTO.getUpdateTime()!=null){
				map.put("updateTime",resourceDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(resourceDTO.getPageNo(), resourceDTO.getPageSize());
		List<ResourceDTO> list = resourceDao.findSplitPage(map);
		return new PageInfo<ResourceDTO>(list);
	}
	
}