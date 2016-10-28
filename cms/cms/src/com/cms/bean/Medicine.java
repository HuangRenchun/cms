package com.cms.bean;

import java.util.Date;

public class Medicine {
	//入库id
	private Long id;
	//入库员
	private String operator;
	//入库时间
	private Date StorageTime;
	//药品名称
	private String name;
	//生产厂家
	private String manufacturer;
	//有效期限
	private String effectiveDate;
	//销售单价
	private Float salePrice;
	//进货单价
	private Float purchasePrice;
	//入库数量
	private String number;
	//药品编号
	private Integer code;
	//药的功能
	private String indication;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getStorageTime() {
		return StorageTime;
	}
	public void setStorageTime(Date storageTime) {
		StorageTime = storageTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}
	public Float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getIndication() {
		return indication;
	}
	public void setIndication(String indication) {
		this.indication = indication;
	}
	public Medicine(String operator, Date storageTime, String name,
			String manufacturer, String effectiveDate, Float salePrice,
			Float purchasePrice, String number, Integer code, String indication) {
		super();
		this.operator = operator;
		StorageTime = storageTime;
		this.name = name;
		this.manufacturer = manufacturer;
		this.effectiveDate = effectiveDate;
		this.salePrice = salePrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.code = code;
		this.indication = indication;
	}
	public Medicine() {
		super();
	}
	
	
	
	
	

}
