package com.app.service;


import java.util.List;

import com.app.entities.BloodGroup;
import com.app.entities.BloodInventory;

public interface IBloodInventoryService {

	//method to increase blood bag quantity
	int addBloodInventory(int quantity,int bagSize,BloodGroup bloodGroup);
	
	// method to subtract blood bag quantity
	
	int subBloodInventory(int quantity,int bagSize,BloodGroup bloodGroup);
	
	List<BloodInventory> listBloodInventory();  
	
}
