package com.orinine.ktan.board.models;

import com.orinine.ktan.player.PlayerColor;

public class Road {

    private final PlayerColor playerColor;
    private final Location[] locations;

    public Road(PlayerColor playerColor, Location[] locations) {
        this.playerColor = playerColor;
        this.locations = locations;
    }

    public PlayerColor getPlayer() {
        return playerColor;
    }

    public Location[] getPoints() {
        return locations;
    }
}
