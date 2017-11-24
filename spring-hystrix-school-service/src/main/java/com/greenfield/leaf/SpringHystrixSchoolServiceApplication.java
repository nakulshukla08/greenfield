package com.greenfield.leaf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
 

/**
@author nakuls
*/

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringHystrixSchoolServiceApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixSchoolServiceApplication.class, args);
    }
}