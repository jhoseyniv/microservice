package com.example.atmmanagementservice;

import com.example.atmmanagementservice.config.RibbonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "bank-management-service", configuration = RibbonConfiguration.class)
public class ATMManagementServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ATMManagementServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
