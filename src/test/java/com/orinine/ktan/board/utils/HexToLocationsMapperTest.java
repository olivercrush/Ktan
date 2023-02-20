package com.orinine.ktan.board.utils;

import org.junit.jupiter.api.Test;

public class HexToLocationsMapperTest {

    @Test
    public void testZeroZeroHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(0, 0));

        assert(locations.get(0).equals(new Point(0, 0)));
        assert(locations.get(1).equals(new Point(0, 1)));
        assert(locations.get(2).equals(new Point(1, 1)));
        assert(locations.get(3).equals(new Point(0, 2)));
        assert(locations.get(4).equals(new Point(1, 2)));
        assert(locations.get(5).equals(new Point(0, 3)));
    }

    @Test
    public void testOneZeroHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(1, 0));

        assert(locations.get(0).equals(new Point(1, 0)));
        assert(locations.get(1).equals(new Point(1, 1)));
        assert(locations.get(2).equals(new Point(2, 1)));
        assert(locations.get(3).equals(new Point(1, 2)));
        assert(locations.get(4).equals(new Point(2, 2)));
        assert(locations.get(5).equals(new Point(1, 3)));
    }

    @Test
    public void testTwoZeroHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(2, 0));

        assert(locations.get(0).equals(new Point(2, 0)));
        assert(locations.get(1).equals(new Point(2, 1)));
        assert(locations.get(2).equals(new Point(3, 1)));
        assert(locations.get(3).equals(new Point(2, 2)));
        assert(locations.get(4).equals(new Point(3, 2)));
        assert(locations.get(5).equals(new Point(2, 3)));
    }

    @Test
    public void testZeroOneHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(0, 1));

        assert(locations.get(0).equals(new Point(0, 3)));
        assert(locations.get(1).equals(new Point(0, 4)));
        assert(locations.get(2).equals(new Point(1, 4)));
        assert(locations.get(3).equals(new Point(0, 5)));
        assert(locations.get(4).equals(new Point(1, 5)));
        assert(locations.get(5).equals(new Point(0, 6)));
    }

    @Test
    public void testOneOneHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(1, 1));

        assert(locations.get(0).equals(new Point(1, 3)));
        assert(locations.get(1).equals(new Point(1, 4)));
        assert(locations.get(2).equals(new Point(2, 4)));
        assert(locations.get(3).equals(new Point(1, 5)));
        assert(locations.get(4).equals(new Point(2, 5)));
        assert(locations.get(5).equals(new Point(1, 6)));
    }

    @Test
    public void testTwoOneHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(2, 1));

        assert(locations.get(0).equals(new Point(2, 3)));
        assert(locations.get(1).equals(new Point(2, 4)));
        assert(locations.get(2).equals(new Point(3, 4)));
        assert(locations.get(3).equals(new Point(2, 5)));
        assert(locations.get(4).equals(new Point(3, 5)));
        assert(locations.get(5).equals(new Point(2, 6)));
    }

    @Test
    public void testZeroTwoHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(0, 2));

        assert(locations.get(0).equals(new Point(0, 6)));
        assert(locations.get(1).equals(new Point(0, 7)));
        assert(locations.get(2).equals(new Point(1, 7)));
        assert(locations.get(3).equals(new Point(0, 8)));
        assert(locations.get(4).equals(new Point(1, 8)));
        assert(locations.get(5).equals(new Point(0, 9)));
    }

    @Test
    public void testOneTwoHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(1, 2));
        // !
        assert(locations.get(0).equals(new Point(1, 6)));
        assert(locations.get(1).equals(new Point(1, 7)));
        assert(locations.get(2).equals(new Point(2, 7)));
        assert(locations.get(3).equals(new Point(1, 8)));
        assert(locations.get(4).equals(new Point(2, 8)));
        assert(locations.get(5).equals(new Point(1, 9)));
    }

    @Test
    public void testTwoTwoHexToPoints() {
        var locations = HexToLocationsMapper.map(new Point(2, 2));

        assert(locations.get(0).equals(new Point(2, 6)));
        assert(locations.get(1).equals(new Point(2, 7)));
        assert(locations.get(2).equals(new Point(3, 7)));
        assert(locations.get(3).equals(new Point(2, 8)));
        assert(locations.get(4).equals(new Point(3, 8)));
        assert(locations.get(5).equals(new Point(2, 9)));
    }
}
