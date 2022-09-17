package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excpetions.ResourceNotFoundException;
import com.app.dao.IUserDao;
import com.app.dto.UserDTO;
import com.app.entities.Gender;
import com.app.entities.IdentityProof;
import com.app.entities.Status;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IEmailSendingService emailSendingService;
	
	@Autowired
	private IIdentityProofService proofService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	
	// by this method we can retrieve the data of user as well as identity proof data aslo, by join querry
	@Override
	public User getUser(Long id) {
		User user= userDao.findById(id).orElseThrow(()-> new RuntimeException("no user found"));
//	System.out.println("----------data---------");
//	System.out.println(" "+user.toString());
		return user;
	}

//	@Override
//	public UserDTO getUser(Long id) {
//		return userDao.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid User id " + id));
//	}
	
	@Override
	public UserDTO addUser(UserDTO userdto) {
		User user=modelMapper.map(userdto, User.class);  // Mapping userdto to user
		User user1 = userDao.save(user);
		IdentityProof identityProof=modelMapper.map(userdto, IdentityProof.class);
		identityProof.setUser(user1);
		IdentityProof proof = proofService.saveIdentityProof(identityProof);
		UserDTO userDtoReturn= modelMapper.map(user1, UserDTO.class);              //mapping return user data to user dto
		userDtoReturn.setUniqueIdNumber(proof.getUniqueIdNumber());                // setting id number with userdto
		userDtoReturn.setDocumentType(proof.getDocumentType());  
		
		if(user1!=null && proof!=null) {
			String messageBody="Thankyou <h3> "+user1.getFirstName()+" </h3> for registering with us"
					+ "from the given link you can directly visit to us:<a href='www.bloodForLives.com'>OBBMS</a>";
			String header="Welcome "+user1.getFirstName()+"!!!";
			emailSendingService.sendEmail(user1.getEmail(), messageBody, header);
		}
		
		return userDtoReturn;
	}
	
	
	@Override
	public User addUserByAdmin(UserDTO userdto) {
		User user=modelMapper.map(userdto, User.class);  // Mapping userdto to user
		user.setPassword(user.getFirstName()+""+user.getAge());
		User user1 = userDao.save(user);
		IdentityProof identityProof=modelMapper.map(userdto, IdentityProof.class);
		identityProof.setUser(user1);
		identityProof.setStatus(Status.APPROVED);
		IdentityProof proof = proofService.saveIdentityProof(identityProof);
		
		
		if(user1!=null && proof!=null) {
			String messageBody="Hey <h3> "+user1.getFirstName()+" </h3> you are registered with us successfully"
					+" your pre defind password is <b>your first name+your age</b>i.e.<i><b>( "
					+user1.getPassword()+"</b></i><p></p>"
					+" visit us with your credentials "
					+"<p>email:<p style='color:red;'>"+user1.getEmail()+"</p>"
					+"<p>pass :<p style='color:blue;'>"+user1.getPassword()+"</p>"
					+ "from the given link you can directly visit to us:<a href='www.bloodForLives.com'>OBBMS</a>";
			String header="Welcome "+user1.getFirstName()+"!!!";
			emailSendingService.sendEmail(user1.getEmail(), messageBody, header);
		}
		return user1;
	}
	
	
	@Override
	public User updateUser(Long id,User user) {
System.out.println("user--->   "+user);
		User findByEmail = userDao.findById(id).orElseThrow(()->new RuntimeException("user does not exist!!"));
		
			if(user.getFirstName()!=null)
			findByEmail.setFirstName(user.getFirstName());
			if(user.getLastName()!=null)
				findByEmail.setLastName(user.getLastName());
			if(user.getAge()!=null)
				findByEmail.setAge(user.getAge());
			if(user.getContactNo()!=null)
				findByEmail.setContactNo(user.getContactNo());
			if(user.getGender()!=null)
				findByEmail.setGender(user.getGender());
			if(user.getImage()!=null)
				findByEmail.setImage(user.getImage());
			
				userDao.saveAndFlush(findByEmail);
				
			return findByEmail;
	}
	
	
	@Override
	public String deleteUser(Long id) {
		String message= "Deletion of User failed";
		if (userDao.existsById(id)) {
			userDao.deleteById(id);
			message= "User removed successfully with UserId : "+id;
		}
		return message;	
	}

	// method to return the user data by providing email and password
	@Override
	public User getByEmailAndPassword(String email, String password) {
		
		return userDao.findByEmailAndPassword(email, password);
		 
	}


	


	

}
