package com.orinine.ktan.event.types;

import com.orinine.ktan.state.State;

public abstract class Event {

    public abstract void process(State state);

}