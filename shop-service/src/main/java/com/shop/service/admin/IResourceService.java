package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Resource;
import com.shop.dto.admin.ResourceDTO;
import com.shop.service.IBaseService;

/**
 * @date 20180602
 * @author 张林
 * @description 系统资源 服务接口
 * @gitHub:https://github.com/lzdn
 */
public interface IResourceService extends IBaseService {

	/**
	 * @date 20180602
	 * @author 张林 描述：根据主键删除Resource
	 */
	void deleteByPk(Integer id);

	/**
	 * @date 20180602
	 * @author 张林 描述：根据主键查询Resource
	 */
	Resource findByPk(Integer id);

	/**
	 * @date 20180602
	 * @author 张林 描述：新增Resource
	 */
	void insertResource(ResourceDTO resourceDTO) throws Exception;

	/**
	 * @date 20180602
	 * @author 张林 描述：修改Resource
	 */
	void updateResource(ResourceDTO resourceDTO) throws Exception;

	/**
	 * @date 20180602
	 * @author 张林 描述：分页Resource
	 */
	PageInfo<Resource> findSplitPage(ResourceDTO resourceDTO);

	/**
	 * @date 20180602
	 * @author 张林 描述：查看全部
	 */
	List<Resource> findAll(ResourceDTO resourceDTO);

}