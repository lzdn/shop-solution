package com.shop.domain.admin;

import java.util.Date;
import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 系统模块
* @gitHub:https://github.com/lzdn
*/
public class Module extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Module(){
	
	}
	/**
    *注释：主键group_id
    */
	private Integer moduleId;
	/**
    *注释：图标
    */
	private String icon;
	/**
    *注释：组名称
    */
	private String moduleName;
	/**
    *注释：描述
    */
	private String description;
	/**
    *注释：排序
    */
	private Integer orderBy;
	/**
    *注释：是否有效 1 有效 0 无效
    */
	private Integer status;
	/**
    *注释：创建时间
    */
	private Date createTime;
	/**
    *注释：修改时间
    */
	private Date updateTime;

    public Integer getModuleId() {
        return this.moduleId;
    }
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getModuleName() {
        return this.moduleName;
    }
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getOrderBy() {
        return this.orderBy;
    }
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
    public Integer getStatus() {
        return this.status;
    }
    public void setStatus(Integer status) {
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
}