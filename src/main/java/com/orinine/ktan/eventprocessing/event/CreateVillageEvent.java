package com.orinine.ktan.eventprocessing.event;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Location;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;

public class CreateVillageEvent extends Event {

    private final Point coordinates;
    private final PlayerColor color;

    public CreateVillageEvent(Point coordinates, PlayerColor color) {
        this.coordinates = coordinates;
        this.color = color;
    }

    // TODO : find a unified way to update board without directly moddifying the grid values

    @Override
    public void process(State state) {
        var currentLocation = state.getBoard().getLocationGrid()[coordinates.y()][coordinates.x()];
        var updatedLocation = new Location(color, Building.VILLAGE, currentLocation.port());

        var updatedGrid = state.getBoard().getLocationGrid();
    }
}
