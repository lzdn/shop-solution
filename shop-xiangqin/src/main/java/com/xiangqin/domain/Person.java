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
 * 用户个人信息
 * 
 * @author zhanglin
 *
 */
@Entity
@Table(name = "t_person")
public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11, nullable = false)
	private Integer id;

	@Column(name = "account_id", length = 11, nullable = false)
	private Integer accountId;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "birthday", nullable = false)
	private Date birthday;

	@Column(name = "age", length = 11, nullable = false)
	private Integer age;

	@Column(name = "height", length = 11, nullable = false)
	private Integer height;

	@Column(name = "sex", nullable = false)
	private Integer sex;

	@Column(name = "province_id", nullable = false)
	private Integer provinceId;

	@Column(name = "province_name", nullable = false)
	private String provinceName;

	@Column(name = "city_id", nullable = false)
	private Integer cityId;

	@Column(name = "city_name", nullable = false)
	private String cityName;

	@Column(name = "county_id", nullable = false)
	private Integer countyId;

	@Column(name = "county_name", nullable = false)
	private String countyName;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "weixin")
	private String weixin;

	@Column(name = "signature", length = 250, nullable = false)
	private String signature;

	@Column(name = "introduction", length = 500, nullable = false)
	private String introduction;

	@Column(name = "contact_way", nullable = false)
	private Integer contactWay;

	@Column(name = "birthday_way", nullable = false)
	private Integer birthdayWay;

	@Column(name = "one_show_way", nullable = false)
	private Integer oneShowWay;

	@Column(name = "create_time", nullable = false)
	private Date createTime;

	@Column(name = "update_time", nullable = false)
	private Date updateTime;

	@Transient
	private String coverUrl;
	
	@Transient
	private String address;
	
	@Transient
	private String sexName;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getContactWay() {
		return contactWay;
	}

	public void setContactWay(Integer contactWay) {
		this.contactWay = contactWay;
	}

	public Integer getBirthdayWay() {
		return birthdayWay;
	}

	public void setBirthdayWay(Integer birthdayWay) {
		this.birthdayWay = birthdayWay;
	}

	public Integer getOneShowWay() {
		return oneShowWay;
	}

	public void setOneShowWay(Integer oneShowWay) {
		this.oneShowWay = oneShowWay;
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", accountId=" + accountId + ", name=" + name + ", birthday=" + birthday + ", sex="
				+ sex + ", provinceId=" + provinceId + ", provinceName=" + provinceName + ", cityId=" + cityId
				+ ", cityName=" + cityName + ", countyId=" + countyId + ", countyName=" + countyName + ", phone="
				+ phone + ", weixin=" + weixin + ", signature=" + signature + ", introduction=" + introduction
				+ ", contactWay=" + contactWay + ", birthdayWay=" + birthdayWay + ", oneShowWay=" + oneShowWay
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
