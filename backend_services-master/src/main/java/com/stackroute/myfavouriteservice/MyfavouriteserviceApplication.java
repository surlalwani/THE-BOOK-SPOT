//Completed---fully same
package com.stackroute.myfavouriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class MyfavouriteserviceApplication {
	@GetMapping("/message")
	public String checking() {
		return "Congratulation your Docker image is working fine!! ";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyfavouriteserviceApplication.class, args);
	}

}
