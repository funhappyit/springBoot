package com.example.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@ToString(exclude = {"user","item"})
@ToString(exclude= {"orderGroup","item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String status;
	
	private LocalDateTime arrivalDate;
	
	private Integer quantity;
	
	private BigDecimal totalPrice;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	@LastModifiedBy
	private String updatedBy;

	//OrderDetail N : 1 Item
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private OrderGroup orderGroup;
	
	//private Long orderGroupId;
	
//	private LocalDateTime orderAt;
	
	/*
	//N:1
		@ManyToOne
		@JoinColumn(name="user_id")
		private User user; //user_id
		
		//N : 1
		@ManyToOne
		@JoinColumn(name="item_id")
		private Item item;
	*/

}
