package com.orinine.ktan.eventprocessing;

import com.orinine.ktan.eventprocessing.event.CreateVillageEvent;
import com.orinine.ktan.eventprocessing.event.Event;
import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.model.Building;
import com.orinine.ktan.state.board.model.Port;
import com.orinine.ktan.state.board.util.Point;
import com.orinine.ktan.state.player.PlayerColor;
import com.orinine.ktan.utils.StateBuilderForTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventProcessorTest {

    private static final Point TEST_POINT = new Point(3, 3);
    private static final Event TEST_EVENT = new CreateVillageEvent(TEST_POINT, PlayerColor.BLUE);

    private State state;
    private EventHistory history;

    @BeforeEach
    public void setup() {
        state = StateBuilderForTests.aStateBuilderForTests().build();
        history = new EventHistory();
    }

    @Test
    public void processEventTest() {
        var eventProcessor = new EventProcessor(history, state);
        eventProcessor.processEvent(TEST_EVENT);

        assertEquals(1, history.getEvents().size());
        assertEquals(TEST_EVENT, history.getEvents().get(0));
        assertEquals(Building.VILLAGE, state.getBoard().getLocationGrid()[TEST_POINT.y()][TEST_POINT.x()].building());
        assertEquals(PlayerColor.BLUE, state.getBoard().getLocationGrid()[TEST_POINT.y()][TEST_POINT.x()].color());
        assertEquals(Port.EMPTY, state.getBoard().getLocationGrid()[TEST_POINT.y()][TEST_POINT.x()].port());
    }

}
