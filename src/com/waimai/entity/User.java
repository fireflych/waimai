package com.waimai.entity;

public class User {
	private String userId;		 //�û���ʶid
	private String userLoginName;//�û���½��
	private String userNickName; //�û��ǳ�
	private String userTrueName; //�û���ʵ����
	private String userPassword; //�û���½����
	private String userPhone;    //�û��ֻ�
	private String userAddress;  //�û���ַ
	private String userCreateTime;//�û�ע��ʱ��
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String userNickName, String userPassword,
			String userPhone, String userCreateTime) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userCreateTime = userCreateTime;
		this.userLoginName = "test";
		this.userTrueName = "ZJH";
		this.userAddress = "ZHKU";
	}

	public User(String userId, String userLoginName, String userNickName,
			String userTrueName, String userPassword, String userPhone,
			String userAddress, String userCreateTime) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userNickName = userNickName;
		this.userTrueName = userTrueName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userCreateTime = userCreateTime;
	}
	
	public User(String userId, String userLoginName, String userNickName,
			String userTrueName, String userPassword, String userPhone,
			String userCreateTime) {
		super();
		this.userId = userId;
		this.userLoginName = userLoginName;
		this.userNickName = userNickName;
		this.userTrueName = userTrueName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userCreateTime = userCreateTime;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	
	
}