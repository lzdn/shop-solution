package com.shop.domain.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 商品表
* @gitHub:https://github.com/lzdn
*/
public class Goods extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Goods(){
	
	}
	/**
    *注释：
    */
	private Integer goodId;
	/**
    *注释：
    */
	private String code;
	/**
    *注释：
    */
	private Short catId;
	/**
    *注释：
    */
	private String name;
	/**
    *注释：
    */
	private String subName;
	/**
    *注释：
    */
	private Short brandId;
	/**
    *注释：
    */
	private Short goodType;
	/**
    *注释：
    */
	private Boolean virType;
	/**
    *注释：
    */
	private BigDecimal price;
	/**
    *注释：
    */
	private BigDecimal marketPrice;
	/**
    *注释：
    */
	private BigDecimal costPrice;
	/**
    *注释：
    */
	private Integer weight;
	/**
    *注释：
    */
	private String sn;
	/**
    *注释：
    */
	private String barCode;
	/**
    *注释：
    */
	private String unit;
	/**
    *注释：
    */
	private Integer number;
	/**
    *注释：
    */
	private Short warnNum;
	/**
    *注释：
    */
	private Boolean status;
	/**
    *注释：
    */
	private Date createTime;
	/**
    *注释：
    */
	private Date updateTime;
	/**
    *注释：
    */
	private Date upTime;
	/**
    *注释：
    */
	private Date downTime;
	/**
    *注释：
    */
	private Integer saleNum;
	/**
    *注释：
    */
	private Integer virtualNum;
	/**
    *注释：
    */
	private Short point;
	/**
    *注释：晒单+5星好评返现或积分
    */
	private BigDecimal commentReward;
	/**
    *注释：
    */
	private String img;
	/**
    *注释：
    */
	private String thumb;
	/**
    *注释：
    */
	private String imgs;
	/**
    *注释：
    */
	private String specs;
	/**
    *注释：
    */
	private String details;
	/**
    *注释：手机版详情
    */
	private String detailsM;
	/**
    *注释：
    */
	private String service;
	/**
    *注释：手机其它内容
    */
	private String serviceM;
	/**
    *注释：
    */
	private Boolean recommend;
	/**
    *注释：
    */
	private String keyword;
	/**
    *注释：
    */
	private String description;
	/**
    *注释：
    */
	private Integer sort;
	/**
    *注释：
    */
	private Boolean hot;
	/**
    *注释：
    */
	private Boolean news;
	/**
    *注释：
    */
	private Boolean best;
	/**
    *注释：
    */
	private Boolean freeShipping;
	/**
    *注释：点击数
    */
	private Integer click;

    public Integer getGoodId() {
        return this.goodId;
    }
    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
    public String getCode() {
        return this.code;
    }
    public void setCode(String code) {
        this.code = code;
    }
	public Short getCatId() {
        return this.catId;
    }
    public void setCatId(Short catId) {
        this.catId = catId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubName() {
        return this.subName;
    }
    public void setSubName(String subName) {
        this.subName = subName;
    }
	public Short getBrandId() {
        return this.brandId;
    }
    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }
	public Short getGoodType() {
        return this.goodType;
    }
    public void setGoodType(Short goodType) {
        this.goodType = goodType;
    }
	public Boolean getVirType() {
        return this.virType;
    }
    public void setVirType(Boolean virType) {
        this.virType = virType;
    }
	public BigDecimal getPrice() {
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
	public BigDecimal getMarketPrice() {
        return this.marketPrice;
    }
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }
	public BigDecimal getCostPrice() {
        return this.costPrice;
    }
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
    public Integer getWeight() {
        return this.weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public String getSn() {
        return this.sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    public String getBarCode() {
        return this.barCode;
    }
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
    public String getUnit() {
        return this.unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Integer getNumber() {
        return this.number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
	public Short getWarnNum() {
        return this.warnNum;
    }
    public void setWarnNum(Short warnNum) {
        this.warnNum = warnNum;
    }
	public Boolean getStatus() {
        return this.status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpTime() {
        return this.upTime;
    }
    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }
    public Date getDownTime() {
        return this.downTime;
    }
    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }
    public Integer getSaleNum() {
        return this.saleNum;
    }
    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
    public Integer getVirtualNum() {
        return this.virtualNum;
    }
    public void setVirtualNum(Integer virtualNum) {
        this.virtualNum = virtualNum;
    }
	public Short getPoint() {
        return this.point;
    }
    public void setPoint(Short point) {
        this.point = point;
    }
	public BigDecimal getCommentReward() {
        return this.commentReward;
    }
    public void setCommentReward(BigDecimal commentReward) {
        this.commentReward = commentReward;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getThumb() {
        return this.thumb;
    }
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    public String getImgs() {
        return this.imgs;
    }
    public void setImgs(String imgs) {
        this.imgs = imgs;
    }
    public String getSpecs() {
        return this.specs;
    }
    public void setSpecs(String specs) {
        this.specs = specs;
    }
    public String getDetails() {
        return this.details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getDetailsM() {
        return this.detailsM;
    }
    public void setDetailsM(String detailsM) {
        this.detailsM = detailsM;
    }
    public String getService() {
        return this.service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public String getServiceM() {
        return this.serviceM;
    }
    public void setServiceM(String serviceM) {
        this.serviceM = serviceM;
    }
	public Boolean getRecommend() {
        return this.recommend;
    }
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }
    public String getKeyword() {
        return this.keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
	public Boolean getHot() {
        return this.hot;
    }
    public void setHot(Boolean hot) {
        this.hot = hot;
    }
	public Boolean getNews() {
        return this.news;
    }
    public void setNews(Boolean news) {
        this.news = news;
    }
	public Boolean getBest() {
        return this.best;
    }
    public void setBest(Boolean best) {
        this.best = best;
    }
	public Boolean getFreeShipping() {
        return this.freeShipping;
    }
    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }
    public Integer getClick() {
        return this.click;
    }
    public void setClick(Integer click) {
        this.click = click;
    }
}