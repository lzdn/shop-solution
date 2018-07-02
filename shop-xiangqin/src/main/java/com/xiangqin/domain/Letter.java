package com.xiangqin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.xiangqin.domain.base.BaseEntity;

/**
 * 收发信件
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_letter")
public class Letter extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "from_id", length = 11, nullable = false)
	private Integer fromId;

	@Column(name = "to_id", length = 11, nullable = false)
	private Integer toId;

	@Column(name = "content", length = 250, nullable = false)
	private String content;

	@Column(name = "read_state", length = 2, nullable = false)
	private Integer readState = 0;

	@Column(name = "create_time", nullable = false)
	private Date createTime;

	@Column(name = "update_time", nullable = false)
	private Date updateTime;
	
	@Transient
	private Account fromAccount;
	@Transient
	private Account toAccount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReadState() {
		return readState;
	}

	public void setReadState(Integer readState) {
		this.readState = readState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}


	@Override
	public String toString() {
		return "Letter [id=" + id + ", fromId=" + fromId + ", toId=" + toId + ", content=" + content + ", readState="
				+ readState + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
