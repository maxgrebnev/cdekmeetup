package com.cdek.meetup.S2Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S2Controller {

    private final S2Handler s2Handler;

    public S2Controller(S2Handler s2Handler) {
        this.s2Handler = s2Handler;
    }

    @GetMapping("/request/{message}")
    public ResponseEntity<String> start (@PathVariable("message") String message) throws InterruptedException {
        String res = s2Handler.handle(message);
        return ResponseEntity.ok(res);
    }
}
