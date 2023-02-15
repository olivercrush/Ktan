package com.orinine.ktan.board.utils;

import java.util.ArrayList;
import java.util.List;

public class HexToLocationsMapper {

    public static List<Point> map(Point hex) {
        var locations = new ArrayList<Point>();

        locations.add(new Point(hex.x(), hex.x() % 2 == 0 ? hex.y() * 2 : hex.y() * 2 + 1)); // top left
        locations.add(new Point(hex.x() + 1, hex.x() % 2 == 0 ? hex.y() * 2 : hex.y() * 2 + 1)); // top right
        locations.add(new Point(hex.x(), hex.x() % 2 == 0 ? hex.y() * 2 + 1: hex.y() * 2 + 2)); // middle left
        locations.add(new Point(hex.x() + 1, hex.x() % 2 == 0 ? hex.y() * 2 + 1 : hex.y() * 2 + 2)); // middle right
        locations.add(new Point(hex.x(), hex.x() % 2 == 0 ? hex.y() * 2 + 2 : hex.y() * 2 + 3)); // bottom left
        locations.add(new Point(hex.x() + 1, hex.x() % 2 == 0 ? hex.y() * 2 + 2: hex.y() * 2 + 3)); // bottom right

        return locations;
    }

}
