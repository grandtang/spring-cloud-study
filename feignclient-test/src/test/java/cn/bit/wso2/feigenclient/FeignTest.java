package cn.bit.wso2.feigenclient;

import cn.bit.bdp.common.exception.BaseException;
import cn.bit.bdp.wso2.client.exception.FeignClientException;
import cn.bit.bdp.wso2.client.resource.ResourceClientWrapper;
import cn.bit.bdp.wso2.client.tenant.TenantClientWrapper;
import cn.bit.bdp.wso2.client.user.UserClientWrapper;
import cn.bit.bdp.wso2.conf.ContextDataBinder;
import cn.bit.bdp.wso2.entity.Tenant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class FeignTest {
    @Autowired
    private TenantClientWrapper tenantClient;

    @Before
    public void init() {

    }

    @Test
    public void getTenant() {
        try {
            ContextDataBinder.setTenantDomain("carbon.super");
            ContextDataBinder.setTenantId(-1234);
            ContextDataBinder.setUserName(null);
            Tenant tenant = tenantClient.getTenant(1);
            assert tenant != null;
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ResourceClientWrapper resourceClient;

    @Test
    public void fileUpload() throws BaseException {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        Boolean aBoolean = resourceClient.addNewBinaryResource("/abc/def/dd/aaaaa", "abc".getBytes());
        assert aBoolean != null && aBoolean;

    }

    @Test
    public void download() throws BaseException {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        byte[] binaryResource = resourceClient.getBinaryResource("/abc/def/dd/aaaaa");
        assert "abc".equals(new String(binaryResource));
    }

    @Test
    public void delete() throws BaseException {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        resourceClient.deleteResource("/abc/def/dd/aaaaa");
    }

    @Autowired
    private UserClientWrapper userClientWrapper;

    @Test
    public void getUserDisplayName() throws BaseException {
        ContextDataBinder.setTenantDomain("QQQ");
        ContextDataBinder.setTenantId(19);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        System.out.println(userClientWrapper
                .getClaimValue(19,
                        "tangzhiyuan@bitnei.cn",
                        "http://wso2.org/claims/title"));
    }

    @Test
    public void getResourcesWithTags() throws BaseException {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        String[] datasources = resourceClient.getResourcePathWithTag("datasource");
        assert datasources != null;
    }

    @Test
    public void add() throws BaseException, IOException {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        String s = this.readFileAsString();
        Boolean datasources = resourceClient.addNewResource("abc", "{\"abc\":\"def\"}");

    }

    private String readFileAsString() throws IOException {
        Reader reader = new FileReader(new File("/home/tangzy/worksparce/github/spring-cloud-study/feignclient-test/src/test/java/cn/bit/wso2/feigenclient/FeignTest.java"));
        char[] c = new char[1024];
        int len = -1;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = reader.read(c)) != -1) {
            stringBuilder.append(new String(c, 0, len));
        }
        reader.close();
        return stringBuilder.toString();

    }

    @Test
    public void isUserExists() {
        ContextDataBinder.setTenantDomain("test-1");
        ContextDataBinder.setTenantId(1);
        ContextDataBinder.setUserName("tangzhiyuan@bitnei.cn");
        Boolean existingUser = false;
        try {
            existingUser = userClientWrapper.isExistingUser(1, "tangzhiyuan@bitnei.cn");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert existingUser;
    }
}
