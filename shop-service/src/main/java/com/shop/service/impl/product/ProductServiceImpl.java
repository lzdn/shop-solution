package com.shop.service.impl.product;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.product.ProductDao;
import com.shop.dto.product.ProductDTO;
import com.shop.service.product.IProductService;



/**
* @date 20180602
* @author 张林
* @description 部门 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class ProductServiceImpl extends BaseServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

  
	public void deleteByPk(Integer productId){
	
		productDao.deleteByPrimaryKey(productId);
	}

    public ProductDTO findByPk(Integer productId){
    
    	return productDao.selectByPrimaryKey(productId);
    }
    
	
	public void insertProduct(ProductDTO productDTO) throws Exception{
	
		productDao.insertSelective(productDTO);
	}
	
	public void updateProduct(ProductDTO productDTO) throws Exception{
		
		productDao.updateByPrimaryKeySelective(productDTO);
	}
	
	public PageInfo<ProductDTO> findSplitPage(ProductDTO productDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(productDTO!=null){
			if(productDTO.getProductId()!=null){
				map.put("productId",productDTO.getProductId());
			}
			if(productDTO.getContent()!=null){
				map.put("content",productDTO.getContent());
			}
			if(productDTO.getDescription()!=null){
				map.put("description",productDTO.getDescription());
			}
		}
		PageHelper.startPage(productDTO.getPageNo(), productDTO.getPageSize());
		List<ProductDTO> list = productDao.findSplitPage(map);
		return new PageInfo<ProductDTO>(list);
	}
	
}