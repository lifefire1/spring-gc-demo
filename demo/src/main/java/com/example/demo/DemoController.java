package com.example.gcprofile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/fast")
    public String fast() {
        return "Fast response";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(2000);
        return "Slow response";
    }

    @GetMapping("/alloc")
    public String alloc() {
        byte[][] blocks = new byte[1000][];
        for (int i = 0; i < 1000; i++) {
            blocks[i] = new byte[1024 * 1024]; // 1MB
        }
        return "Allocated 1000MB";
    }
}