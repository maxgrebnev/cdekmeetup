package com.cdek.s1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class S1Service {

    private static final Logger logger = LoggerFactory.getLogger(S1Service.class);

    private final RestTemplate restTemplete;

    public S1Service(RestTemplate restTemplete) {
        this.restTemplete = restTemplete;
    }

    @NewSpan
    public void process(@SpanTag("s1_request") String msg) {
        logger.info("begin handle: " + msg);
        restTemplete.getForObject("http://localhost:8081/request/{msg}", String.class, msg);
        logger.info("end handle: " + msg + " result: " + msg);
    }

}