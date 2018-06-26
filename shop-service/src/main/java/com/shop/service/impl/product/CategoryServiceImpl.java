package com.shop.service.impl.product;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.product.CategoryDao;
import com.shop.dto.product.CategoryDTO;
import com.shop.domain.product.Category;
import com.shop.service.product.ICategoryService;



/**
* @date 20180602
* @author 张林
* @description 商品分类表 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class CategoryServiceImpl extends BaseServiceImpl implements ICategoryService {

    @Autowired
    private CategoryDao categoryDao;

  
	public void deleteByPk(Integer id){
	
		categoryDao.deleteByPrimaryKey(id);
	}

    public Category findByPk(Integer id){
    
    	return categoryDao.selectByPrimaryKey(id);
    }
    
	
	public void insertCategory(CategoryDTO categoryDTO) throws Exception{
	
		categoryDao.insertSelective(categoryDTO);
	}
	
	public void updateCategory(CategoryDTO categoryDTO) throws Exception{
		
		categoryDao.updateByPrimaryKeySelective(categoryDTO);
	}
	
	public PageInfo<Category> findSplitPage(CategoryDTO categoryDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(categoryDTO!=null){
			if(categoryDTO.getId()!=null){
				map.put("id",categoryDTO.getId());
			}
			if(categoryDTO.getName()!=null){
				map.put("name",categoryDTO.getName());
			}
			if(categoryDTO.getPid()!=null){
				map.put("pid",categoryDTO.getPid());
			}
			if(categoryDTO.getTypeId()!=null){
				map.put("typeId",categoryDTO.getTypeId());
			}
			if(categoryDTO.getKeywords()!=null){
				map.put("keywords",categoryDTO.getKeywords());
			}
			if(categoryDTO.getDescription()!=null){
				map.put("description",categoryDTO.getDescription());
			}
			if(categoryDTO.getGrade()!=null){
				map.put("grade",categoryDTO.getGrade());
			}
			if(categoryDTO.getStatus()!=null){
				map.put("status",categoryDTO.getStatus());
			}
			if(categoryDTO.getSort()!=null){
				map.put("sort",categoryDTO.getSort());
			}
			if(categoryDTO.getIcon()!=null){
				map.put("icon",categoryDTO.getIcon());
			}
			if(categoryDTO.getLink()!=null){
				map.put("link",categoryDTO.getLink());
			}
			if(categoryDTO.getLevel()!=null){
				map.put("level",categoryDTO.getLevel());
			}
			if(categoryDTO.getNum()!=null){
				map.put("num",categoryDTO.getNum());
			}
			if(categoryDTO.getRemark()!=null){
				map.put("remark",categoryDTO.getRemark());
			}
		}
		PageHelper.startPage(categoryDTO.getPageNo(), categoryDTO.getPageSize());
		List<Category> list = categoryDao.findSplitPage(map);
		return new PageInfo<Category>(list);
	}
	
	public List<Category> findAll(CategoryDTO categoryDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(categoryDTO!=null){
			if(categoryDTO.getId()!=null){
				map.put("id",categoryDTO.getId());
			}
			if(categoryDTO.getName()!=null){
				map.put("name",categoryDTO.getName());
			}
			if(categoryDTO.getPid()!=null){
				map.put("pid",categoryDTO.getPid());
			}
			if(categoryDTO.getTypeId()!=null){
				map.put("typeId",categoryDTO.getTypeId());
			}
			if(categoryDTO.getKeywords()!=null){
				map.put("keywords",categoryDTO.getKeywords());
			}
			if(categoryDTO.getDescription()!=null){
				map.put("description",categoryDTO.getDescription());
			}
			if(categoryDTO.getGrade()!=null){
				map.put("grade",categoryDTO.getGrade());
			}
			if(categoryDTO.getStatus()!=null){
				map.put("status",categoryDTO.getStatus());
			}
			if(categoryDTO.getSort()!=null){
				map.put("sort",categoryDTO.getSort());
			}
			if(categoryDTO.getIcon()!=null){
				map.put("icon",categoryDTO.getIcon());
			}
			if(categoryDTO.getLink()!=null){
				map.put("link",categoryDTO.getLink());
			}
			if(categoryDTO.getLevel()!=null){
				map.put("level",categoryDTO.getLevel());
			}
			if(categoryDTO.getNum()!=null){
				map.put("num",categoryDTO.getNum());
			}
			if(categoryDTO.getRemark()!=null){
				map.put("remark",categoryDTO.getRemark());
			}
		}
		List<Category> list = categoryDao.findAll(map);
		return list;
	}
	
}