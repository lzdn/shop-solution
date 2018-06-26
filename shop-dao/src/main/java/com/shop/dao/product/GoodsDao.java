package com.shop.dao.product;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.product.Goods;


/**
* @date 20180602
* @author 张林
* @description 商品表数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface GoodsDao extends BaseDao {

	int deleteByPrimaryKey(Integer goodId);
	
	Goods selectByPrimaryKey(Integer goodId);

	int insertSelective(Goods goods);

	int updateByPrimaryKeySelective(Goods goods);

	List<Goods> findSplitPage(Map<String, Object> map); 
	
	List<Goods> findAll(Map<String, Object> map);
}