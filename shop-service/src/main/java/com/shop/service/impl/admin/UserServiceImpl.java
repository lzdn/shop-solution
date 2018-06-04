package com.shop.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.dao.admin.RoleDao;
import com.shop.dao.admin.UserDao;
import com.shop.domain.admin.Role;
import com.shop.domain.admin.User;
import com.shop.dto.admin.UserDTO;
import com.shop.service.BaseServiceImpl;
import com.shop.service.admin.IUserService;

/**
 * @date 20180602
 * @author 张林
 * @description 用户 服务接口实现
 * @gitHub:https://github.com/lzdn
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Transactional(value = "manageTransactionManager")
	public void deleteByPk(Integer userId) {

		userDao.deleteByPrimaryKey(userId);
	}

    public User findByPk(Integer userId){

		return userDao.selectByPrimaryKey(userId);
	}

	@Transactional(value = "manageTransactionManager")
	public void insertUser(UserDTO userDTO) throws Exception {

		userDao.insertSelective(userDTO);
	}

	@Transactional(value = "manageTransactionManager")
	public void updateUser(UserDTO userDTO) throws Exception {

		userDao.updateByPrimaryKeySelective(userDTO);
	}

	@Override
	public User selectUserRoleByPk(Integer userId) {

		return userDao.selectUserRoleByPk(userId);
	}

	@Override
	public User findByAccount(String account) {
		return userDao.findByAccount(account);
	}

	@Override
	@Transactional(value = "manageTransactionManager")
	public void addUserRole(Integer userId, Integer roleId) {
		userDao.deleteUserRole(userId);
		userDao.addUserRole(userId, roleId);
	}

	public PageInfo<User> findSplitPage(UserDTO userDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if (userDTO != null) {
			if (userDTO.getUserId() != null) {
				map.put("userId", userDTO.getUserId());
			}
			if (userDTO.getDeptId() != null) {
				map.put("deptId", userDTO.getDeptId());
			}
			if (userDTO.getAvatar() != null) {
				map.put("avatar", userDTO.getAvatar());
			}
			if (userDTO.getAccount() != null) {
				map.put("account", userDTO.getAccount());
			}
			if (userDTO.getPassword() != null) {
				map.put("password", userDTO.getPassword());
			}
			if (userDTO.getSalt() != null) {
				map.put("salt", userDTO.getSalt());
			}
			if (userDTO.getUsername() != null) {
				map.put("username", userDTO.getUsername());
			}
			if (userDTO.getBirthday() != null) {
				map.put("birthday", userDTO.getBirthday());
			}
			if (userDTO.getSex() != null) {
				map.put("sex", userDTO.getSex());
			}
			if (userDTO.getEmail() != null) {
				map.put("email", userDTO.getEmail());
			}
			if (userDTO.getPhone() != null) {
				map.put("phone", userDTO.getPhone());
			}
			if (userDTO.getStatus() != null) {
				map.put("status", userDTO.getStatus());
			}
			if (userDTO.getCreateTime() != null) {
				map.put("createTime", userDTO.getCreateTime());
			}
			if (userDTO.getUpdateTime() != null) {
				map.put("updateTime", userDTO.getUpdateTime());
			}
			if (userDTO.getLoginTime() != null) {
				map.put("loginTime", userDTO.getLoginTime());
			}
			if (userDTO.getLastLoginTime() != null) {
				map.put("lastLoginTime", userDTO.getLastLoginTime());
			}
		}
		PageHelper.startPage(userDTO.getPageNo(), userDTO.getPageSize());
		List<User> list = userDao.findSplitPage(map);
		setUserRole(list);
		return new PageInfo<User>(list);
	}
	
	/**
	 * 查询出用户的角色
	 */
	public void setUserRole(List<User> list) {
		for (User user : list) {
			Role role = roleDao.findRoleOneByUserId(user.getUserId());
			user.setRole(role);
		}
	}
	
	public List<User> findAll(UserDTO userDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(userDTO!=null){
			if(userDTO.getUserId()!=null){
				map.put("userId",userDTO.getUserId());
			}
			if(userDTO.getDeptId()!=null){
				map.put("deptId",userDTO.getDeptId());
			}
			if(userDTO.getAvatar()!=null){
				map.put("avatar",userDTO.getAvatar());
			}
			if(userDTO.getAccount()!=null){
				map.put("account",userDTO.getAccount());
			}
			if(userDTO.getPassword()!=null){
				map.put("password",userDTO.getPassword());
			}
			if(userDTO.getSalt()!=null){
				map.put("salt",userDTO.getSalt());
			}
			if(userDTO.getUsername()!=null){
				map.put("username",userDTO.getUsername());
			}
			if(userDTO.getBirthday()!=null){
				map.put("birthday",userDTO.getBirthday());
			}
			if(userDTO.getSex()!=null){
				map.put("sex",userDTO.getSex());
			}
			if(userDTO.getEmail()!=null){
				map.put("email",userDTO.getEmail());
			}
			if(userDTO.getPhone()!=null){
				map.put("phone",userDTO.getPhone());
			}
			if(userDTO.getStatus()!=null){
				map.put("status",userDTO.getStatus());
			}
			if(userDTO.getCreateTime()!=null){
				map.put("createTime",userDTO.getCreateTime());
			}
			if(userDTO.getUpdateTime()!=null){
				map.put("updateTime",userDTO.getUpdateTime());
			}
			if(userDTO.getLoginTime()!=null){
				map.put("loginTime",userDTO.getLoginTime());
			}
			if(userDTO.getLastLoginTime()!=null){
				map.put("lastLoginTime",userDTO.getLastLoginTime());
			}
		}
		List<User> list = userDao.findAll(map);
		return list;
	}
	
}