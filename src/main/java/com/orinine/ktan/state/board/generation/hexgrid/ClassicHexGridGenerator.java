package com.orinine.ktan.state.board.generation.hexgrid;

import com.orinine.ktan.state.board.model.Hex;
import com.orinine.ktan.state.board.util.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicHexGridGenerator implements HexGridGenerator {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    private static final List<Point> BOARD = new ArrayList<>() {{
        add(new Point(1, 0));
        add(new Point(2, 0));
        add(new Point(3, 0));

        add(new Point(0, 1));
        add(new Point(1, 1));
        add(new Point(2, 1));
        add(new Point(3, 1));

        add(new Point(0, 2));
        add(new Point(1, 2));
        add(new Point(2, 2));
        add(new Point(3, 2));
        add(new Point(4, 2));

        add(new Point(0, 3));
        add(new Point(1, 3));
        add(new Point(2, 3));
        add(new Point(3, 3));

        add(new Point(1, 4));
        add(new Point(2, 4));
        add(new Point(3, 4));
    }};

    private static final List<Integer> DICE_TARGETS = new ArrayList<>() {{
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

    private static final List<Hex.HexType> HEX_TYPES = new ArrayList<>() {{
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
        var hexTypes = new ArrayList<>(HEX_TYPES);
        var diceTargets = new ArrayList<>(DICE_TARGETS);

        Hex[][] hexGrid = new Hex[HEIGHT][WIDTH];

        for (var i = 0; i < HEIGHT; i++)
            for (var j = 0; j < WIDTH; j++)
                if (BOARD.contains(new Point(j, i)))
                    hexGrid[i][j] = getRandomTileAndDiceTarget(hexTypes, diceTargets);
                else
                    hexGrid[i][j] = new Hex(Hex.HexType.EMPTY, 0);

        return hexGrid;
    }

    private Hex getRandomTileAndDiceTarget(List<Hex.HexType> hexTypes, List<Integer> diceTargets) {
        Hex.HexType hexType;
        if (hexTypes.size() > 1)
            hexType = hexTypes.get((new Random()).nextInt(hexTypes.size() - 1));
        else
            hexType = hexTypes.get(0);
        hexTypes.remove(hexType);

        var diceTarget = 0;
        if (Hex.HexType.DESERT != hexType) {
            int diceId;
            if (diceTargets.size() > 1)
                diceId = (new Random()).nextInt(diceTargets.size() - 1);
            else
                diceId = 0;
            diceTarget = diceTargets.get(diceId);
            diceTargets.remove(diceId);
        }

        return new Hex(hexType, diceTarget);
    }
}
