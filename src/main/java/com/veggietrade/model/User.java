package com.veggietrade.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "mobile_no"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false)
    private String pwd;

    @Column(nullable = false, unique = true)
    private String mobileNo;

    private String emailId;

    private Timestamp lastModifiedDate;

    private Timestamp lastLogin;

    private int loginAttempts = 0;

    @Column(length = 1)
    private String accountStatus = "A"; // A=Active, D-Deactive, C- Closed, L-Locked

    @Column(updatable = false)
    private Timestamp accCreatedDate = new Timestamp(System.currentTimeMillis());

    public User() {
    }

    public User(String emailId, Timestamp lastLogin, Timestamp lastModifiedDate, String mobileNo, String pwd, Long userId, String userName) {
        this.emailId = emailId;
        this.lastLogin = lastLogin;
        this.lastModifiedDate = lastModifiedDate;
        this.mobileNo = mobileNo;
        this.pwd = pwd;
        this.userId = userId;
        this.userName = userName;
    }

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Timestamp getAccCreatedDate() {
        return accCreatedDate;
    }

    public void setAccCreatedDate(Timestamp accCreatedDate) {
        this.accCreatedDate = accCreatedDate;
    }

}