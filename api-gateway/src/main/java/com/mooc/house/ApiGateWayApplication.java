package com.mooc.house;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "user-service",configuration = NewRuleConfig.class)
@Controller
@EnableCircuitBreaker
public class ApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateWayApplication.class, args);
	}

	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/index")
	@ResponseBody
	public List<ServiceInstance> index(){
		List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
		return instances;
	}
}
