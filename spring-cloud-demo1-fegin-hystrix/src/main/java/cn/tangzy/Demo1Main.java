package cn.tangzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 17:34
 * @desc TODO
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class Demo1Main {
    public static void main(String[] args) {
        SpringApplication.run(Demo1Main.class, args);
    }
}
