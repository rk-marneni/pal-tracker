package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.*;

@RestController
public class WelcomeController {
    private String  helloMessage = "";

    private WelcomeController(@Value("${welcome.message}") String helloMessage) {
        this.helloMessage = helloMessage;
    }

    @GetMapping("/")
    public String sayHello() {
        return this.helloMessage;
    }
}

