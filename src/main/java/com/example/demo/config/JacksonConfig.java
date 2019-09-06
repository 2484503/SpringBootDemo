package com.example.demo.config;

import com.example.demo.utils.serializer.JacksonObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/8/21 15:56
 */
//@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper jacksonObjectMapper() {
        return JacksonObjectMapper.getInstance();
    }
}
