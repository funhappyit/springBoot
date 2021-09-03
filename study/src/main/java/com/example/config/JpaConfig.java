package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//설정 파일 
@Configuration
//감시를 활성화 시키겠다
@EnableJpaAuditing
public class JpaConfig {
	
}

