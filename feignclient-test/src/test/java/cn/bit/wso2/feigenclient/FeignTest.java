package cn.bit.wso2.feigenclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class FeignTest {
    @Autowired
    private Bootstrap bootstrap;

    @Test
    public void test1() throws JsonProcessingException {
        assert bootstrap.testFeignClient();
    }
}
