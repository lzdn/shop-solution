package com.shop.manage.dao;
import com.shop.dao.base.BaseDao;
import com.shop.manage.domain.Role;
import com.shop.manage.dto.RoleDTO;
import java.util.List;
import java.util.Map;

/**
* @date 20180602
* @author 张林
* @description 角色数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface RoleDao extends BaseDao {

	int deleteByPrimaryKey(Integer roleId);
	
	RoleDTO selectByPrimaryKey(Integer roleId);

	int insertSelective(Role record);

	int updateByPrimaryKeySelective(Role record);

	List<RoleDTO> findSplitPage(Map<String, Object> map); 
	
}