package com.example.controller.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.CrudController;
import com.example.controller.ifs.CrudInterface;
import com.example.model.entity.OrderGroup;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;
import com.example.service.OrderGroupApiLogicService;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends  CrudController<OrderGroupApiRequest, OrderGroupApiResponse,OrderGroup>{

//	@Autowired
//	private OrderGroupApiLogicService orderGroupApiLogicService;
//	
//	@PostConstruct
//	public void init() {
//		this.baseService = orderGroupApiLogicService;
//	}
	
	
	

}
