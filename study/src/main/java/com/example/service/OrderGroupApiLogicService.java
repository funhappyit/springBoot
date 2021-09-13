package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;

import com.example.controller.CrudController;
import com.example.controller.ifs.CrudInterface;
import com.example.model.entity.OrderGroup;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;
import com.example.repository.OrderGroupRepository;
import com.example.repository.UserRepository;

@Service
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup>{
	
	//@Autowired
	//private OrderGroupRepository orderGroupRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
		
		OrderGroupApiRequest body = request.getData();
		OrderGroup orderGroup = OrderGroup.builder()
				.status(body.getStatus())
				.orderType(body.getOrderType())
				.revAddress(body.getRevAddress())
				.revName(body.getRevName())
				.paymentType(body.getPaymentType())
				.totalPrice(body.getTotalPrice())
				.totalQuantity(body.getTotalQuantity())
				.orderAt(LocalDateTime.now())
				.user(userRepository.getOne(body.getUserId()))
				.build();
		OrderGroup newOrderGroup = baseRepostiory.save(orderGroup);
		return response(newOrderGroup);
	}

	@Override
	public Header<OrderGroupApiResponse> read(Long id) {
		
		return baseRepostiory.findById(id)
				.map(orderGroup -> response(orderGroup))
				.orElseGet(()->Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
		
		OrderGroupApiRequest body = request.getData();
		
		return baseRepostiory.findById(body.getId())
							.map(orderGroup->{
								orderGroup
									.setStatus(body.getStatus())
									.setOrderType(body.getOrderType())
									.setRevAddress(body.getRevAddress())
									.setRevName(body.getRevName())
									.setPaymentType(body.getPaymentType())
									.setTotalQuantity(body.getTotalQuantity())
									.setOrderAt(body.getOrderAt())
									.setArrivalDate(body.getArrivalDate())
									.setUser(userRepository.getOne(body.getUserId()));
								return orderGroup;
								
							})
							.map(changeOrderGroup->baseRepostiory.save(changeOrderGroup))
							.map(newOrderGroup->response(newOrderGroup))
							.orElseGet(()->Header.ERROR("데이터 없음"));

	}

	@Override
	public Header delete(Long id) {
		return baseRepostiory.findById(id)
		.map(orderGroup->{
			baseRepostiory.delete(orderGroup);
			return Header.OK();
		}).orElseGet(()->Header.ERROR("데이터 없음"));
	
	}
	
	public Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
	//	System.out.println("orderGroup"+orderGroup);
		OrderGroupApiResponse body = OrderGroupApiResponse.builder()
				.id(orderGroup.getId())
				.status(orderGroup.getStatus())
				.orderType(orderGroup.getOrderType())
				.revAddress(orderGroup.getRevAddress())
				.revName(orderGroup.getRevName())
				.paymentType(orderGroup.getPaymentType())
				.totalPrice(orderGroup.getTotalPrice())
				.totalQuantity(orderGroup.getTotalQuantity())
				.orderAt(orderGroup.getOrderAt())
				.arrivalDate(orderGroup.getArrivalDate())
				.userId(orderGroup.getUser().getId())
				.build();
		
		return Header.OK(body);
				
	}
	
}
