package com.orinine.ktan.state;

import com.orinine.ktan.state.board.model.Board;
import com.orinine.ktan.state.board.observer.StateObserver;
import com.orinine.ktan.state.player.Player;

import java.util.List;

public class StateBuilder {

    protected Board board;
    protected Player[] players;
    protected List<StateObserver> observers;

    protected StateBuilder() {

    }

    public static StateBuilder aStateBuilder() {
        return new StateBuilder();
    }

    public StateBuilder setBoard(Board board) {
        this.board = board;
        return this;
    }

    public StateBuilder setPlayers(Player[] players) {
        this.players = players;
        return this;
    }

    public StateBuilder setObservers(List<StateObserver> observers) {
        this.observers = observers;
        return this;
    }

    public State build() {
        return new State(board, players, observers);
    }
}
