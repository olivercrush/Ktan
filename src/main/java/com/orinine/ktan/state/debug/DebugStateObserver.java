package com.orinine.ktan.state.debug;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.json.BoardToJsonConverter;
import com.orinine.ktan.state.board.observer.StateObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class DebugStateObserver implements StateObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebugStateObserver.class);
    private static final String DEBUG_FILENAME = "debug_board.json";

    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;

    public DebugStateObserver(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void notify(State stage) {
        try {
            var boardJson = BoardToJsonConverter.toJson(stage.getBoard());

            var fileWriter = new FileWriter("visualizer/" + DEBUG_FILENAME);
            fileWriter.write(boardJson);
            fileWriter.close();

            // LOGGER.debug("Sending info to Socket : {}", boardJson);
            System.out.println("Sending debug filename to Socket : " + DEBUG_FILENAME);
            out.println(DEBUG_FILENAME);

            var response = in.readLine();
            // LOGGER.info("Received response : {}", response);
            System.out.println("Received response : " + response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        socket.close();
    }
}
