package org.practice.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/inventory")
@RestController
public class IntentoryController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

}
