package com.orinine.ktan.board.models;

import com.orinine.ktan.board.utils.Point;
import com.orinine.ktan.player.PlayerColor;

import java.util.List;

public record Road(PlayerColor playerColor, List<Point> points) {

}
