package com.my2.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
class ProcessControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void startProcess() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future<ResponseEntity<Map>>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            futures.add(
                    threadPool.submit(() -> testRestTemplate.getForEntity("/process", Map.class))
            );
        }

        futures.forEach(x-> {
            try {
                x.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
