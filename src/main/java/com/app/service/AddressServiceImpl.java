package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAddressDao;
import com.app.entities.Address;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private IAddressDao addressDao;

	@Override
	public List<Address> getAllAddresses() {
		
		return addressDao.findAll();
	}

	@Override
	public Address getAddress(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address addAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(Long id) {
		// TODO Auto-generated method stub

	}

}
