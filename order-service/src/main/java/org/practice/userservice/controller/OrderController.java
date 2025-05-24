package org.practice.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {

    @GetMapping("/health")
    public String health() {
        return "OL";
    }

    @RequestMapping("/create")
    public void createOrder() {

    }

}
