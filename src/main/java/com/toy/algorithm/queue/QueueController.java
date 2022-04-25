package com.toy.algorithm.queue;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("queue")
@RequiredArgsConstructor
public class QueueController {
    private final QueueService queueService;

    @GetMapping("circular/enqueue")
    public void circularQueue_enqueue(@RequestParam int value) {
        queueService.circularQueue_enqueue(value);
    }

    @GetMapping("circular/dequeue")
    public void circularQueue_dequeue() {
        queueService.circularQueue_dequeue();
    }
}
