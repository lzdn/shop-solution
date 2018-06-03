package com.shop.service.product;

import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import com.shop.dto.product.ProductDTO;

/**
* @date 20180602
* @author 张林
* @description 部门 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IProductService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Product
    */
	void deleteByPk(Integer productId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Product
    */
    ProductDTO findByPk(Integer productId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Product
    */
    void insertProduct(ProductDTO productDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Product
    */
    void updateProduct(ProductDTO productDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Product
    */
	PageInfo<ProductDTO> findSplitPage(ProductDTO productDTO);
}