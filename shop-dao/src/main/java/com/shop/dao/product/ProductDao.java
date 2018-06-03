package com.shop.dao.product;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.product.Product;
import com.shop.dto.product.ProductDTO;


/**
* @date 20180602
* @author 张林
* @description 部门数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface ProductDao extends BaseDao {

	int deleteByPrimaryKey(Integer productId);
	
	ProductDTO selectByPrimaryKey(Integer productId);

	int insertSelective(Product product);

	int updateByPrimaryKeySelective(Product product);

	List<ProductDTO> findSplitPage(Map<String, Object> map); 
	
}