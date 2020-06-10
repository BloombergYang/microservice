package com.affaire;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.affaire.mapper")
//@EnableDiscoveryClient
public class SpringbootDubboStarter {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboStarter.class, args);
	}

}
