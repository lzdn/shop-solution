package com.shop.domain.product;


import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 商品分类表
* @gitHub:https://github.com/lzdn
*/
public class Category extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Category(){
	
	}
	/**
    *注释：
    */
	private Integer id;
	/**
    *注释：分类名称
    */
	private String name;
	/**
    *注释：父级分类id
    */
	private Integer pid;
	/**
    *注释：商品类型id
    */
	private Integer typeId;
	/**
    *注释：
    */
	private String keywords;
	/**
    *注释：
    */
	private String description;
	/**
    *注释：价格分级
    */
	private String grade;
	/**
    *注释：状态:0:关闭，1:开启
    */
	private Boolean status;
	/**
    *注释：排序
    */
	private Integer sort;
	/**
    *注释：分类前面的小图标
    */
	private String icon;
	/**
    *注释：外部链接
    */
	private String link;
	/**
    *注释：
    */
	private Integer level;
	/**
    *注释：商品数量
    */
	private Short num;
	/**
    *注释：
    */
	private String remark;

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
    public Integer getPid() {
        return this.pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getTypeId() {
        return this.typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public String getKeywords() {
        return this.keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getGrade() {
        return this.grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
	public Boolean getStatus() {
        return this.status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Integer getSort() {
        return this.sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public Integer getLevel() {
        return this.level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
	public Short getNum() {
        return this.num;
    }
    public void setNum(Short num) {
        this.num = num;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}