package com.shop.manage.service;

import com.github.pagehelper.PageInfo;
import com.shop.service.base.IBaseService;
import com.shop.manage.dto.ResourceDTO;

/**
* @date 20180602
* @author 张林
* @description 系统资源 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IResourceService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Resource
    */
	void deleteByPk(Integer id);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Resource
    */
    ResourceDTO findByPk(Integer id);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Resource
    */
    void insertResource(ResourceDTO resourceDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Resource
    */
    void updateResource(ResourceDTO resourceDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Resource
    */
	PageInfo<ResourceDTO> findSplitPage(ResourceDTO resourceDTO);
}