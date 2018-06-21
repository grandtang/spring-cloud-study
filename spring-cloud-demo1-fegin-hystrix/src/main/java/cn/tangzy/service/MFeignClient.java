package cn.tangzy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 17:40
 * @desc TODO
 **/
@FeignClient(
        name = "spring-cloud-demo2-fegin-hystrix",
        fallback = FeignClientHystrixCallBack.class,
        configuration = MFeignClient.class
)
public interface MFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/demo/props")
    Map<String, String> getProps();
}
