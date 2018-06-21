package com.waimai.entity;

public class Member {
	private String memberId;
	private String memberName;//����������
	private String memberPhone;//�����˵绰
	private String memberPassword;
	private String shopName;//�̵�����
	private String shopAdress;//�̵��ַ
	private String shopImgUrl;
	private String shopMessage;//�̵깫��
	private Area area;//�̵�����
	
	public Member() {
		super();
	}
	
	
	
	
	public Member(String memberId, String memberName, String memberPhone,
			String shopName, String shopAdress, String shopImgUrl,
			String shopMessage, Area area) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.shopName = shopName;
		this.shopAdress = shopAdress;
		this.shopImgUrl = shopImgUrl;
		this.shopMessage = shopMessage;
		this.area = area;
	}




	public String getShopImgUrl() {
		return shopImgUrl;
	}


	public void setShopImgUrl(String shopImgUrl) {
		this.shopImgUrl = shopImgUrl;
	}


	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAdress() {
		return shopAdress;
	}

	public void setShopAdress(String shopAdress) {
		this.shopAdress = shopAdress;
	}

	public String getShopMessage() {
		return shopMessage;
	}

	public void setShopMessage(String shopMessage) {
		this.shopMessage = shopMessage;
	}




	public String getMemberPassword() {
		return memberPassword;
	}




	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	
}
