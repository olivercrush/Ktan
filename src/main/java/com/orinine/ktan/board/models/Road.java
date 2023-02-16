package com.orinine.ktan.board.models;

import com.orinine.ktan.player.Player;

public class Road {

    private final Player player;
    private final Location[] locations;

    public Road(Player player, Location[] locations) {
        this.player = player;
        this.locations = locations;
    }

    public Player getPlayer() {
        return player;
    }

    public Location[] getPoints() {
        return locations;
    }
}
