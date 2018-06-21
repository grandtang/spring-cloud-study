package cn.tangzy.controller;

import cn.tangzy.service.MFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangzy@csdn.net
 * @date 2018/06/21 17:36
 * @desc TODO
 **/
@RequestMapping("/demo")
@Controller
public class DemoController {

    @Autowired
    private MFeignClient mFeignClient;

    @ResponseBody
    @RequestMapping(value = "/props", method = RequestMethod.GET)
    public Map<String, String> getProps() {
        return new HashMap<String, String>() {{
            put("lang", "java");
        }};
    }

    @ResponseBody
    @RequestMapping(value = "/props/feign", method = RequestMethod.GET)
    public Map<String, String> getPropsByFeign() {
        return mFeignClient.getProps();
    }


}
