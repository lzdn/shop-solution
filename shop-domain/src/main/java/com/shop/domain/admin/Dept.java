package com.shop.domain.admin;

import java.util.Date;
import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 部门
* @gitHub:https://github.com/lzdn
*/
public class Dept extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Dept(){
	
	}
	/**
    *注释：主键dept_id
    */
	private Integer deptId;
	/**
    *注释：父部门parent_dept_id
    */
	private Integer parentDeptId;
	/**
    *注释：简称
    */
	private String deptSimpleName;
	/**
    *注释：全称
    */
	private String deptFullName;
	/**
    *注释：描述
    */
	private String description;
	/**
    *注释：创建时间
    */
	private Date createTime;
	/**
    *注释：修改时间
    */
	private Date updateTime;

    public Integer getDeptId() {
        return this.deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public Integer getParentDeptId() {
        return this.parentDeptId;
    }
    public void setParentDeptId(Integer parentDeptId) {
        this.parentDeptId = parentDeptId;
    }
    public String getDeptSimpleName() {
        return this.deptSimpleName;
    }
    public void setDeptSimpleName(String deptSimpleName) {
        this.deptSimpleName = deptSimpleName;
    }
    public String getDeptFullName() {
        return this.deptFullName;
    }
    public void setDeptFullName(String deptFullName) {
        this.deptFullName = deptFullName;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
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