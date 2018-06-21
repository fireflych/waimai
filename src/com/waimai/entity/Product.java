package com.waimai.entity;

public class Product {
	private String productId;//��Ʒid
	private String productName;//��Ʒ����
	private String productSubtitle;//��Ʒ�ĸ�����
	private float productOriginalPrize;//��Ʒԭ��
	private float productCurrentPrize;//��Ʒ�ּ�
	private int productSellNum;//������
	private float productCore;//����
	private String productImgUrl;//��Ʒ��ͼƬ
	private Category category;//�������
	private Member member;//�̼����
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productId, String productName,
			String productSubtitle, float productOriginalPrize,
			float productCurrentPrize, int productSellNum,
			float productCore, String productImgUrl, Category category,
			Member member) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSubtitle = productSubtitle;
		this.productOriginalPrize = productOriginalPrize;
		this.productCurrentPrize = productCurrentPrize;
		this.productSellNum = productSellNum;
		this.productCore = productCore;
		this.productImgUrl = productImgUrl;
		this.category = category;
		this.member = member;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSubtitle() {
		return productSubtitle;
	}
	public void setProductSubtitle(String productSubtitle) {
		this.productSubtitle = productSubtitle;
	}
	public float getProductOriginalPrize() {
		return productOriginalPrize;
	}
	public void setProductOriginalPrize(float productOriginalPrize) {
		this.productOriginalPrize = productOriginalPrize;
	}
	public float getProductCurrentPrize() {
		return productCurrentPrize;
	}
	public void setProductCurrentPrize(float productCurrentPrize) {
		this.productCurrentPrize = productCurrentPrize;
	}
	public String getProductImgUrl() {
		return productImgUrl;
	}
	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	public int getProductSellNum() {
		return productSellNum;
	}

	public void setProductSellNum(int productSellNum) {
		this.productSellNum = productSellNum;
	}

	public float getProductCore() {
		return productCore;
	}

	public void setProductCore(float productCore) {
		this.productCore = productCore;
	}
	
	
}
