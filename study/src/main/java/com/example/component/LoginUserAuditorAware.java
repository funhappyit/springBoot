package com.example.component;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

//로그인 유저 감시 
@Component
public class LoginUserAuditorAware implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("AdminServer");
	}

}
