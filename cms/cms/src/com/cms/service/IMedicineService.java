package com.cms.service;

import java.util.List;

import com.cms.bean.Medicine;

public interface IMedicineService {
	void add(Medicine medicine);
	List<Medicine> list();
	void delete(long id);
	Medicine findById(long id);
	void update(Medicine medicine);

}
