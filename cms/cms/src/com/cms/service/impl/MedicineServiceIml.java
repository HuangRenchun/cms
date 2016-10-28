package com.cms.service.impl;

import java.util.List;

import com.cms.bean.Medicine;
import com.cms.dao.MedicineDao;
import com.cms.service.IMedicineService;

public class MedicineServiceIml implements IMedicineService {
    private MedicineDao medicineDao=new MedicineDao();
	@Override
	public void add(Medicine medicine) {
		medicineDao.save(medicine);
		

	}

	@Override
	public List<Medicine> list() {
		
		return medicineDao.findAll();
	}


	public void delete(long id) {
		medicineDao.deleteById(id);

	}


	public Medicine findById(long id) {

		return medicineDao.findById(id);
	}

	@Override
	public void update(Medicine medicine) {
		medicineDao.update(medicine);
		// TODO Auto-generated method stub
		
	}

}
