package com.shop.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.DictDao;
import com.shop.domain.admin.Dict;
import com.shop.dto.admin.DictDTO;
import com.shop.service.BaseServiceImpl;
import com.shop.service.admin.IDictService;

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

	@Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer id) {

		dictDao.deleteByPrimaryKey(id);
	}

    public Dict findByPk(Integer id){
    
    	return dictDao.selectByPrimaryKey(id);
    }
    
	
	public void insertDict(DictDTO dictDTO) throws Exception{
	
		dictDao.insertSelective(dictDTO);
	}

	@Transactional(value = "manageTransactionManager")
	public void updateDict(DictDTO dictDTO) throws Exception {

		dictDao.updateByPrimaryKeySelective(dictDTO);
	}

	public PageInfo<Dict> findSplitPage(DictDTO dictDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if (dictDTO != null) {
			if (dictDTO.getId() != null) {
				map.put("id", dictDTO.getId());
			}
			if (dictDTO.getDictCode() != null) {
				map.put("dictCode", dictDTO.getDictCode());
			}
			if (dictDTO.getDictName() != null) {
				map.put("dictName", dictDTO.getDictName());
			}
			if (dictDTO.getDictValue() != null) {
				map.put("dictValue", dictDTO.getDictValue());
			}
			if (dictDTO.getDescription() != null) {
				map.put("description", dictDTO.getDescription());
			}
			if (dictDTO.getStatus() != null) {
				map.put("status", dictDTO.getStatus());
			}
			if (dictDTO.getCreateTime() != null) {
				map.put("createTime", dictDTO.getCreateTime());
			}
			if (dictDTO.getUpdateTime() != null) {
				map.put("updateTime", dictDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(dictDTO.getPageNo(), dictDTO.getPageSize());
		List<Dict> list = dictDao.findSplitPage(map);
		return new PageInfo<Dict>(list);
	}
	
	public List<Dict> findAll(DictDTO dictDTO){
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
		List<Dict> list = dictDao.findAll(map);
		return list;
	}
	
}