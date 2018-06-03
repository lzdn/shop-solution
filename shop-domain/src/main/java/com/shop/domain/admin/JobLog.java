package com.shop.domain.admin;

import java.util.Date;
import java.io.Serializable;
import com.shop.domain.BaseEntity;


/**
* @date 20180602
* @author 张林
* @description 定时任务日志
* @gitHub:https://github.com/lzdn
*/
public class JobLog extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public JobLog(){
	
	}
	/**
    *注释：主键id
    */
	private Integer id;
	/**
    *注释：任务key
    */
	private String jobName;
	/**
    *注释：任务执行描述
    */
	private String description;
	/**
    *注释：执行时间
    */
	private Date excuteTime;
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
    public String getJobName() {
        return this.jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getExcuteTime() {
        return this.excuteTime;
    }
    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
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