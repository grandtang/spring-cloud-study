package cn.tangzy.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 17:34
 * @desc TODO
 **/
@EnableEurekaClient
@SpringBootApplication
@EnableWebMvc
public class Demo2Main {
    public static void main(String[] args) {
        SpringApplication.run(Demo2Main.class, args);
    }
}
