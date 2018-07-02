package com.xiangqin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiangqin.domain.base.BaseEntity;

/**
 * 关注
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_concern")
public class Concern extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "owner_id", length = 11, nullable = false)
	private Integer ownerId;
	
	@Column(name = "follow_id", length = 11, nullable = false)
	private Integer followId;
	
	@Column(name = "state", length = 2, nullable = false)
	private Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
