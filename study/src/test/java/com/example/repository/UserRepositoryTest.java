package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.example.StudyApplicationTests;
import com.example.model.entity.OrderDetail;
import com.example.model.entity.OrderGroup;
import com.example.model.entity.User;




public class UserRepositoryTest extends StudyApplicationTests{
	
	
	//Dependency Injection (DI)
	//
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void create() {
		String account = "Test03";
		String password = "TEST03";
		String status = "REGISTERED";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-3333";
		
		LocalDateTime registeredAt = LocalDateTime.now();
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
	
		
		
		User user =  new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setStatus(status);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		user.setRegisteredAt(registeredAt);
	//	user.setCreatedAt(createdAt);
	//	user.setCreatedBy(createdBy);
		
		//객체를 만들때는 builder 패턴 사용
		User u = User.builder()
				.account(account)
				.password(password)
				.status(status)
				.email(email)
				.build();
		
		User newUser = userRepository.save(user);
		
		assertNotNull(newUser);
		
	}
	
	@Test
	@Transactional
	public void read() {
		
		User user = userRepository.findFirstByphoneNumberOrderByIdDesc("010-1111-0001");
		
		/*
		객체를 update 할때에는 chain 패턴 사용 
		user
		.setEmail("")
		.setPhoneNumber("")
		.setStatus("");
		
		User u = new User().setAccount("").setEmail("").setPassword("");
		*/
		
		if(user != null) {
			user.getOrderGroupList().stream().forEach(OrderGroup->{
				System.out.println("-------------주문묶음-------------");
				System.out.println("수령인: "+OrderGroup.getRevName());
				System.out.println("수령지: "+OrderGroup.getRevAddress());
				System.out.println("총금액: "+OrderGroup.getTotalPrice());
				System.out.println("총수량: "+OrderGroup.getTotalQuantity());
				System.out.println("-------------주문상세-------------");
				OrderGroup.getOrderDetailList().forEach(orderDetail -> {
					System.out.println("파트너사 이름 : "+orderDetail.getItem().getPartner().getName());
					System.out.println("파트너사 카테고리 : "+orderDetail.getItem().getPartner().getCategory().getTitle());
					System.out.println("주문 상품: "+orderDetail.getItem().getName());
					System.out.println("고객센터 번호: "+orderDetail.getItem().getPartner().getCallCenter());
					System.out.println("주문의 상태 : "+orderDetail.getStatus());
					System.out.println("도착예정일자 : "+orderDetail.getArrivalDate());
					
				});
				
			});
		}
		
		
		
		//assertNotNull(user);
		//select * from user where id = ?
		//카멜 키로 구분 
		/*
		Optional<User> user = userRepository.findByAccount("TestUser03");
		
		user.ifPresent(selectUser ->{
			selectUser.getOrderDetailList().stream().forEach(detail ->{;
				System.out.println("test-->"+detail.getItem());
			});
		});
		*/
		
		
	}
	@Test
	public void update() {
		Optional<User> user = userRepository.findById(2L);
	
		user.ifPresent(selectUser -> {
			selectUser.setAccount("PPPP");
			selectUser.setUpdatedAt(LocalDateTime.now());
			selectUser.setUpdatedBy("update method()");
			
			userRepository.save(selectUser);
			
		});
		
		
	}
	
	@Test
	@Transactional
	public void delete() {
		Optional<User> user = userRepository.findById(3L);
		
		assertTrue(user.isPresent());
		user.ifPresent(selectUser->{
			userRepository.delete(selectUser);
		});
		
		Optional<User> deleteUser = userRepository.findById(2L);
		if(deleteUser.isPresent()) {
			System.out.println("데이터 존재: "+deleteUser.get());
		}else {
			System.out.println("데이터 삭제 데이터 없음");
		}
		
		assertFalse(deleteUser.isPresent());
		
	}
	
}
