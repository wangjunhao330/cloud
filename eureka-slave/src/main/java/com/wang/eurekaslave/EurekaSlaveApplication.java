package com.wang.eurekaslave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSlaveApplication.class, args);
    }

}
