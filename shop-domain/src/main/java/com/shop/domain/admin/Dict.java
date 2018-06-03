package com.shop.domain.admin;

import java.util.Date;
import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 系统字典
* @gitHub:https://github.com/lzdn
*/
public class Dict extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Dict(){
	
	}
	/**
    *注释：主键id
    */
	private Integer id;
	/**
    *注释：代码
    */
	private String dictCode;
	/**
    *注释：名称
    */
	private String dictName;
	/**
    *注释：值
    */
	private String dictValue;
	/**
    *注释：描述
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

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDictCode() {
        return this.dictCode;
    }
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
    public String getDictName() {
        return this.dictName;
    }
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
    public String getDictValue() {
        return this.dictValue;
    }
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
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