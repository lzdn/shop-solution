package com.shop.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageHelper;
import  com.github.pagehelper.PageInfo;
import  com.shop.manage.dao.UserDao;
import  com.shop.manage.dto.UserDTO;
import  com.shop.manage.service.IUserService;
import  com.shop.service.base.BaseServiceImpl;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

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

  
	public void deleteByPk(Integer userId){
	
		userDao.deleteByPrimaryKey(userId);
	}

    public UserDTO findByPk(Integer userId){
    
    	return userDao.selectByPrimaryKey(userId);
    }
    
	
	public void insertUser(UserDTO userDTO) throws Exception{
	
		userDao.insertSelective(userDTO);
	}
	
	public void updateUser(UserDTO userDTO) throws Exception{
		
		userDao.updateByPrimaryKeySelective(userDTO);
	}
	
	public PageInfo<UserDTO> findSplitPage(UserDTO userDTO){
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
		PageHelper.startPage(userDTO.getPageNo(), userDTO.getPageSize());
		List<UserDTO> list = userDao.findSplitPage(map);
		return new PageInfo<UserDTO>(list);
	}
	
}