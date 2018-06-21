package cn.tangzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 17:34
 * @desc TODO
 **/
@EnableEurekaClient
@SpringBootApplication
@RefreshScope
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
