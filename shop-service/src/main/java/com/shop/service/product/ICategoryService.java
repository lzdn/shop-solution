package com.shop.service.product;

import java.util.List;
import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import com.shop.domain.product.Category;
import com.shop.dto.product.CategoryDTO;


/**
* @date 20180602
* @author 张林
* @description 商品分类表 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface ICategoryService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Category
    */
	void deleteByPk(Integer id);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Category
    */
    Category findByPk(Integer id);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Category
    */
    void insertCategory(CategoryDTO categoryDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Category
    */
    void updateCategory(CategoryDTO categoryDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Category
    */
	PageInfo<Category> findSplitPage(CategoryDTO categoryDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部Category
    */
	List<Category> findAll(CategoryDTO categoryDTO);
}