package com.spring.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
public class EventController {

    @GetMapping("/")
    public String eventHome () {
        return "event.tiles";
    }

    @GetMapping("/detail")
    public String eventDatail() {
        return "detail.tiles";
    }

}
