package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //getter, setter
@AllArgsConstructor //생성자
public class SearchParam {
	private String account;
	private String email;
	private int page;	
}
