package com.orinine.ktan.eventprocessing;

import com.orinine.ktan.eventprocessing.event.Event;

import java.util.ArrayList;
import java.util.List;

public class EventHistory {

    private List<Event> events;

    public EventHistory() {
        events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void storeEvent(Event event) {
        events.add(event);
    }

}
