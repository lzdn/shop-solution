package com.shop.service.product;

import java.util.List;
import com.shop.service.IBaseService;
import com.github.pagehelper.PageInfo;
import com.shop.domain.product.Goods;
import com.shop.dto.product.GoodsDTO;


/**
* @date 20180602
* @author 张林
* @description 商品表 服务接口
* @gitHub:https://github.com/lzdn
*/
public interface IGoodsService extends IBaseService {

    
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键删除Goods
    */
	void deleteByPk(Integer goodId);
    /**
    * @date 20180602
	* @author 张林
    * 描述：根据主键查询Goods
    */
    Goods findByPk(Integer goodId);

	/**
	* @date 20180602
	* @author 张林
    * 描述：新增Goods
    */
    void insertGoods(GoodsDTO goodsDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：修改Goods
    */
    void updateGoods(GoodsDTO goodsDTO) throws Exception;

	/**
	* @date 20180602
	* @author 张林
    * 描述：分页Goods
    */
	PageInfo<Goods> findSplitPage(GoodsDTO goodsDTO);
	
	/**
	* @date 20180602
	* @author 张林
    * 描述：查询全部Goods
    */
	List<Goods> findAll(GoodsDTO goodsDTO);
}