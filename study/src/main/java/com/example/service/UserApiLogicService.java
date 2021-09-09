package com.example.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.ifs.CrudInterface;
import com.example.model.entity.User;
import com.example.model.enumclass.UserStatus;
import com.example.model.network.Header;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.response.UserApiResponse;
import com.example.repository.UserRepository;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User>{

//	@Autowired
//	private UserRepository userRepository;
	/*
	 1.request data
	 2.user 생성 
	 3.생성된 데이터 -> UserApiResponse return 
	 */
	
	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> request) {
		//1.request data
		UserApiRequest userApiRequest = request.getData();
		
		//2.User 생성 
		User user = User.builder()
				.account(userApiRequest.getAccount())
				.password(userApiRequest.getPassword())
				.status(UserStatus.REGISTERED)
				.phoneNumber(userApiRequest.getPhoneNumber())
				.email(userApiRequest.getEmail())
				.registeredAt(LocalDateTime.now())
				.build();
		
		User newUser = baseRepostiory.save(user);
				
		//3. 생성된 데이터 -> userApiResponse return
		
		return response(newUser);
	}

	@Override
	public Header<UserApiResponse> read(Long id) {
		
		/*
		//id -> repository getOne, getById
		Optional<User> optional = userRepository.findById(id);
		
		//user -> userApiResponse return 
		return optional
				.map(user -> response(user))
				.orElseGet(()-> Header.ERROR("데이터 없음"));
		*/
		//id -> repository getOne, getById
		return baseRepostiory.findById(id)
				.map(user -> response(user))
				.orElseGet(
					()-> Header.ERROR("데이터 없음")
				);
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> request) {
		//1.data
		UserApiRequest userApiRequest = request.getData();
		
		//2.id -> user 데이터를 찾고 
		Optional<User> optional = baseRepostiory.findById(userApiRequest.getId());
		
		return optional.map(user ->{
			//3.data-> update
			//id
			user.setAccount(userApiRequest.getAccount())
				.setPassword(userApiRequest.getPassword())
				.setPhoneNumber(userApiRequest.getPhoneNumber())
				.setStatus(userApiRequest.getStatus()) // UNREGISTER
				.setEmail(userApiRequest.getEmail())
				.setRegisteredAt(userApiRequest.getRegisteredAt())
				.setUnregisteredAt(userApiRequest.getUnregisteredAt());
			return user;
			//4.userApiResponse
		})
		.map(user->baseRepostiory.save(user)) //update -> newUser
		.map(updateUser -> response(updateUser)) // userApiResponse 
		.orElseGet(()-> Header.ERROR("데이터 없음"));
	}

	@Override
	public Header delete(Long id) {
		//1.id -> repository -> user
		Optional<User> optional = baseRepostiory.findById(id);
		
		//2.repository -> delete 
		//3.response return
		return optional.map(user->{
			baseRepostiory.delete(user);
			
			return Header.OK();
		})
		.orElseGet(()->Header.ERROR("데이터 없음"));
		
		
	}
	
	//1.request data
	//2.user 생성 
	//3.생성된 데이터 -> UserApiResponse return
	
	private Header<UserApiResponse> response(User user){
		//user -> userApiResponse
		UserApiResponse userApiResponse = UserApiResponse.builder()
				.id(user.getId())
				.account(user.getAccount())
				.password(user.getPassword()) //todo 암호화, 길이 
				.email(user.getEmail())
				.phoneNumber(user.getPhoneNumber())
				.status(user.getStatus())
				.registeredAt(user.getRegisteredAt())
				.unregisteredAt(user.getUnregisteredAt())
				.build();
		//  Header + data return 
		
		return Header.OK(userApiResponse);
		
	}
	
	
	
}
