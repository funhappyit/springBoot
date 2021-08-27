package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.StudyApplicationTests;
import com.example.model.entity.OrderDetail;

public class OrderDetailRepositoryTest extends StudyApplicationTests{
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public void create() {
		OrderDetail orderDetail = new OrderDetail();
		
		orderDetail.setOrderAt(LocalDateTime.now());
		
		//어떤사람?
	//	orderDetail.setUser(7L);
		
		
		//어떤 상품?
		//orderDetail.setItemId(1L);
		
		OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
		
		assertNotNull(newOrderDetail);
	}

}
