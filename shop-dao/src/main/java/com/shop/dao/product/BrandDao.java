package com.shop.dao.product;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.product.Brand;


/**
* @date 20180602
* @author 张林
* @description 品牌表数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface BrandDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	Brand selectByPrimaryKey(Integer id);

	int insertSelective(Brand brand);

	int updateByPrimaryKeySelective(Brand brand);

	List<Brand> findSplitPage(Map<String, Object> map); 
	
	List<Brand> findAll(Map<String, Object> map);
}