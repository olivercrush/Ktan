package com.orinine.ktan.state.board.util;

import java.util.ArrayList;
import java.util.List;

public class HexToLocationsMapper {

    public static List<Point> map(Point hex) {
        var locations = new ArrayList<Point>();
        var isEven = hex.y() % 2 == 0;

        locations.add(new Point(isEven ? hex.x() : hex.x() + 1, 2 * hex.y())); // top
        locations.add(new Point(hex.x(), 2 * hex.y() + 1)); // top left
        locations.add(new Point(hex.x() + 1, 2 * hex.y() + 1)); // top right
        locations.add(new Point(hex.x(), 2 * hex.y() + 2)); // bottom left
        locations.add(new Point(hex.x() + 1, 2 * hex.y() + 2)); // bottom right
        locations.add(new Point(isEven ? hex.x() : hex.x() + 1, 2 * hex.y() + 3)); // bottom

        return locations;
    }

}
