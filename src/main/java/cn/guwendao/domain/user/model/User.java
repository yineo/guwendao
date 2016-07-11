package cn.guwendao.domain.user.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.guwendao.domain.basic.model.BasicModel;

//Neo
@Entity
@Table(name = "user")
@DynamicUpdate(true)
public class User extends BasicModel implements Serializable, UserDetails {
	
	private String name;         //姓名
	private String phoneNumber;  //电话
	private String wxOpenId;     //微信集成id
	private String password;     //密码
	
	//顾问信息
	private Boolean consultantFlag;  //是否已注册成为顾问
	private String nickName;     //昵称
	private String city;         //所在城市
	private String selfDesc;     //自我描述
	private String workPlace;   //任职机构
	private String position;    //职务
	private String workExperience;  //工作年限
	private Integer dayValue;       //人天估价
	
	/*private String goodAt;  //擅长领域 ,分隔
	private String served;  //服务过的企业 ,分隔 
	private String tag;     //标签 ,分隔*/
	
	//安全相关字段
    private boolean enabled; // 账户启用
    private boolean accountExpired; // 账户过期
    private boolean accountLocked; // 账户锁定
    private boolean credentialsExpired; // 密码过期
    
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=20)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=40)
	public String getWxOpenId() {
		return wxOpenId;
	}
	public void setWxOpenId(String wxOpenId) {
		this.wxOpenId = wxOpenId;
	}
	
	@Column(columnDefinition="int(1) default 0")
	public Boolean getConsultantFlag() {
		return consultantFlag;
	}
	public void setConsultantFlag(Boolean consultantFlag) {
		this.consultantFlag = consultantFlag;
	}
	
	@Column(length=50)
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Column(length=10)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length=50)
	public String getSelfDesc() {
		return selfDesc;
	}
	public void setSelfDesc(String selfDesc) {
		this.selfDesc = selfDesc;
	}
	
	@Column(length=30)
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	
	@Column(length=30)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Column(length=20)
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	
	@Column(length=8)
	public Integer getDayValue() {
		return dayValue;
	}
	public void setDayValue(Integer dayValue) {
		this.dayValue = dayValue;
	}
	
	@JsonIgnore
    @Column(nullable = false, columnDefinition="int(1) default 0")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@JsonIgnore
    @Column(nullable = false, columnDefinition="int(1) default 0")
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	
	@JsonIgnore
    @Column(nullable = false, columnDefinition="int(1) default 0")
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	
	@JsonIgnore
    @Column(nullable = false, columnDefinition="int(1) default 0")
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}
	
	@Transient
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return !isCredentialsExpired();
    }

    @Transient
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Transient
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }
    
    @Transient
    @JsonIgnore
    public String getUsername() {
        return getId();
    }
    
    @Transient
    @JsonIgnore
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}
	
}
