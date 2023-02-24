package com.orinine.ktan.board.models;

import com.orinine.ktan.player.PlayerColor;

public record Location(PlayerColor color, Building building, Port port) {

}
