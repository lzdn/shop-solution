package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.DeptDao;
import  com.shop.manage.dto.DeptDTO;
import  com.shop.manage.service.IDeptService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

/**
* @date 20180602
* @author 张林
* @description 部门 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class DeptServiceImpl extends BaseServiceImpl implements IDeptService {

    @Autowired
    private DeptDao deptDao;

  
	public void deleteByPk(Integer deptId){
	
		deptDao.deleteByPrimaryKey(deptId);
	}

    public DeptDTO findByPk(Integer deptId){
    
    	return deptDao.selectByPrimaryKey(deptId);
    }
    
	
	public void insertDept(DeptDTO deptDTO) throws Exception{
	
		deptDao.insertSelective(deptDTO);
	}
	
	public void updateDept(DeptDTO deptDTO) throws Exception{
		
		deptDao.updateByPrimaryKeySelective(deptDTO);
	}
	
	public PageInfo<DeptDTO> findSplitPage(DeptDTO deptDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(deptDTO!=null){
			if(deptDTO.getDeptId()!=null){
				map.put("deptId",deptDTO.getDeptId());
			}
			if(deptDTO.getParentDeptId()!=null){
				map.put("parentDeptId",deptDTO.getParentDeptId());
			}
			if(deptDTO.getDeptSimpleName()!=null){
				map.put("deptSimpleName",deptDTO.getDeptSimpleName());
			}
			if(deptDTO.getDeptFullName()!=null){
				map.put("deptFullName",deptDTO.getDeptFullName());
			}
			if(deptDTO.getDescription()!=null){
				map.put("description",deptDTO.getDescription());
			}
			if(deptDTO.getCreateTime()!=null){
				map.put("createTime",deptDTO.getCreateTime());
			}
			if(deptDTO.getUpdateTime()!=null){
				map.put("updateTime",deptDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(deptDTO.getPageNo(), deptDTO.getPageSize());
		List<DeptDTO> list = deptDao.findSplitPage(map);
		return new PageInfo<DeptDTO>(list);
	}
	
}