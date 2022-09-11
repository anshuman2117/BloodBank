package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Address;
import com.app.service.IAddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	public AddressController() {
		System.out.println("in ctor of " + getClass());
	}
	
	@GetMapping
	public List<Address> getAllAddresses(){
		return addressService.getAllAddresses();
	}
}
