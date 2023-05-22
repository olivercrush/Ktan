package com.orinine.ktan.state.debug;

import com.orinine.ktan.state.State;
import com.orinine.ktan.state.board.json.BoardToJsonConverter;
import com.orinine.ktan.state.board.observer.StateObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class DebugStateObserver implements StateObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebugStateObserver.class);
    private static final String DEBUG_FILENAME = "debug_board.json";
    private static final String END_COMMAND = "VISUALIZER_DISCONNECT";

    private final ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    // TODO Ktan#11 - Fix DebugStateObserver message receiving

    public DebugStateObserver(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        var thread = new Thread(this::startServer);
        thread.start();
    }

    private void startServer() {
        try {
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            sendMessageToClientSocket();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client : " + inputLine);
                if (END_COMMAND.equals(inputLine))
                    break;
            }
            this.close();
        } catch (SocketException e) {
            LOGGER.info("Client disconnected");
        }
        catch (IOException e) {
            LOGGER.error("Could not start DebugStateObserver", e);
        }
    }

    @Override
    public void notify(State state) {
        try {
            var boardJson = BoardToJsonConverter.toJson(state.getBoard());

            var fileWriter = new FileWriter("visualizer/" + DEBUG_FILENAME);
            fileWriter.write(boardJson);
            fileWriter.close();

            sendMessageToClientSocket();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessageToClientSocket() {
        if (out != null) {
            // LOGGER.debug("Sending info to Socket : {}", boardJson);
            System.out.println("Sending debug filename to Socket : " + DEBUG_FILENAME);
            out.println(DEBUG_FILENAME);
        }
    }

    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
