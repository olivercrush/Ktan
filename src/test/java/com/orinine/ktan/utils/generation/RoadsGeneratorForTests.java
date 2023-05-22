package com.orinine.ktan.utils.generation;

import com.orinine.ktan.state.board.model.Road;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class RoadsGeneratorForTests {

    public static List<Road> generateRoadsForTests() {
        var roads = new ArrayList<Road>();
        roads.add(new Road(PlayerColor.BLUE, List.of(new Point(2, 3), new Point(2, 4))));
        roads.add(new Road(PlayerColor.BLUE, List.of(new Point(2, 4), new Point(3, 5))));
        roads.add(new Road(PlayerColor.RED, List.of(new Point(4, 3), new Point(4, 4))));
        roads.add(new Road(PlayerColor.WHITE, List.of(new Point(0, 4), new Point(1, 5))));
        roads.add(new Road(PlayerColor.WHITE, List.of(new Point(1, 5), new Point(1, 6))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 7), new Point(2, 8))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(2, 8), new Point(3, 9))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 9), new Point(3, 10))));
        roads.add(new Road(PlayerColor.YELLOW, List.of(new Point(3, 10), new Point(3, 11))));

        return roads;
    }

}
