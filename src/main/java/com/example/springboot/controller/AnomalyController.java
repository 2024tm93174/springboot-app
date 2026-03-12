package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnomalyController {

    @GetMapping("/cpu-spike")
    public String cpuSpike() {
        new Thread(() -> {
            long endTime = System.currentTimeMillis() + 10000; // spike for 10 sec
            while (System.currentTimeMillis() < endTime) {
                Math.sqrt(Math.random() * Math.random()); // busy work
            }
        }).start();
        return "CPU spike started for 10 seconds!";
    }

    @GetMapping("/memory-spike")
    public String memorySpike() {
        new Thread(() -> {
            List<byte[]> memoryHog = new ArrayList<>();
            try {
                for (int i = 0; i < 1000; i++) { // tweak size for your heap
                    memoryHog.add(new byte[1024 * 1024]); // 1MB each
                    Thread.sleep(10); // gradual allocation
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return "Memory spike started!";
    }

    @GetMapping("/request-flood")
    public String requestFlood(@RequestParam(defaultValue = "1000") int requests) {
        new Thread(() -> {
            for (int i = 0; i < requests; i++) {
                // simulate normal processing
                try {
                    Thread.sleep(5); // minimal processing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return "Request flood started: " + requests + " iterations";
    }
}
