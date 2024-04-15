package com.fas.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Configuration
public class RestTemplateBean {

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }

}
