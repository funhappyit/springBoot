package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
	
	@Test
	public void create() {
		User user = new User();
		user.setAccount("TestUser03");
		user.setPassword("1234");
		user.setEmail("TestUser01@gmail.com");
		user.setPhoneNumber("010-1111-1111");
		user.setCreatedAt(LocalDateTime.now());
		user.setCreatedBy("admin");
		
		User newUser = userRepository.save(user);
		System.out.println("newUser:"+newUser);
	}
	@Test
	public void read() {
		Optional<User> user = userRepository.findById(2L);
		user.ifPresent(selectUser->{
			System.out.println("user: "+selectUser);
			System.out.println("email: "+selectUser.getEmail());
		});
		
		
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
