package com.MallAdmin;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="mall_admin")
public class MallAdmin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Column(name = "id") 
    private Integer mallAdminId;
    private String username;
    private String password;
    private String email;
    private Integer loginAttempts;
    private Boolean isActive;
    
    @Column(name = "last_login_time", nullable = true)
    private LocalDateTime lastLoginTime = LocalDateTime.now();
    
    
    
    
	public Integer getMallAdminId() {
		return mallAdminId;
	}
	public void setMallAdminId(Integer mallAdminId) {
		this.mallAdminId = mallAdminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getLoginAttempts() {
		return loginAttempts;
	}
	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public LocalDateTime getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(LocalDateTime lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public MallAdmin(Integer mallAdminId, String username, String password, String email, Integer loginAttempts,
			Boolean isActive, LocalDateTime lastLoginTime) {
		super();
		this.mallAdminId = mallAdminId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.loginAttempts = loginAttempts;
		this.isActive = isActive;
		this.lastLoginTime = lastLoginTime;
	}
	public MallAdmin() {
		super();
	}
	@Override
	public String toString() {
		return "MallAdmin [mallAdminId=" + mallAdminId + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", loginAttempts=" + loginAttempts + ", isActive=" + isActive
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}
   
    
   
}

