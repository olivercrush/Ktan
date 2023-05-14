package com.orinine.ktan.eventprocessing;

import com.orinine.ktan.eventprocessing.event.Event;
import com.orinine.ktan.state.State;

public class EventProcessor {

    private final State state;

    public EventProcessor(State state) {
        this.state = state;
    }

    public void processEvent(Event event) {
        // 1. Store Event in History

        // 2. Call Referee to ask for approval

        // 3. Process Event
        event.process(state);

        // 4. Send response to OutputDispatcher
    }
}
