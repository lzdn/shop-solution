package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.DictDao;
import  com.shop.manage.dto.DictDTO;
import  com.shop.manage.service.IDictService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

/**
* @date 20180602
* @author 张林
* @description 系统字典 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class DictServiceImpl extends BaseServiceImpl implements IDictService {

    @Autowired
    private DictDao dictDao;

  
	public void deleteByPk(Integer id){
	
		dictDao.deleteByPrimaryKey(id);
	}

    public DictDTO findByPk(Integer id){
    
    	return dictDao.selectByPrimaryKey(id);
    }
    
	
	public void insertDict(DictDTO dictDTO) throws Exception{
	
		dictDao.insertSelective(dictDTO);
	}
	
	public void updateDict(DictDTO dictDTO) throws Exception{
		
		dictDao.updateByPrimaryKeySelective(dictDTO);
	}
	
	public PageInfo<DictDTO> findSplitPage(DictDTO dictDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(dictDTO!=null){
			if(dictDTO.getId()!=null){
				map.put("id",dictDTO.getId());
			}
			if(dictDTO.getDictCode()!=null){
				map.put("dictCode",dictDTO.getDictCode());
			}
			if(dictDTO.getDictName()!=null){
				map.put("dictName",dictDTO.getDictName());
			}
			if(dictDTO.getDictValue()!=null){
				map.put("dictValue",dictDTO.getDictValue());
			}
			if(dictDTO.getDescription()!=null){
				map.put("description",dictDTO.getDescription());
			}
			if(dictDTO.getStatus()!=null){
				map.put("status",dictDTO.getStatus());
			}
			if(dictDTO.getCreateTime()!=null){
				map.put("createTime",dictDTO.getCreateTime());
			}
			if(dictDTO.getUpdateTime()!=null){
				map.put("updateTime",dictDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(dictDTO.getPageNo(), dictDTO.getPageSize());
		List<DictDTO> list = dictDao.findSplitPage(map);
		return new PageInfo<DictDTO>(list);
	}
	
}