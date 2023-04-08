package com.orinine.ktan.state.board.util;

import java.util.ArrayList;
import java.util.List;

public class HexToLocationsMapper {

    public static List<Point> map(Point hex) {
        var locations = new ArrayList<Point>();

        locations.add(new Point(hex.x(), hex.y() * 3)); // top
        locations.add(new Point(hex.x(), hex.y() * 3 + 1)); // top left
        locations.add(new Point(hex.x() + 1, hex.y() * 3 + 1)); // top right
        locations.add(new Point(hex.x(), hex.y() * 3 + 2)); // bottom left
        locations.add(new Point(hex.x() + 1, hex.y() * 3 + 2)); // bottom right
        locations.add(new Point(hex.x(), hex.y() * 3 + 3)); // bottom

        return locations;
    }

}
