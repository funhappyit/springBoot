package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.ifs.CrudInterface;
import com.example.model.entity.Item;
import com.example.model.network.Header;
import com.example.model.network.request.ItemApiRequest;
import com.example.model.network.response.ItemApiResponse;
import com.example.repository.ItemRepository;
import com.example.repository.PartnerRepository;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item>{

	@Autowired
	private PartnerRepository partnerRepository;
	

	@Override
	public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
		ItemApiRequest body = request.getData();
		
		Item item = Item.builder()
				.status(body.getStatus())
				.name(body.getName())
				.title(body.getTitle())
				.content(body.getContent())
				.price(body.getPrice())
				.brandName(body.getBrandName())
				.registeredAt(LocalDateTime.now())
				.partner(partnerRepository.getOne(body.getPartnerId()))
				.build();
		
		Item newItem = baseRepostiory.save(item);
		
		return response(newItem);
	}

	@Override
	public Header<ItemApiResponse> read(Long id) {
		return baseRepostiory.findById(id)
							.map(item -> response(item))
							.orElseGet(()->Header.ERROR("데이터 없음"));
	}

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		
		ItemApiRequest body = request.getData();
		
		return baseRepostiory.findById(body.getId())
					.map(entityItem ->{
						entityItem.setStatus(body.getStatus())
								.setName(body.getName())
								.setTitle(body.getTitle())
								.setContent(body.getContent())
								.setPrice(body.getPrice())
								.setBrandName(body.getBrandName())
								.setRegisteredAt(body.getRegisteredAt())
								.setUnregisteredAt(body.getUnregisteredAt());
						
						return entityItem;
					})
					.map(newEntityItem -> baseRepostiory.save(newEntityItem))
					.map(item -> response(item))
					.orElseGet(()->Header.ERROR("데이터 없음"));
	}

	@Override
	public Header delete(Long id) {
		
		return baseRepostiory.findById(id)
				.map(item -> {
					baseRepostiory.delete(item);
					return Header.OK();
				})
				.orElseGet(()->Header.ERROR("데이터 없음 "));
	}
	
	
	public Header<ItemApiResponse> response(Item item){
		/*
		 title로 가져오는것
		 String statusTitle = item.getStatus().getTitle(); 
		 */
		
		ItemApiResponse body = ItemApiResponse.builder()
				.id(item.getId())
				.status(item.getStatus())
				.name(item.getName())
				.title(item.getTitle())
				.content(item.getContent())
				.price(item.getPrice())
				.brandName(item.getBrandName())
				.registeredAt(item.getRegisteredAt())
				.unregisteredAt(item.getUnregisteredAt())
				.partnerId(item.getPartner().getId())
				.build();
				
		return Header.OK(body);
		
		
	}
	
	
	
	
}
