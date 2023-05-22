package com.orinine.ktan.utils;

import com.orinine.ktan.state.StateBuilder;
import com.orinine.ktan.state.player.Player;
import com.orinine.ktan.state.player.PlayerColor;

import java.util.ArrayList;

public class StateBuilderForTests extends StateBuilder {

    protected StateBuilderForTests() {
        setTestDefaultBoard();
        setTestDefaultPlayers();
        setTestDefaultObservers();
    }

    public static StateBuilderForTests aStateBuilderForTests() {
        return new StateBuilderForTests();
    }

    private void setTestDefaultBoard() {
        board = BoardBuilderForTests.aBoardBuilderForTests().build();
    }

    private void setTestDefaultPlayers() {
        players = new Player[] { new Player(PlayerColor.BLUE), new Player(PlayerColor.RED), new Player(PlayerColor.WHITE), new Player(PlayerColor.YELLOW) };
    }

    private void setTestDefaultObservers() {
        observers = new ArrayList<>();
    }
}
