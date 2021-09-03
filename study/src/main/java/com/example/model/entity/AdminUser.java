package com.example.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class AdminUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String account;
	
	private String password;
	
	private String status;
	
	private String role;
	
	private LocalDateTime lastLoginAt;
	
	private int loginFailCount;
	
	private LocalDateTime passwordUpdatedAt;
	
	private LocalDateTime registeredAt;
	
	private LocalDateTime unregisteredAt;
	/*
	 LastModifiedDate, LastModifiedBy의 어노테이션으로 설정된 
	 updatedAt, updatedBy로 선언된것들은 
	 adminServer의 반영을 맡는다
	 */
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;
	
}
