package com.shop.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.DeptDao;
import com.shop.domain.admin.Dept;
import com.shop.dto.admin.DeptDTO;
import com.shop.service.BaseServiceImpl;
import com.shop.service.admin.IDeptService;

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

	@Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer deptId) {

		deptDao.deleteByPrimaryKey(deptId);
	}

    public Dept findByPk(Integer deptId){

		return deptDao.selectByPrimaryKey(deptId);
	}

	@Transactional(value = "manageTransactionManager")
	public void insertDept(DeptDTO deptDTO) throws Exception {

		deptDao.insertSelective(deptDTO);
	}

	@Transactional(value = "manageTransactionManager")
	public void updateDept(DeptDTO deptDTO) throws Exception {

		deptDao.updateByPrimaryKeySelective(deptDTO);
	}
	
	public PageInfo<Dept> findSplitPage(DeptDTO deptDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if (deptDTO != null) {
			if (deptDTO.getDeptId() != null) {
				map.put("deptId", deptDTO.getDeptId());
			}
			if (deptDTO.getParentDeptId() != null) {
				map.put("parentDeptId", deptDTO.getParentDeptId());
			}
			if (deptDTO.getDeptSimpleName() != null) {
				map.put("deptSimpleName", deptDTO.getDeptSimpleName());
			}
			if (deptDTO.getDeptFullName() != null) {
				map.put("deptFullName", deptDTO.getDeptFullName());
			}
			if (deptDTO.getDescription() != null) {
				map.put("description", deptDTO.getDescription());
			}
			if (deptDTO.getCreateTime() != null) {
				map.put("createTime", deptDTO.getCreateTime());
			}
			if (deptDTO.getUpdateTime() != null) {
				map.put("updateTime", deptDTO.getUpdateTime());
			}
		}
		PageHelper.startPage(deptDTO.getPageNo(), deptDTO.getPageSize());
		List<Dept> list = deptDao.findSplitPage(map);
		return new PageInfo<Dept>(list);
	}
	
	public List<Dept> findAll(DeptDTO deptDTO){
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
		List<Dept> list = deptDao.findAll(map);
		return list;
	}
	
}