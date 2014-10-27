package kr.sadalmelik.cleancode;

import java.io.IOException;
import java.net.Socket;

class ClientRequestProcessor {
    private ClientConnection clientConnection;

    public ClientRequestProcessor(ClientConnection clientConnection) {
        this.clientConnection = clientConnection;
    }

    public void process() {
        Socket socket = clientConnection.getSocket();
        try {
            System.out.printf("Server : getting message\n");
            String message = MessageUtils.getMessage(socket);
            System.out.printf("Server : got message : %s\n", message);
            Thread.sleep(1000);
            System.out.printf("Server: sending reply : %s\n", message);
            MessageUtils.sendMessage(socket, "Processed : " + message);
            System.out.printf("Server : sent\n");
            silentCloseSocket(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void silentCloseSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

}