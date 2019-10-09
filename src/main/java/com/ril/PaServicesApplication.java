package com.ril;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages={"com.ril"})

public class PaServicesApplication extends SpringBootServletInitializer {
	private static final Logger LOGGER = LogManager.getLogger(PaServicesApplication.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PaServicesApplication.class);
	} 
	
	public static void main(String[] args) {
		LOGGER.info("-------------------INITIALIZATION---------------");
		SpringApplication.run(PaServicesApplication.class, args);
	}

}
