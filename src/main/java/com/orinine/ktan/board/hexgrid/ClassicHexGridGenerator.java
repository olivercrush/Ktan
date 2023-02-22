package com.orinine.ktan.board.hexgrid;

import com.orinine.ktan.board.models.Hex;
import com.orinine.ktan.board.utils.Point;

import java.util.ArrayList;
import java.util.List;

public class ClassicHexGridGenerator implements HexGridGenerator {

    private final List<Point> board = new ArrayList<>() {{
        add(new Point(1, 1));
        add(new Point(2, 1));
        add(new Point(3, 1));

        add(new Point(1, 2));
        add(new Point(2, 2));
        add(new Point(3, 2));
        add(new Point(4, 2));

        add(new Point(0, 3));
        add(new Point(1, 3));
        add(new Point(2, 3));
        add(new Point(3, 3));
        add(new Point(4, 3));

        add(new Point(1, 4));
        add(new Point(2, 4));
        add(new Point(3, 4));
        add(new Point(4, 4));

        add(new Point(1, 5));
        add(new Point(2, 5));
        add(new Point(3, 5));
    }};

    private final List<Integer> dices = new ArrayList<>() {{
        add(2);
        add(3);
        add(3);
        add(4);
        add(4);
        add(5);
        add(5);
        add(6);
        add(6);
        add(8);
        add(8);
        add(9);
        add(9);
        add(10);
        add(10);
        add(11);
        add(11);
        add(12);
    }};

    private final List<Hex.HexType> hexTypes = new ArrayList<>() {{
        add(Hex.HexType.DESERT);
        add(Hex.HexType.HILLS);
        add(Hex.HexType.HILLS);
        add(Hex.HexType.HILLS);
        add(Hex.HexType.MOUNTAINS);
        add(Hex.HexType.MOUNTAINS);
        add(Hex.HexType.MOUNTAINS);
        add(Hex.HexType.FIELDS);
        add(Hex.HexType.FIELDS);
        add(Hex.HexType.FIELDS);
        add(Hex.HexType.FIELDS);
        add(Hex.HexType.PASTURE);
        add(Hex.HexType.PASTURE);
        add(Hex.HexType.PASTURE);
        add(Hex.HexType.PASTURE);
        add(Hex.HexType.FOREST);
        add(Hex.HexType.FOREST);
        add(Hex.HexType.FOREST);
        add(Hex.HexType.FOREST);
    }};

    private static ClassicHexGridGenerator instance;

    private ClassicHexGridGenerator() {
        // no instance for you
    }

    public static ClassicHexGridGenerator getInstance() {
        if (instance == null)
            instance = new ClassicHexGridGenerator();

        return instance;
    }

    @Override
    public Hex[][] generate() {
        Hex[][] hexGrid = new Hex[][] {
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.DESERT, 0), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.DESERT, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
                { new Hex(Hex.HexType.EMPTY, 0), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6), new Hex(Hex.HexType.EMPTY, 6) },
        };

        return hexGrid;
    }
}
