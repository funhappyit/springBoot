package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.StudyApplicationTests;
import com.example.model.entity.OrderGroup;

public class OrderGroupRepositoryTest extends StudyApplicationTests{
	@Autowired
	private OrderGroupRepository orderGroupRepository;
	
	@Test
	public void create() {
		OrderGroup orderGroup = new OrderGroup();
		orderGroup.setStatus("COMPLETE");
		orderGroup.setOrderType("ALL");
		orderGroup.setRevAddress("서울시 강남구");
		orderGroup.setRevName("홍길동");
		orderGroup.setPaymentType("CARD");
		orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
		orderGroup.setTotalQuantity(1);
		orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
		orderGroup.setArrivalDate(LocalDateTime.now());
		orderGroup.setCreatedBy("AdminServer");
		orderGroup.setCreatedAt(LocalDateTime.now());
		
	//	orderGroup.setUserId(1L);
		
		OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
		assertNotNull(newOrderGroup);
	}
	
	
}
