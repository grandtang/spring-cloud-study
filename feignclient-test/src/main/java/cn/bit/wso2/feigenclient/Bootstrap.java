package cn.bit.wso2.feigenclient;

import cn.bit.bdp.wso2.conf.EnableWso2FeignClientImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@Controller
@EnableWebMvc
@EnableWso2FeignClientImport
@EnableFeignClients(basePackages = {"cn.bit.bdp.wso2.client"})
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

//    @Resource
//    private TenantClient tenantClient;

//    @Autowired
//    private TenantClientWrapper tenantClientWrapper;

//    @Resource
//    private TenantClientTest tenantClientTest;

//    @RequestMapping("/test")
//    public boolean testFeignClient() throws JsonProcessingException {
//        return true;
//    }

    @Bean
    @ConfigurationProperties("{spring.jackson}")
    public BDPObjectMapper bdpObjectMapper() {
        return new BDPObjectMapper();
    }

    @Bean
    public RequestMappingHandlerAdapter getRequestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        /*add MessageConvertor*/
        List<HttpMessageConverter<?>> messageConverters = requestMappingHandlerAdapter.getMessageConverters();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        jsonConverter.setDefaultCharset(Charset.forName("utf-8"));
        jsonConverter.setObjectMapper(bdpObjectMapper());
        messageConverters.add(jsonConverter);
        return requestMappingHandlerAdapter;
    }

}
