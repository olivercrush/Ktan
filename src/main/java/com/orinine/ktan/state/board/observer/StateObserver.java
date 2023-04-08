package com.orinine.ktan.state.board.observer;

import com.orinine.ktan.state.State;

public interface StateObserver {

    void notify(State stage);

}
