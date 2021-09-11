package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.entity.Category;
import com.example.model.entity.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long>{
	
	List<Partner> findByCategory(Category category);
}
