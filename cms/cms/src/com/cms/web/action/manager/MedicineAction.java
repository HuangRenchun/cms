package com.cms.web.action.manager;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.cms.bean.Category;
import com.cms.bean.Medicine;
import com.cms.service.IMedicineService;
import com.cms.service.impl.MedicineServiceIml;
import com.opensymphony.xwork2.ActionSupport;

public class MedicineAction extends ActionSupport {
	private Long id;
	private String operator;
    private Date StorageTime;
	private String name;
	private String manufacturer;
	private String effectiveDate;
	private Float salePrice;
	private Float purchasePrice;
	private String number;
	private Integer code;
	private String indication;
	private List<Medicine>medicineList;
	private IMedicineService medicineService=new MedicineServiceIml();
	private Medicine medicine;
	
	private static final long serialVersionUID = 1L;
	@Action(value="toAddMedicine",results={
    @Result(name="success",location="/WEB-INF/jsp/manager/addMedicine.jsp")})
	public String toAddMedicine(){
    	return "success";
    }
	
	@Action("addMedicine")
	public void addMedicine(){
		Medicine medicine=new Medicine();
		
		medicine.setCode(code);
		medicine.setOperator(operator);
		medicine.setName(name);
		medicine.setManufacturer(manufacturer);
		medicine.setEffectiveDate(effectiveDate);
		medicine.setSalePrice(salePrice);
		medicine.setPurchasePrice(purchasePrice);
		medicine.setNumber(number);
		medicine.setIndication(indication);	
		medicine.setStorageTime(new Date());
		
		medicineService.add(medicine);
		
		
		
	}
	@Action(value="toMedicineManager",results={@Result(name="success",location="/WEB-INF/jsp/manager/medicineManager.jsp")})
    public String toCategoryManager(){
		//调用service层的方法
		medicineList=medicineService.list();
    	return "success";
    	
    }
	@Action(value="delMedicine")
    public void delCategory(){
		//System.out.println("id="+id);
		medicineService.delete(id);
    	
    }
	/*
	 * 更新数据
	 * 
	 *
	 *
	 * */
	 @Action(value="toUpdMedicine",results=
			{@Result(name="success",location="/WEB-INF/jsp/manager/updMedicine.jsp")})
	    public String toUpdCategory(){
			//调用service层的方法
			medicine=medicineService.findById(id);
	    	return "success";
		}
	 @Action(value="updMedicine")
	    public void  updMedicine(){
				Medicine medicine=new Medicine();
				medicine.setId(id);
				medicine.setCode(code);
				medicine.setOperator(operator);
				medicine.setName(name);
				medicine.setManufacturer(manufacturer);
				medicine.setEffectiveDate(effectiveDate);
				medicine.setSalePrice(salePrice);
				medicine.setPurchasePrice(purchasePrice);
				medicine.setNumber(number);
				medicine.setIndication(indication);	
				medicine.setStorageTime(new Date());
				medicineService.update(medicine);
				System.out.println(id+"--"+indication);
		    	
		    }
	
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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

	public List<Medicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<Medicine> medicineList) {
		this.medicineList = medicineList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Date getStorageTime() {
		return StorageTime;
	}

	public void setStorageTime(Date storageTime) {
		StorageTime = storageTime;
	}
	
	

}
