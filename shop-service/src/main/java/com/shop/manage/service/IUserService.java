package com.shop.manage.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.base.IBaseService;
import com.shop.manage.dto.UserDTO;

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
}