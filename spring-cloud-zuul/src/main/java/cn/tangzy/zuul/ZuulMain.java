package cn.tangzy.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 10:58
 * @desc TODO
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulMain {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class, args);
    }
}
