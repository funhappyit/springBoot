package com.example.service;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.controller.ifs.CrudInterface;
import com.example.model.network.Header;

@Component //주입
public abstract class BaseService<Req, Res, Entity> implements CrudInterface<Req, Res>{
	
	@Autowired(required = false)
	protected JpaRepository<Entity, Long> baseRepostiory;
	
		//JpaRepository<Item,Long>
	
	
	

}
