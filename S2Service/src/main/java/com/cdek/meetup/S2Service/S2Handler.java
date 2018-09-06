package com.cdek.meetup.S2Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.stereotype.Service;

@Service
public class S2Handler {

    public static final Logger logger = LoggerFactory.getLogger(S2Handler.class);

    @ContinueSpan(log = "handler")
    public String handle(String req) throws InterruptedException {

        long randomMs = Math.round(Math.random() * 10000D);

        logger.info("Start process: " + req);
        Thread.sleep(randomMs);
        logger.info("Finish process: " + req);
        return "OK " + req;
    }
}
