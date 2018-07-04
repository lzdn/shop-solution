package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Role;
import com.shop.dto.admin.GrantDto;


/**
* @date 20180602
* @author 张林
* @description 角色数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface RoleDao extends BaseDao {

	int deleteByPrimaryKey(Integer roleId);
	
	Role selectByPrimaryKey(Integer roleId);

	int insertSelective(Role role);

	int updateByPrimaryKeySelective(Role role);

	List<Role> findSplitPage(Map<String, Object> map); 
	
	List<Role> findAll(Map<String, Object> map);
	
	List<Role> findRoleResource(@Param("userId") Integer userId);
	
	int deleteRightRoleId(@Param("roleId") Integer roleId);
	
	int deleteRightByResourceId(@Param("resourceId") Integer resourceId);
	    
	int insertRightBatch(List<GrantDto> grants);
	
	Role findRoleOneByUserId(@Param("userId") Integer userId);
	
}