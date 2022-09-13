package com.app.service;

import com.app.entities.IdentityProof;

public interface IIdentityProofService {

//	save a user's id card details
	IdentityProof saveIdentityProof(IdentityProof identityProof);
	
//	get users identity card details by id 
	IdentityProof getIdentityProofByUserId(Long id);
}
