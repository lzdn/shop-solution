package com.shop.domain.admin;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.shop.domain.BaseEntity;

/**
 * @date 20180602
 * @author 张林
 * @description 系统资源
 * @gitHub:https://github.com/lzdn
 */
public class Resource extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public Resource() {

	}

	/**
	 * 注释：
	 */
	private Integer id;
	/**
	 * 注释：
	 */
	private String resourceKey;
	/**
	 * 注释：
	 */
	private String resourceValue;
	/**
	 * 注释：
	 */
	private String url;
	/**
	 * 注释：
	 */
	private Integer parentId;
	/**
	 * 注释：
	 */
	private Integer moduleId;
	/**
	 * 注释：
	 */
	private Integer level;
	/**
	 * 注释：
	 */
	private Boolean available;
	/**
	 * 注释：
	 */
	private Integer type;
	/**
	 * 注释：
	 */
	private String menuIcon;
	/**
	 * 注释：
	 */
	private Integer orderBy;
	/**
	 * 注释：创建时间
	 */
	private Date createTime;
	/**
	 * 注释：修改时间
	 */
	private Date updateTime;

	private Integer isCheck;

	private List<Resource> children;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourceKey() {
		return this.resourceKey;
	}

	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	public String getResourceValue() {
		return this.resourceValue;
	}

	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
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

	public Integer getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

	public List<Resource> getChildren() {
		return children;
	}

	public void setChildren(List<Resource> children) {
		this.children = children;
	}
}