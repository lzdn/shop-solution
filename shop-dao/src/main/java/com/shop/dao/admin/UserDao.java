package com.shop.dao.admin;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.admin.User;


/**
* @date 20180602
* @author 张林
* @description 用户数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface UserDao extends BaseDao {

	int deleteByPrimaryKey(Integer userId);
	
	User selectByPrimaryKey(Integer userId);

	int insertSelective(User user);

	int updateByPrimaryKeySelective(User user);

	List<User> findSplitPage(Map<String, Object> map); 
	
	List<User> findAll(Map<String, Object> map);
	
	User findByAccount(@Param(value = "account") String account);
	
	User selectUserRoleByPk(@Param(value = "userId") Integer userId);
	
	int deleteUserRole(@Param(value = "userId") Integer userId);
	
	int addUserRole(@Param(value = "userId") Integer userId,@Param(value = "roleId") Integer roleId);
}