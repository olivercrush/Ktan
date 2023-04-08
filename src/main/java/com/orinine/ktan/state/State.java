package com.orinine.ktan.state;

import com.orinine.ktan.state.board.model.Board;
import com.orinine.ktan.state.board.observer.StateObserver;
import com.orinine.ktan.state.player.Player;

import java.util.List;

public class State {

    private Board board;
    private Player[] players;
    private final List<StateObserver> observers;

    public State(List<StateObserver> observers) {
        this.observers = observers;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void updateBoard(Board board) {
        this.board = board;
        observers.forEach(stateObserver -> stateObserver.notify(this));
    }
}
