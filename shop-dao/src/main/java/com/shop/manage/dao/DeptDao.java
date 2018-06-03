package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.Dept;
import com.shop.manage.dto.DeptDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 部门数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface DeptDao extends BaseDao {

	int deleteByPrimaryKey(Integer deptId);
	
	DeptDTO selectByPrimaryKey(Integer deptId);

	int insertSelective(Dept record);

	int updateByPrimaryKeySelective(Dept record);

	List<DeptDTO> findSplitPage(Map<String, Object> map); 
	
}