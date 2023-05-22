package com.orinine.ktan.eventprocessing;

import com.orinine.ktan.eventprocessing.event.Event;
import com.orinine.ktan.state.State;

public class EventProcessor {

    private final EventHistory history;
    private final State state;

    public EventProcessor(EventHistory history, State state) {
        this.history = history;
        this.state = state;
    }

    public void processEvent(Event event) {
        // 1. Call Referee to ask for approval

        // 2. Store Event in History
        history.storeEvent(event);

        // 3. Process Event
        event.process(state);

        // 4. Send response to OutputDispatcher
    }
}
