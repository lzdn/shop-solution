package com.shop.domain.admin;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.shop.domain.BaseEntity;

/**
 * @date 20180602
 * @author 张林
 * @description 用户
 * @gitHub:https://github.com/lzdn
 */
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public User() {

	}

	/**
	 * 注释：主键user_id
	 */
	private Integer userId;
	/**
	 * 注释：部门id
	 */
	private Integer deptId;
	/**
	 * 注释：头像
	 */
	private String avatar;
	/**
	 * 注释：账号
	 */
	private String account;
	/**
	 * 注释：密码
	 */
	private String password;
	/**
	 * 注释：md5密码盐
	 */
	private String salt;
	/**
	 * 注释：名字
	 */
	private String username;
	/**
	 * 注释：生日
	 */
	private Date birthday;
	/**
	 * 注释：性别（1：男 2：女）
	 */
	private Integer sex;
	/**
	 * 注释：电子邮件
	 */
	private String email;
	/**
	 * 注释：电话
	 */
	private String phone;
	/**
	 * 注释：状态(1：启用 2：冻结 3：删除）
	 */
	private Integer status;
	/**
	 * 注释：创建时间
	 */
	private Date createTime;
	/**
	 * 注释：修改时间
	 */
	private Date updateTime;
	/**
	 * 注释：登录时间
	 */
	private Date loginTime;
	/**
	 * 注释：上次登录时间
	 */
	private Date lastLoginTime;

	private Role role;

	private List<Module> modules;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}