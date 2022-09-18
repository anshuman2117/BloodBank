package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAddressDao;
import com.app.dto.AddressDTO;
import com.app.dto.AppointmentDTO;
import com.app.entities.Address;
import com.app.entities.Status;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressDao addressDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<AddressDTO> getAllAddresses() {

		return addressDao.findAll().stream().map(i -> mapper.map(i, AddressDTO.class)).collect(Collectors.toList());

//		appointmentDao.findByStatus(Status.PENDING).stream()
//		.map(i->mapper.map(i,AppointmentDTO.class)).collect(Collectors.toList());

	}

	@Override
	public List<AddressDTO> getAllAddressofUser(Long id/* ,Address address */) {

		return addressDao.findUserAddress(id).stream()
				.map(i -> mapper.map(i, AddressDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public /* List< */Address defaultUsersAddress(Long id/* ,Address address */) {

		
		return addressDao.findByUserAndIsDefault(id, true);
		
//		return addressDao.findByUserAndIsDefault(id, true).stream()
//				.map(i -> mapper.map(i, AddressDTO.class))
//				.collect(Collectors.toList());
	}

	@Override
	public Address addAddress(AddressDTO address) {

		Address address2=mapper.map(address, Address.class);

		return addressDao.saveAndFlush(address2);
	}

	@Override
	public Address updateAddress(Address address) {
      
		return addressDao.saveAndFlush(address);
	}

	@Override
	public String deleteAddress(Long id) {
		//here we are taking input of user id
		if(addressDao.deleteAddress(id)>= 1);
		
		return "address deleted successfully";
		

	}

}
