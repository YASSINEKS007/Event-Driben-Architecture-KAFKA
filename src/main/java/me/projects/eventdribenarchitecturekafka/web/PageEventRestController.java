package me.projects.eventdribenarchitecturekafka.web;

import lombok.AllArgsConstructor;
import me.projects.eventdribenarchitecturekafka.entities.PageEvent;
import org.hibernate.validator.internal.constraintvalidators.hv.time.DurationMaxValidator;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@AllArgsConstructor
public class PageEventRestController {
    private StreamBridge streamBridge;

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String name, @PathVariable String topic) {
        PageEvent pageEvent = PageEvent.builder()
                .date(new Date())
                .user(Math.random() > 0.5 ? "User 1" : "User 2")
                .name(name)
                .duration(new Random().nextLong(9000))
                .build();
        streamBridge.send(topic, pageEvent);

        return pageEvent;
    }
}
