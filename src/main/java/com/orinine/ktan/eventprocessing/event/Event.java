package com.orinine.ktan.eventprocessing.event;

import com.orinine.ktan.state.State;

public abstract class Event {

    public abstract void process(State state);

}
