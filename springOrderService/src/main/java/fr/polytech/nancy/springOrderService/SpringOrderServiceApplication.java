package fr.polytech.nancy.springOrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringOrderServiceApplication.class, args);
    }

}
