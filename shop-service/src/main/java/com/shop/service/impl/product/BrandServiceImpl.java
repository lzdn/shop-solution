package com.shop.service.impl.product;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.product.BrandDao;
import com.shop.dto.product.BrandDTO;
import com.shop.domain.product.Brand;
import com.shop.service.product.IBrandService;



/**
* @date 20180602
* @author 张林
* @description 品牌表 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class BrandServiceImpl extends BaseServiceImpl implements IBrandService {

    @Autowired
    private BrandDao brandDao;

  
	public void deleteByPk(Integer id){
	
		brandDao.deleteByPrimaryKey(id);
	}

    public Brand findByPk(Integer id){
    
    	return brandDao.selectByPrimaryKey(id);
    }
    
	
	public void insertBrand(BrandDTO brandDTO) throws Exception{
	
		brandDao.insertSelective(brandDTO);
	}
	
	public void updateBrand(BrandDTO brandDTO) throws Exception{
		
		brandDao.updateByPrimaryKeySelective(brandDTO);
	}
	
	public PageInfo<Brand> findSplitPage(BrandDTO brandDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(brandDTO!=null){
			if(brandDTO.getId()!=null){
				map.put("id",brandDTO.getId());
			}
			if(brandDTO.getName()!=null){
				map.put("name",brandDTO.getName());
			}
			if(brandDTO.getBanner()!=null){
				map.put("banner",brandDTO.getBanner());
			}
			if(brandDTO.getLogo()!=null){
				map.put("logo",brandDTO.getLogo());
			}
			if(brandDTO.getDescription()!=null){
				map.put("description",brandDTO.getDescription());
			}
			if(brandDTO.getUrl()!=null){
				map.put("url",brandDTO.getUrl());
			}
			if(brandDTO.getStatus()!=null){
				map.put("status",brandDTO.getStatus());
			}
			if(brandDTO.getRecommend()!=null){
				map.put("recommend",brandDTO.getRecommend());
			}
			if(brandDTO.getSort()!=null){
				map.put("sort",brandDTO.getSort());
			}
			if(brandDTO.getCatIds()!=null){
				map.put("catIds",brandDTO.getCatIds());
			}
		}
		PageHelper.startPage(brandDTO.getPageNo(), brandDTO.getPageSize());
		List<Brand> list = brandDao.findSplitPage(map);
		return new PageInfo<Brand>(list);
	}
	
	public List<Brand> findAll(BrandDTO brandDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(brandDTO!=null){
			if(brandDTO.getId()!=null){
				map.put("id",brandDTO.getId());
			}
			if(brandDTO.getName()!=null){
				map.put("name",brandDTO.getName());
			}
			if(brandDTO.getBanner()!=null){
				map.put("banner",brandDTO.getBanner());
			}
			if(brandDTO.getLogo()!=null){
				map.put("logo",brandDTO.getLogo());
			}
			if(brandDTO.getDescription()!=null){
				map.put("description",brandDTO.getDescription());
			}
			if(brandDTO.getUrl()!=null){
				map.put("url",brandDTO.getUrl());
			}
			if(brandDTO.getStatus()!=null){
				map.put("status",brandDTO.getStatus());
			}
			if(brandDTO.getRecommend()!=null){
				map.put("recommend",brandDTO.getRecommend());
			}
			if(brandDTO.getSort()!=null){
				map.put("sort",brandDTO.getSort());
			}
			if(brandDTO.getCatIds()!=null){
				map.put("catIds",brandDTO.getCatIds());
			}
		}
		List<Brand> list = brandDao.findAll(map);
		return list;
	}
	
}