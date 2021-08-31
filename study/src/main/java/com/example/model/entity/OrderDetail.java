package com.example.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@ToString(exclude = {"user","item"})
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String status;
	
	private LocalDateTime arrivalDate;
	
	private Integer quantity;
	
	private BigDecimal totalPrice;
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
	private Long orderGroupId;
	
	private Long itemId;
	
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
