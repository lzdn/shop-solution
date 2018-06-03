package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.User;
import com.shop.dto.admin.UserDTO;


/**
* @date 20180602
* @author 张林
* @description 用户数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface UserDao extends BaseDao {

	int deleteByPrimaryKey(Integer userId);
	
	UserDTO selectByPrimaryKey(Integer userId);

	int insertSelective(User user);

	int updateByPrimaryKeySelective(User user);

	List<UserDTO> findSplitPage(Map<String, Object> map); 
	
	UserDTO findByAccount(@Param(value = "account") String account);
	
	UserDTO selectUserRoleByPk(@Param(value = "userId") Integer userId);
	
	int deleteUserRole(@Param(value = "userId") Integer userId);
	
	int addUserRole(@Param(value = "userId") Integer userId,@Param(value = "roleId") Integer roleId);
}