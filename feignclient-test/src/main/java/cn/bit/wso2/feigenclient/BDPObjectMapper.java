package cn.bit.wso2.feigenclient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Created by tangzy on 2017-7-11 0011.
 * json解析配置
 */

public class BDPObjectMapper extends ObjectMapper {
    public BDPObjectMapper() {
        super();

//        this.enable(SerializationFeature.WRAP_ROOT_VALUE);
        this.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);

        this.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
//        this.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        this.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        this.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        this.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
}
