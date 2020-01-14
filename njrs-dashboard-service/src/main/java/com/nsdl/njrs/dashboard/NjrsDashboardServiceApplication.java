package com.nsdl.njrs.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NjrsDashboardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjrsDashboardServiceApplication.class, args);

	}

}
