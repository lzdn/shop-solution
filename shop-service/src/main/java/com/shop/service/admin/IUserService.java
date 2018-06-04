package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.User;
import com.shop.dto.admin.UserDTO;
import com.shop.service.IBaseService;

/**
* @date 20180602
* @author 张林
* @description 用户 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IUserService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除User
    */
	void deleteByPk(Integer userId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询User
    */
    User findByPk(Integer userId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增User
    */
    void insertUser(UserDTO userDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改User
    */
    void updateUser(UserDTO userDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页User
    */
	PageInfo<User> findSplitPage(UserDTO userDTO);
	
   /**
	* @date 20180602
	* @author 张林
    * 描述：查询全部User
    */
	List<User> findAll(UserDTO userDTO);
	
	/**
	 * 根据账户 查询
	 * @param account
	 * @return
	 */
	User findByAccount(String account);
	
	/**
	 * 根据账户 查询ROle
	 * @param account
	 * @return
	 */
	User selectUserRoleByPk(Integer userId);
	
	/**
	 * 给用户赋角色
	 * @param account
	 * @return
	 */
	void addUserRole(Integer userId,Integer roleId);
}