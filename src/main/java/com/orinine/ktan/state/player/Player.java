package com.orinine.ktan.state.player;

public class Player {

    private final PlayerColor color;
    private int score;

    public Player(PlayerColor color) {
        this.color = color;
        this.score = 0;
    }

    public PlayerColor getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        this.score += amount;
    }
}
