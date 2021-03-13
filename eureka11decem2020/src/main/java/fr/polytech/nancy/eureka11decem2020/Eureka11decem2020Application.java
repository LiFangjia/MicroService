package fr.polytech.nancy.eureka11decem2020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka11decem2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka11decem2020Application.class, args);
    }

}
