package com.ms.pricelist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.pricelist.entity.Feeplan;


@Repository
public interface feeplanRepository extends JpaRepository<Feeplan,String>{

	Optional<Feeplan> findByFeeplanId(String feeplanId);

}
