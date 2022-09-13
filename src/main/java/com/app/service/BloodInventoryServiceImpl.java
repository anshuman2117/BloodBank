package com.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.IBloodInventoryDao;
import com.app.entities.BloodGroup;
import com.app.entities.BloodInventory;

public class BloodInventoryServiceImpl implements IBloodInventoryService {

	@Autowired
	private IBloodInventoryDao bloodInventoryDao;
	
	@Override
	public int addBloodInventory(int quantity,int bagSize,BloodGroup bloodGroup) {
		int count = bloodInventoryDao.addBloodCount(quantity, LocalDate.now(), bagSize, bloodGroup);
		return count;
	}

	@Override
	public int subBloodInventory(int quantity,int bagSize,BloodGroup bloodGroup) {
		return bloodInventoryDao.subBloodCount(quantity, LocalDate.now(),bagSize, bloodGroup);
	}

}
