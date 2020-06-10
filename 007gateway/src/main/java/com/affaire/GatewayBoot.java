package com.affaire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class,RedisAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
public class GatewayBoot {
	
	@Bean
    public Logger.Level getLogger(){
        return Logger.Level.FULL;
    }

	public static void main(String[] args) {
       SpringApplication.run(GatewayBoot.class, args);
	}

}
