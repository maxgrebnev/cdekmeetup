package com.cdek.s1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController
public class S1Controller {

    private static final Logger logger = LoggerFactory.getLogger(S1Controller.class);

    private S1Service s2Service;

    public S1Controller(S1Service s2Service) {
        this.s2Service = s2Service;
    }

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @GetMapping(value = "/request/{messages}")
    public ResponseEntity<String> request(@PathVariable("messages") List<String> request)  throws Exception {
        logger.info("Request: " + request);
        for (String s : request) {
            executorService.submit(() -> s2Service.process(s));
        }

        return ResponseEntity.ok("ok");
    }

}
