package com.shop.service.admin;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.shop.domain.admin.Dict;
import com.shop.dto.admin.DictDTO;
import com.shop.service.IBaseService;

/**
* @date 20180602
* @author 张林
* @description 系统字典 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IDictService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Dict
    */
	void deleteByPk(Integer id);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Dict
    */
    Dict findByPk(Integer id);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Dict
    */
    void insertDict(DictDTO dictDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Dict
    */
    void updateDict(DictDTO dictDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Dict
    */
	PageInfo<Dict> findSplitPage(DictDTO dictDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部Dict
    */
	List<Dict> findAll(DictDTO dictDTO);
}