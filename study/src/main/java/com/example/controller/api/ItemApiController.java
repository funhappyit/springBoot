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
import com.example.model.entity.Item;
import com.example.model.network.Header;
import com.example.model.network.request.ItemApiRequest;
import com.example.model.network.response.ItemApiResponse;
import com.example.repository.ItemRepository;
import com.example.service.ItemApiLogicService;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item>{
	
//	@Autowired
//	private ItemApiLogicService itemApiLogicService;
//	
//	@PostConstruct
//	public void init() {
//		this.baseService = itemApiLogicService;
//	}
	
}
