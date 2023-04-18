package com.orinine.ktan.state.debug;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.json.BoardToJsonConverter;
import com.orinine.ktan.state.board.observer.StateObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DebugStateObserver implements StateObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebugStateObserver.class);
    private static final String DEBUG_FILENAME = "debug_board.json";
    private static final String END_COMMAND = "VISUALIZER_DISCONNECT";

    private final ServerSocket serverSocket;
    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;

    private State currentState;

    // TODO : fix closing connection doesnt throw exception

    public DebugStateObserver(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        var thread = new Thread(this::startServer);
        thread.start();
    }

    private void startServer() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (END_COMMAND.equals(inputLine))
                    break;
            }
            this.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void notify(State state) {
        this.currentState = state;
        sendStateToClient(state);
    }

    private void sendStateToClient(State state) {
        try {
            var boardJson = BoardToJsonConverter.toJson(state.getBoard());

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
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
