package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.IdentityProof;

public interface IIdentityProofDao extends JpaRepository<IdentityProof, Long> {

	IdentityProof findByUser(Long id);
	
}
