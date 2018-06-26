package com.shop.service.impl.product;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.shop.service.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.shop.dao.product.GoodsDao;
import com.shop.dto.product.GoodsDTO;
import com.shop.domain.product.Goods;
import com.shop.service.product.IGoodsService;



/**
* @date 20180602
* @author 张林
* @description 商品表 服务接口实现
* @gitHub:https://github.com/lzdn
*/
@Service
public class GoodsServiceImpl extends BaseServiceImpl implements IGoodsService {

    @Autowired
    private GoodsDao goodsDao;

  
	public void deleteByPk(Integer goodId){
	
		goodsDao.deleteByPrimaryKey(goodId);
	}

    public Goods findByPk(Integer goodId){
    
    	return goodsDao.selectByPrimaryKey(goodId);
    }
    
	
	public void insertGoods(GoodsDTO goodsDTO) throws Exception{
	
		goodsDao.insertSelective(goodsDTO);
	}
	
	public void updateGoods(GoodsDTO goodsDTO) throws Exception{
		
		goodsDao.updateByPrimaryKeySelective(goodsDTO);
	}
	
	public PageInfo<Goods> findSplitPage(GoodsDTO goodsDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(goodsDTO!=null){
			if(goodsDTO.getGoodId()!=null){
				map.put("goodId",goodsDTO.getGoodId());
			}
			if(goodsDTO.getCode()!=null){
				map.put("code",goodsDTO.getCode());
			}
			if(goodsDTO.getCatId()!=null){
				map.put("catId",goodsDTO.getCatId());
			}
			if(goodsDTO.getName()!=null){
				map.put("name",goodsDTO.getName());
			}
			if(goodsDTO.getSubName()!=null){
				map.put("subName",goodsDTO.getSubName());
			}
			if(goodsDTO.getBrandId()!=null){
				map.put("brandId",goodsDTO.getBrandId());
			}
			if(goodsDTO.getGoodType()!=null){
				map.put("goodType",goodsDTO.getGoodType());
			}
			if(goodsDTO.getVirType()!=null){
				map.put("virType",goodsDTO.getVirType());
			}
			if(goodsDTO.getPrice()!=null){
				map.put("price",goodsDTO.getPrice());
			}
			if(goodsDTO.getMarketPrice()!=null){
				map.put("marketPrice",goodsDTO.getMarketPrice());
			}
			if(goodsDTO.getCostPrice()!=null){
				map.put("costPrice",goodsDTO.getCostPrice());
			}
			if(goodsDTO.getWeight()!=null){
				map.put("weight",goodsDTO.getWeight());
			}
			if(goodsDTO.getSn()!=null){
				map.put("sn",goodsDTO.getSn());
			}
			if(goodsDTO.getBarCode()!=null){
				map.put("barCode",goodsDTO.getBarCode());
			}
			if(goodsDTO.getUnit()!=null){
				map.put("unit",goodsDTO.getUnit());
			}
			if(goodsDTO.getNumber()!=null){
				map.put("number",goodsDTO.getNumber());
			}
			if(goodsDTO.getWarnNum()!=null){
				map.put("warnNum",goodsDTO.getWarnNum());
			}
			if(goodsDTO.getStatus()!=null){
				map.put("status",goodsDTO.getStatus());
			}
			if(goodsDTO.getCreateTime()!=null){
				map.put("createTime",goodsDTO.getCreateTime());
			}
			if(goodsDTO.getUpdateTime()!=null){
				map.put("updateTime",goodsDTO.getUpdateTime());
			}
			if(goodsDTO.getUpTime()!=null){
				map.put("upTime",goodsDTO.getUpTime());
			}
			if(goodsDTO.getDownTime()!=null){
				map.put("downTime",goodsDTO.getDownTime());
			}
			if(goodsDTO.getSaleNum()!=null){
				map.put("saleNum",goodsDTO.getSaleNum());
			}
			if(goodsDTO.getVirtualNum()!=null){
				map.put("virtualNum",goodsDTO.getVirtualNum());
			}
			if(goodsDTO.getPoint()!=null){
				map.put("point",goodsDTO.getPoint());
			}
			if(goodsDTO.getCommentReward()!=null){
				map.put("commentReward",goodsDTO.getCommentReward());
			}
			if(goodsDTO.getImg()!=null){
				map.put("img",goodsDTO.getImg());
			}
			if(goodsDTO.getThumb()!=null){
				map.put("thumb",goodsDTO.getThumb());
			}
			if(goodsDTO.getImgs()!=null){
				map.put("imgs",goodsDTO.getImgs());
			}
			if(goodsDTO.getSpecs()!=null){
				map.put("specs",goodsDTO.getSpecs());
			}
			if(goodsDTO.getDetails()!=null){
				map.put("details",goodsDTO.getDetails());
			}
			if(goodsDTO.getDetailsM()!=null){
				map.put("detailsM",goodsDTO.getDetailsM());
			}
			if(goodsDTO.getService()!=null){
				map.put("service",goodsDTO.getService());
			}
			if(goodsDTO.getServiceM()!=null){
				map.put("serviceM",goodsDTO.getServiceM());
			}
			if(goodsDTO.getRecommend()!=null){
				map.put("recommend",goodsDTO.getRecommend());
			}
			if(goodsDTO.getKeyword()!=null){
				map.put("keyword",goodsDTO.getKeyword());
			}
			if(goodsDTO.getDescription()!=null){
				map.put("description",goodsDTO.getDescription());
			}
			if(goodsDTO.getSort()!=null){
				map.put("sort",goodsDTO.getSort());
			}
			if(goodsDTO.getHot()!=null){
				map.put("hot",goodsDTO.getHot());
			}
			if(goodsDTO.getNews()!=null){
				map.put("news",goodsDTO.getNews());
			}
			if(goodsDTO.getBest()!=null){
				map.put("best",goodsDTO.getBest());
			}
			if(goodsDTO.getFreeShipping()!=null){
				map.put("freeShipping",goodsDTO.getFreeShipping());
			}
			if(goodsDTO.getClick()!=null){
				map.put("click",goodsDTO.getClick());
			}
		}
		PageHelper.startPage(goodsDTO.getPageNo(), goodsDTO.getPageSize());
		List<Goods> list = goodsDao.findSplitPage(map);
		return new PageInfo<Goods>(list);
	}
	
	public List<Goods> findAll(GoodsDTO goodsDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		if(goodsDTO!=null){
			if(goodsDTO.getGoodId()!=null){
				map.put("goodId",goodsDTO.getGoodId());
			}
			if(goodsDTO.getCode()!=null){
				map.put("code",goodsDTO.getCode());
			}
			if(goodsDTO.getCatId()!=null){
				map.put("catId",goodsDTO.getCatId());
			}
			if(goodsDTO.getName()!=null){
				map.put("name",goodsDTO.getName());
			}
			if(goodsDTO.getSubName()!=null){
				map.put("subName",goodsDTO.getSubName());
			}
			if(goodsDTO.getBrandId()!=null){
				map.put("brandId",goodsDTO.getBrandId());
			}
			if(goodsDTO.getGoodType()!=null){
				map.put("goodType",goodsDTO.getGoodType());
			}
			if(goodsDTO.getVirType()!=null){
				map.put("virType",goodsDTO.getVirType());
			}
			if(goodsDTO.getPrice()!=null){
				map.put("price",goodsDTO.getPrice());
			}
			if(goodsDTO.getMarketPrice()!=null){
				map.put("marketPrice",goodsDTO.getMarketPrice());
			}
			if(goodsDTO.getCostPrice()!=null){
				map.put("costPrice",goodsDTO.getCostPrice());
			}
			if(goodsDTO.getWeight()!=null){
				map.put("weight",goodsDTO.getWeight());
			}
			if(goodsDTO.getSn()!=null){
				map.put("sn",goodsDTO.getSn());
			}
			if(goodsDTO.getBarCode()!=null){
				map.put("barCode",goodsDTO.getBarCode());
			}
			if(goodsDTO.getUnit()!=null){
				map.put("unit",goodsDTO.getUnit());
			}
			if(goodsDTO.getNumber()!=null){
				map.put("number",goodsDTO.getNumber());
			}
			if(goodsDTO.getWarnNum()!=null){
				map.put("warnNum",goodsDTO.getWarnNum());
			}
			if(goodsDTO.getStatus()!=null){
				map.put("status",goodsDTO.getStatus());
			}
			if(goodsDTO.getCreateTime()!=null){
				map.put("createTime",goodsDTO.getCreateTime());
			}
			if(goodsDTO.getUpdateTime()!=null){
				map.put("updateTime",goodsDTO.getUpdateTime());
			}
			if(goodsDTO.getUpTime()!=null){
				map.put("upTime",goodsDTO.getUpTime());
			}
			if(goodsDTO.getDownTime()!=null){
				map.put("downTime",goodsDTO.getDownTime());
			}
			if(goodsDTO.getSaleNum()!=null){
				map.put("saleNum",goodsDTO.getSaleNum());
			}
			if(goodsDTO.getVirtualNum()!=null){
				map.put("virtualNum",goodsDTO.getVirtualNum());
			}
			if(goodsDTO.getPoint()!=null){
				map.put("point",goodsDTO.getPoint());
			}
			if(goodsDTO.getCommentReward()!=null){
				map.put("commentReward",goodsDTO.getCommentReward());
			}
			if(goodsDTO.getImg()!=null){
				map.put("img",goodsDTO.getImg());
			}
			if(goodsDTO.getThumb()!=null){
				map.put("thumb",goodsDTO.getThumb());
			}
			if(goodsDTO.getImgs()!=null){
				map.put("imgs",goodsDTO.getImgs());
			}
			if(goodsDTO.getSpecs()!=null){
				map.put("specs",goodsDTO.getSpecs());
			}
			if(goodsDTO.getDetails()!=null){
				map.put("details",goodsDTO.getDetails());
			}
			if(goodsDTO.getDetailsM()!=null){
				map.put("detailsM",goodsDTO.getDetailsM());
			}
			if(goodsDTO.getService()!=null){
				map.put("service",goodsDTO.getService());
			}
			if(goodsDTO.getServiceM()!=null){
				map.put("serviceM",goodsDTO.getServiceM());
			}
			if(goodsDTO.getRecommend()!=null){
				map.put("recommend",goodsDTO.getRecommend());
			}
			if(goodsDTO.getKeyword()!=null){
				map.put("keyword",goodsDTO.getKeyword());
			}
			if(goodsDTO.getDescription()!=null){
				map.put("description",goodsDTO.getDescription());
			}
			if(goodsDTO.getSort()!=null){
				map.put("sort",goodsDTO.getSort());
			}
			if(goodsDTO.getHot()!=null){
				map.put("hot",goodsDTO.getHot());
			}
			if(goodsDTO.getNews()!=null){
				map.put("news",goodsDTO.getNews());
			}
			if(goodsDTO.getBest()!=null){
				map.put("best",goodsDTO.getBest());
			}
			if(goodsDTO.getFreeShipping()!=null){
				map.put("freeShipping",goodsDTO.getFreeShipping());
			}
			if(goodsDTO.getClick()!=null){
				map.put("click",goodsDTO.getClick());
			}
		}
		List<Goods> list = goodsDao.findAll(map);
		return list;
	}
	
}