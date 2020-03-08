package com.my2.controllers;

import com.my2.service.ProcessResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessResolver processResolver;

    @GetMapping
    public ResponseEntity startProcess() {
        System.out.println("GET PROCESS thread: "+Thread.currentThread().getName());
        this.processResolver.runProcess();
        return ResponseEntity.ok(Map.of("Message","End process"));
    }

}
