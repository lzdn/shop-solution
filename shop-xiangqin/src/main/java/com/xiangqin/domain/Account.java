package com.xiangqin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xiangqin.domain.base.BaseEntity;

/**
 * 账户信息 主要存储用户微信信息
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_account")
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "open_id", length = 256, nullable = false)
	private String openId;

	@Column(name = "nick_name", length = 50, nullable = false)
	private String nickName;

	@Column(name = "img_url", length = 50, nullable = false)
	private String imgUrl;

	@Column(name = "charm", length = 11)
	private Integer charm;// 魅力值

	@Column(name = "received_count", length = 11)
	private Integer receivedCount;// 已收到的信件数量

	@Column(name = "send_count", length = 11)
	private Integer sendCount;// 已发送的信件数量

	@Column(name = "concern_count", length = 11)
	private Integer concernCount;// 关注的数量

	@Column(name = "login_time")
	private Date loginTime;

	@Column(name = "create_time", nullable = false)
	private Date createTime;

	@Column(name = "update_time", nullable = false)
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getCharm() {
		return charm;
	}

	public void setCharm(Integer charm) {
		this.charm = charm;
	}

	public Integer getReceivedCount() {
		return receivedCount;
	}

	public void setReceivedCount(Integer receivedCount) {
		this.receivedCount = receivedCount;
	}

	public Integer getSendCount() {
		return sendCount;
	}

	public void setSendCount(Integer sendCount) {
		this.sendCount = sendCount;
	}

	public Integer getConcernCount() {
		return concernCount;
	}

	public void setConcernCount(Integer concernCount) {
		this.concernCount = concernCount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
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

}
