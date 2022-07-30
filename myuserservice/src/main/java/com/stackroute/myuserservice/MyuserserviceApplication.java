//Completed---
package com.stackroute.myuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.stackroute.myuserservice")
//@EnableSwagger2

public class MyuserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyuserserviceApplication.class, args);
	}

}
