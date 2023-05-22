package com.orinine.ktan.eventprocessing;

import com.orinine.ktan.eventprocessing.event.CreateVillageEvent;
import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Port;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;
import com.orinine.ktan.utils.StateBuilderForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventsTest {

    private State state;

    @BeforeEach
    public void setupEach() {
        state = StateBuilderForTests.aStateBuilderForTests().build();
    }

    @Test
    public void createVillageEventTest() {
        var event = new CreateVillageEvent(new Point(3, 3), PlayerColor.BLUE);
        event.process(state);

        assertEquals(state.getBoard().getLocationGrid()[3][3].building(), Building.VILLAGE);
        assertEquals(state.getBoard().getLocationGrid()[3][3].color(), PlayerColor.BLUE);
        assertEquals(state.getBoard().getLocationGrid()[3][3].port(), Port.EMPTY);
    }
}
