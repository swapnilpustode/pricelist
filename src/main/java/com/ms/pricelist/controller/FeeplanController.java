package com.ms.pricelist.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.pricelist.entity.Feeplan;
import com.ms.pricelist.service.feeplanService;

@RestController
@RequestMapping("v1/pricelist")
public class FeeplanController {
	@Autowired
	feeplanService service;

	@GetMapping("/{feeplanId}")
	public ResponseEntity<Feeplan> getFeeplanById(@PathVariable("feeplanId") String feeplanId) {
	System.out.println("fetching record for feeplan=============>>>>>>>>>>>"+feeplanId);
		//	return service.getFeeplanById();
		Optional<Feeplan> feeplan = service.getFeeplanById(feeplanId);
		System.out.println("feeplan details:::"+feeplan.isPresent());
		return feeplan.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping("/")
	public ResponseEntity<Feeplan> addorUpdateFeeplan(@PathVariable("feeplanId") String feeplanId) {
		System.out.println("fetching record for feeplan=============>>>>>>>>>>>"+feeplanId);
		//	return service.getFeeplanById();
		Optional<Feeplan> feeplan = service.getFeeplanById(feeplanId);
		System.out.println("feeplan details:::"+feeplan);
		return feeplan.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
