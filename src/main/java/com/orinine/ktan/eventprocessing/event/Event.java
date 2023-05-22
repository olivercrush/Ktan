package com.orinine.ktan.eventprocessing.event;

import com.orinine.ktan.state.State;

public abstract class Event {

    private EventStatus status;

    public Event() {
        status = EventStatus.UNPROCESSED;
    }

    public abstract void process(State state);

    public void updateStatus(EventStatus status) {
        this.status = status;
    }

    public EventStatus getStatus() {
        return status;
    }

}
