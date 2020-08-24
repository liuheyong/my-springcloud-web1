package com.lhy.cloud.web1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
//启用feign进行远程调用
@EnableFeignClients(basePackages = {"com.lhy.cloud.web1.remote"})
//添加熔断
@EnableCircuitBreaker
//启用注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class Web1Application {

	public static void main(String[] args) {
		SpringApplication.run(Web1Application.class, args);
	}

}
