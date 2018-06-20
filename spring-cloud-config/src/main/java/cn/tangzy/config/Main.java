package cn.tangzy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Main {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(Main.class, args);
    }
}
