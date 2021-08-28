package com.example.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String status;
	
	private String name;
	
	private String title;
	
	private String content;
	
	private Integer price;
	
	private String brandName;
	
	private LocalDateTime registeredAt;
	
	private LocalDateTime unregisteredAt;
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private LocalDateTime updatedAt;
	
	private String updatedBy;
	
	private Long partnerId;
	
	
	
	
	
	/*
		1:N
		LAZY = 지연로딩, EAGER = 즉시로딩
		LAZY => 1:N, N:1
		LAZY = SELECT * FROM item where id = ?
		EAGER => 연관되는 모든 테이블을 조인후 1:1
		item_id = order_detail.item_id
		user_id = order_detail.user_id
		where item.id = ?
		@OneToMany(fetch=FetchType.LAZY, mappedBy = "item")
		private List<OrderDetail> orderDetailList;
	*/
	
	
}
