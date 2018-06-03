package com.shop.service.admin;

import com.shop.service.IBaseService;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.dto.admin.DeptDTO;

/**
* @date 20180602
* @author 张林
* @description 部门 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IDeptService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Dept
    */
	void deleteByPk(Integer deptId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Dept
    */
    DeptDTO findByPk(Integer deptId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Dept
    */
    void insertDept(DeptDTO deptDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Dept
    */
    void updateDept(DeptDTO deptDTO) throws Exception;
    
	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Dept
    */
	List<DeptDTO> findDeptList(DeptDTO deptDTO);

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Dept
    */
	PageInfo<DeptDTO> findSplitPage(DeptDTO deptDTO);
	

}