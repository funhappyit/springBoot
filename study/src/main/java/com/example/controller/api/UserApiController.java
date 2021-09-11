package com.example.controller.api;



import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
import com.example.model.entity.User;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;
import com.example.model.network.response.UserApiResponse;
import com.example.service.UserApiLogicService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User>{
	
	@Autowired
	private UserApiLogicService userApiLogicService;
//	
//	@PostConstruct
//	public void init() {
//		this.baseService = userApiLogicService;
//	}
	
	@GetMapping("")
	public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id",direction = Sort.Direction.DESC, size = 10)Pageable pageable){
		log.info("{}",pageable);
		return userApiLogicService.search(pageable);
	}
	
	
	
}
