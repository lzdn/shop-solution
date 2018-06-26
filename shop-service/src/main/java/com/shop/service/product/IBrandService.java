package com.shop.service.product;

import java.util.List;
import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import com.shop.domain.product.Brand;
import com.shop.dto.product.BrandDTO;


/**
* @date 20180602
* @author 张林
* @description 品牌表 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IBrandService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Brand
    */
	void deleteByPk(Integer id);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Brand
    */
    Brand findByPk(Integer id);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Brand
    */
    void insertBrand(BrandDTO brandDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Brand
    */
    void updateBrand(BrandDTO brandDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Brand
    */
	PageInfo<Brand> findSplitPage(BrandDTO brandDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部Brand
    */
	List<Brand> findAll(BrandDTO brandDTO);
}