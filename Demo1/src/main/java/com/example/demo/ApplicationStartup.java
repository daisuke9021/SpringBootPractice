package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
//@Scope("application")
public class ApplicationStartup {

	//このBeanが生成された時（アプリケーション起動時）に実行される
	@PostConstruct
	public void startup() {
		System.out.println("**アプリケーションが起動しました");
	}
	//このBeanが終了する時（アプリケーション終了時）に実行される
	@PreDestroy
	public void exit() {
		System.out.println("**アプリケーションを終了します");
	}

}
