package com.empmanagement.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.empmanagement")
@EnableJpaRepositories
public class EmpManagementApplication {

	public static void main(final String[] args) {

		SpringApplication.run(EmpManagementApplication.class, args);
	}

}
