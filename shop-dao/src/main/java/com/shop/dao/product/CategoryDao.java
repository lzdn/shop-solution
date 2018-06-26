package com.shop.dao.product;

import java.util.Map;
import java.util.List;
import com.shop.dao.BaseDao;
import com.shop.domain.product.Category;


/**
* @date 20180602
* @author 张林
* @description 商品分类表数据持久层
* @gitHub:https://github.com/lzdn
*/
public interface CategoryDao extends BaseDao {

	int deleteByPrimaryKey(Integer id);
	
	Category selectByPrimaryKey(Integer id);

	int insertSelective(Category category);

	int updateByPrimaryKeySelective(Category category);

	List<Category> findSplitPage(Map<String, Object> map); 
	
	List<Category> findAll(Map<String, Object> map);
}