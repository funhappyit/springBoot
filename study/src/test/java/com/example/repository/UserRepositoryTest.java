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
import com.example.model.entity.User;




public class UserRepositoryTest extends StudyApplicationTests{
	
	
	//Dependency Injection (DI)
	//
	@Autowired
	private UserRepository userRepository;
	

	public void create() {
		String account = "Test01";
		String password = "TEST01";
		String status = "REGISTERED";
		String email = "Test01@gmail.com";
		String phoneNumber = "010-1111-2222";
		
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
		user.setCreatedAt(createdAt);
		user.setCreatedBy(createdBy);
		
		User newUser = userRepository.save(user);
		
		assertNotNull(newUser);
		
	}
	
	@Test
	@Transactional
	public void read() {
		
		User user = userRepository.findFirstByphoneNumberOrderByIdDesc("010-1111-2222");
		assertNotNull(user);
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
