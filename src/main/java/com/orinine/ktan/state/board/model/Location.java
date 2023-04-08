package com.orinine.ktan.state.board.model;

import com.orinine.ktan.state.player.PlayerColor;

public record Location(PlayerColor color, Building building, Port port) {

}
