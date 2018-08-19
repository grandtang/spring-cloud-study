package cn.bit.wso2.feigenclient;

import cn.bit.bdp.wso2.client.tenant.TenantClient;
import cn.bit.bdp.wso2.dto.TenantDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({"cn.bit.bdp.wso2.client"})
@Controller
@EnableWebMvc
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @Resource
    private TenantClient tenantClient;

    @RequestMapping("/test")
    public boolean testFeignClient() throws JsonProcessingException {
        TenantDTO tenant = tenantClient.getTenant(1);
        System.out.printf(new ObjectMapper().writeValueAsString(tenant));
        return true;
    }
}
