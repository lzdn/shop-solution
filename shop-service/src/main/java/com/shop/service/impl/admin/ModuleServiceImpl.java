package com.shop.service.impl.admin;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.admin.ModuleDao;
import com.shop.dto.admin.ModuleDTO;
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

  
    @Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer moduleId){
	
		moduleDao.deleteByPrimaryKey(moduleId);
	}

    public ModuleDTO findByPk(Integer moduleId){
    
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
	public List<ModuleDTO> findModuleRoleResource(Integer roleId) {
		return moduleDao.findModuleRoleResource(roleId);
	}

	@Override
	public List<ModuleDTO> findModuleList(ModuleDTO moduleDTO) {
		return moduleDao.findModuleList(moduleDTO);
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