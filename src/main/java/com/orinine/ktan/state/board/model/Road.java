package com.orinine.ktan.state.board.model;

import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;

import java.util.List;

public record Road(PlayerColor playerColor, List<Point> points) {

}
