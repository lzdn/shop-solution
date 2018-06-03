package com.shop.service.admin;

import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import com.shop.dto.admin.UserDTO;

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
    UserDTO findByPk(Integer userId);

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
	PageInfo<UserDTO> findSplitPage(UserDTO userDTO);
	
	/**
	 * 根据账户 查询
	 * @param account
	 * @return
	 */
	UserDTO findByAccount(String account);
	
	/**
	 * 根据账户 查询ROle
	 * @param account
	 * @return
	 */
	UserDTO selectUserRoleByPk(Integer userId);
	
	/**
	 * 给用户赋角色
	 * @param account
	 * @return
	 */
	void addUserRole(Integer userId,Integer roleId);
}