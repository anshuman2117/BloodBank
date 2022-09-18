package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBloodDonationDao;
import com.app.entities.BloodDonation;
@Service
public class BloodDonationServiceImpl implements IBloodDonationService {

	
	@Autowired
	private IBloodDonationDao bloodDonationDao;
	
	@Autowired
	private IBloodInventoryService bloodInventoryService;
	
	@Override
	public BloodDonation createBloodDonation(BloodDonation donation) {
		BloodDonation persisted = bloodDonationDao.saveAndFlush(donation);
		if(persisted!=null)
			bloodInventoryService.addBloodInventory(donation.getBagQuantity(),donation.getBagSize(),donation.getBloodGroup());
		return persisted;
	}

	@Override
	public List<BloodDonation> getAllDonation() {
		
		return bloodDonationDao.findAll();
	}

	@Override
	public List<BloodDonation> getAllDonationByUser(Long id) {
		
		return bloodDonationDao.getBloodDonationByUser(id);
	}

	@Override
	public String DeleteDonation(Long id) {
		
		 bloodDonationDao.deleteBloodDonationbyUser(id);
		 return "BloodDonation data  deleted successfully";
	}

	
	// fetching the blood donation details by  blood sample id
//	@Override
//	public BloodDonation fetchBySampleId(String sampleId) {
//		
//		return bloodDonationDao.findByBloodSampleId(sampleId);
//	}

}
