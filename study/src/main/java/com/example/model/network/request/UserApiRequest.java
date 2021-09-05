package com.example.model.network.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {
	
	private Long id;
	
	private String account;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String status;
	
	private LocalDateTime registeredAt;
	
	private LocalDateTime unregisteredAt;
}
