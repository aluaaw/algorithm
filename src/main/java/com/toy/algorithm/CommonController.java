package com.toy.algorithm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping
    public String start() {
        return "algorithm";
    }
}
