package com.example.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.ifs.CrudInterface;
import com.example.model.network.Header;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.response.UserApiResponse;
import com.example.service.UserApiLogicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse>{
	
	@Autowired
	private UserApiLogicService userApiLogicService;
	
	@Override
	@PostMapping("") // /api/user
	public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
		log.info("{}",request);
		return userApiLogicService.create(request);
	}
	
	@Override
	@GetMapping("{id}") // /api/user/{id}
	public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {

		return null;
	}
	@Override
	@PutMapping("") // /api/user
	public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {

		return null;
	}
	@Override
	@DeleteMapping("{id}") // /api/user/{id}
	public Header delete(@PathVariable Long id) {

		return null;
	}
	
	

}
