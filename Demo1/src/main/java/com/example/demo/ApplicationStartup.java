package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup {

	//このBeanが生成された時（アプリケーション起動時）に実行される
	@PostConstruct
	public void startup() {
		System.out.println("**アプリケーションが起動しました**");
		System.out.println("**DBコネクションの確立を行います**");
		boolean result = DbCommonUtils.createConnection();
		if(result) {
			System.out.println("**DBコネクションの確立に成功しました**");
		} else {
			System.out.println("**DBコネクションの確立に失敗しました**");
		}
	}
	//このBeanが終了する時（アプリケーション終了時）に実行される
	@PreDestroy
	public void exit() {
		System.out.println("**DBコネクションの切断を行います**");
		boolean result = DbCommonUtils.closeConnection();
		if(result) {
			System.out.println("**DBコネクションの切断に成功しました**");
		} else {
			System.out.println("**DBコネクションの切断に失敗しました**");
		}
		System.out.println("**アプリケーションを終了します**");
	}

}
