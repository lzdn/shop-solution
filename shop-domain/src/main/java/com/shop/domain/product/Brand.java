package com.shop.domain.product;


import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 品牌表
* @gitHub:https://github.com/lzdn
*/
public class Brand extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Brand(){
	
	}
	/**
    *注释：品牌id
    */
	private Integer id;
	/**
    *注释：品牌名称
    */
	private String name;
	/**
    *注释：
    */
	private String banner;
	/**
    *注释：品牌logo
    */
	private String logo;
	/**
    *注释：品牌描述
    */
	private String description;
	/**
    *注释：品牌的地址
    */
	private String url;
	/**
    *注释：状态(是否显示，显示:1,隐藏:0)
    */
	private Boolean status;
	/**
    *注释：是否推荐
    */
	private Boolean recommend;
	/**
    *注释：排序
    */
	private Integer sort;
	/**
    *注释：
    */
	private String catIds;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBanner() {
        return this.banner;
    }
    public void setBanner(String banner) {
        this.banner = banner;
    }
    public String getLogo() {
        return this.logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
	public Boolean getStatus() {
        return this.status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
	public Boolean getRecommend() {
        return this.recommend;
    }
    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getCatIds() {
        return this.catIds;
    }
    public void setCatIds(String catIds) {
        this.catIds = catIds;
    }
}