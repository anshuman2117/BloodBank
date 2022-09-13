package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.dao.IIdentityProofDao;
import com.app.entities.IdentityProof;

public class IdentityProofServiceImpl implements IIdentityProofService {

	@Autowired
	private IIdentityProofDao identityProofDao;
	
	@Override
	public IdentityProof saveIdentityProof(IdentityProof identityProof) {
		
		return identityProofDao.save(identityProof);
	}

	@Override
	public IdentityProof getIdentityProofByUserId(Long id) {
		
		return identityProofDao.findByUser(id);
	}

}
