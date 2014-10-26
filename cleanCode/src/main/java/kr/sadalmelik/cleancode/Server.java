package kr.sadalmelik.cleancode;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by SejongPark on 14. 10. 25..
 * 클린코드 부록A 동시성 II 따라하기
 */
public class Server implements Runnable {
    ServerSocket serverSocket;
    volatile boolean keepProcessing = true;

    public Server(int port, int millisecondsTimeout) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
    }

    @Override
    public void run() {
        System.out.printf("Server Starting\n");

        while (keepProcessing) {
            try {
                System.out.printf("accepting client\n");

                Socket socket = serverSocket.accept();
                System.out.printf("got client\n");
                process(socket);
            } catch (IOException e) {
                handle(e);
            }
        }
    }

    private void handle(Exception e) {
        if (!(e instanceof SocketException)) {
            e.printStackTrace();
        }
    }

    void stopProcessing() {
        keepProcessing = false;
        closeIgnoreException(serverSocket);
    }

    private void process(final Socket socket) {
        if (socket == null) {
            return;
        }

        Runnable clientHandler = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.printf("Server : getting message\n");
                    String message = MessageUtils.getMessage(socket);
                    System.out.printf("Server : got message : %s\n", message);
                    Thread.sleep(1000);
                    System.out.printf("Server: sending reply : %s\n", message);
                    MessageUtils.sendMessage(socket, "Processed : " + message);
                    System.out.printf("Server : sent\n");
                    closeIgnoreException(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread clientConnection = new Thread(clientHandler);
        clientConnection.start();
    }

    private void closeIgnoreException(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    private void closeIgnoreException(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
        }
    }
}
