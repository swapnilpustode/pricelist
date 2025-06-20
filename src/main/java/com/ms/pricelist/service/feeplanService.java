package com.ms.pricelist.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.pricelist.entity.Feeplan;
import com.ms.pricelist.repository.feeplanRepository;

@Service
public class feeplanService {
@Autowired
feeplanRepository repository;
	
	public Optional<Feeplan> getFeeplanById(String feeplanId) {
		return repository.findByFeeplanId(feeplanId);
	}

}
