package com.example.demojsptest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {



    @GetMapping("/events")
    public String getEvents(Model model) {
        Event event = new Event();
        event.setName("스프링 스터디 1");
        event.setStarts(LocalDateTime.of(2019,1,15,10,0));

        Event event1 = new Event();
        event1.setName("스프링 스터디 2");
        event1.setStarts(LocalDateTime.of(2019,2,15,10,0));

        List<Event> events = List.of(event, event1);

        model.addAttribute("events", events);
        model.addAttribute("message", "hohoho");

        return "events/list";
    }
}
