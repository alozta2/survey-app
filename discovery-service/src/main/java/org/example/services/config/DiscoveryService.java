package org.example.services.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryService {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryService.class).run(args);
    }
}
