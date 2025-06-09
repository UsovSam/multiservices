package org.practice.userservice.controller;

import org.practice.userservice.service.QueueService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final QueueService queueService;

    public OrderController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping("/health")
    public String health() {
        return "OL";
    }

    @RequestMapping("/create")
    public void createOrder() {
    }

    @PostMapping("/sendMsg")
    public void sendMsg(@RequestBody String msg) {
        queueService.sendMessage(msg);
    }

}
