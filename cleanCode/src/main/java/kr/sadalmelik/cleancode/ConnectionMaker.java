package kr.sadalmelik.cleancode;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionMaker {
    ServerSocket serverSocket;
    int connectedClient = 0;

    public ConnectionMaker(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ClientConnection awaitClient() throws IOException {
        System.out.printf("accepting client\n");
        System.out.println("connectedClient : " + ++connectedClient);
        Socket socket = serverSocket.accept();
        System.out.printf("got client\n");

        return new ClientConnection(socket);
    }

    public void shutdown() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
    }
}
