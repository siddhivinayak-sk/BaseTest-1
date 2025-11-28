package basetest.multithreading.virtual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Optional;

import static basetest.multithreading.virtual.VirtualThreadConstants.DEFAULT_SERVER_PROT;
import static basetest.multithreading.virtual.VirtualThreadConstants.DEFAULT_SERVER_HOST;

class VirtualThreadConstants {
    public static final int DEFAULT_SERVER_PROT = 8080;
    public static final String DEFAULT_SERVER_HOST = "localhost";
}

class VirtualThreadClient {

    private String serverHost;
    private Integer serverPort;

    public void setServerHost(String host) {
        serverHost = host;
    }

    public void setServerPort(Integer port) {
        serverPort = port;
    }

    void startClient() {
        try(
                Socket client = new Socket(Optional.ofNullable(serverHost).orElse(DEFAULT_SERVER_HOST), Optional.ofNullable(serverPort).orElse(DEFAULT_SERVER_PROT));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ) {
            Thread.ofVirtual().start(() -> {
                try {
                    BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                    String inputLine;
                    while((inputLine = consoleReader.readLine()) != null) {
                        out.println(inputLine);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("Connected to server: " + client.getInetAddress());
            String inputLine;
            while((inputLine = in.readLine()) != null) {
                System.out.println("Received from server: " + inputLine);
                if(inputLine.equals("exit")) {
                    break;
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error connecting to server: " + ex.getMessage());
        }
    }

    public static void main(String...args) {
        VirtualThreadClient client = new VirtualThreadClient();
        client.startClient();
    }
}

class VirtualThreadServer {
    private Integer serverPort;

    public void setServerPort(Integer port) {
        serverPort = port;
    }

    public void startServer() {
        System.out.println("===========Server starting===========");
        try(var server = new ServerSocket(Optional.ofNullable(serverPort).orElse(DEFAULT_SERVER_PROT))) {
            System.out.println("===========Server ready to accept connections===========");
            while(true) {
                try {
                    var clientSocket = server.accept();
                    Thread.ofVirtual().start(() -> {
                        try {
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            String inputLine;
                            while((inputLine = in.readLine()) != null) {
                                System.out.println("Received line from client " + clientSocket.getLocalPort() + ": " + inputLine);
                                out.println(inputLine); // echo back to client
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                } catch (IOException e) {
                    System.out.println("Error accepting client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public static void main(String...args) {
        VirtualThreadServer server = new VirtualThreadServer();
        server.setServerPort(8080);
        server.startServer();
    }
}
