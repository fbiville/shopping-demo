package io.projectriffdemo.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
public class AdEventController {

    private final Consumer<AdEvent> eventConsumer;

    @Autowired
    public AdEventController(Consumer<AdEvent> eventConsumer) {
        this.eventConsumer = eventConsumer;
    }

    @PostMapping
    public void persist(@RequestBody AdEvent event) {
        eventConsumer.accept(event);
    }
}
