package com.app.service;

import java.util.List;

import com.app.entities.Address;

public interface IAddressService {
	
	public List<Address> getAllAddresses();
	
	public Address getAddress(Long id);
	
	public Address addAddress(Address address);
	
	public Address updateAddress(Address address);
	
	public void deleteAddress(Long id);
}
