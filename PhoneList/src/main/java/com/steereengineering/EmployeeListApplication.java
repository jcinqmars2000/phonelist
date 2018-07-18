package com.steereengineering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeListApplication extends SpringBootServletInitializer {
   
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmployeeListApplication.class);
    }
 

	public static void main(String[] args) {
		SpringApplication.run(EmployeeListApplication.class, args);
	}
}
