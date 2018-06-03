package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.Role;
import com.shop.dto.admin.GrantDto;
import com.shop.dto.admin.RoleDTO;


/**
* @date 20180602
* @author 张林
* @description 角色数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface RoleDao extends BaseDao {

	int deleteByPrimaryKey(Integer roleId);
	
	RoleDTO selectByPrimaryKey(Integer roleId);

	int insertSelective(Role role);

	int updateByPrimaryKeySelective(Role role);

	List<RoleDTO> findSplitPage(Map<String, Object> map); 
	
	List<RoleDTO> findRoleResource(Integer userId);
	
	List<RoleDTO> findRoleList(RoleDTO roleDTO);
	
	int deleteRightRoleId(@Param("roleId") Integer roleId);
	    
	int insertRightBatch(List<GrantDto> grants);
}