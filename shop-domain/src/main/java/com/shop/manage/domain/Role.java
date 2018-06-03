package com.shop.manage.domain;

import com.shop.domain.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;


/**
* @date 20180602
* @author 张林
* @description 角色
* @gitHub:https://github.com/lzdn
*/
public class Role extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Role(){
	
	}
	/**
    *注释：主键role_id
    */
	private Integer roleId;
	/**
    *注释：
    */
	private String roleKey;
	/**
    *注释：角色名称
    */
	private String roleName;
	/**
    *注释：角色描述
    */
	private String description;
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

    public Integer getRoleId() {
        return this.roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleKey() {
        return this.roleKey;
    }
    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }
    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
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