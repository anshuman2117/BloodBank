package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.UserDTO;
import com.app.entities.User;


public interface ImageHandlingService {
	
	
User storeImage(Long id, MultipartFile imageFile);

 byte[] restoreImage(Long id);
}
