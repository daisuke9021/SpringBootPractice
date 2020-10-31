package com.example.demo;

import java.sql.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BeanConfiguration {

	@Bean(name = "DBConnection")
	public Connection provideConnection() {
		return DbCommonUtils.getConnection();
	}

}
