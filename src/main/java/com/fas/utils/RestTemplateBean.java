package com.fas.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBean {

    public RestTemplate RestTemplate;

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
