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
import com.example.model.network.request.ItemApiRequest;
import com.example.model.network.response.ItemApiResponse;
import com.example.repository.ItemRepository;
import com.example.service.ItemApiLogicService;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse>{
	
	@Autowired
	private ItemApiLogicService itemApiLogicService;
	
	@Override
	@PostMapping("") // /api/item
	public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
		return itemApiLogicService.create(request);
	}

	@Override
	@GetMapping("{id}") // /api/item/1 ... 1000
	public Header<ItemApiResponse> read(@PathVariable Long id) {
		
		return itemApiLogicService.read(id);
	}

	@Override
	@PutMapping("") // /api/item
	public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
		
		return null;
	}

	@Override
	@DeleteMapping("{id}") // /api/item/1 ... 1000
	public Header delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
