package com.shop.dao.admin;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Dept;


/**
* @date 20180602
* @author 张林
* @description 部门数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface DeptDao extends BaseDao {

	int deleteByPrimaryKey(Integer deptId);
	
	Dept selectByPrimaryKey(Integer deptId);

	int insertSelective(Dept dept);

	int updateByPrimaryKeySelective(Dept dept);

	List<Dept> findSplitPage(Map<String, Object> map); 
	
	List<Dept> findAll(Map<String, Object> map);
}