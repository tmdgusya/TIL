package com.example.demojsptest;

import java.time.LocalDateTime;

public class Event {

    private String name;

    private LocalDateTime starts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStarts(LocalDateTime starts) {
        this.starts = starts;
    }

    public LocalDateTime getStarts() {
        return starts;
    }
}
