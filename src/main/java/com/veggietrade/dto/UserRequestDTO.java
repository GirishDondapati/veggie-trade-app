package com.veggietrade.dto;


public class UserRequestDTO {
    private String userName;
    private String pwd;
    private String mobileNo;
    private String emailId;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String emailId, String mobileNo, String pwd, String userName) {
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.pwd = pwd;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPwd() {
        return pwd;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
}