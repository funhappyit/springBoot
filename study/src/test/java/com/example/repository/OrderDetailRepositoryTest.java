package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.StudyApplicationTests;
import com.example.model.entity.OrderDetail;

public class OrderDetailRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Test
	public void create() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setStatus("WAITING");
		orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
		orderDetail.setQuantity(1);
		//BigDecimal 자바 언어에서 돈과 소수점을 다룰때  사용
		orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
		//orderDetail.setOrderAt(LocalDateTime.now());
		//어떠한 장바구니에 
	//	orderDetail.setOrderGroupId(1L);
		//어떤 상품?
//		orderDetail.setItemId(1L);
		orderDetail.setCreatedAt(LocalDateTime.now());
		orderDetail.setCreatedBy("AdminServer");
		
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		
		assertNotNull(newOrderDetail);
	}

}
