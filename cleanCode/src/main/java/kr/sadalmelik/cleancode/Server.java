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

    //리팩토링 1단계 단일 책임 원칙 준수하기
    ConnectionMaker connectionMaker;
    ClientScheduler clientScheduler;

    public Server(int port, int millisecondsTimeout) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);

        connectionMaker = new ConnectionMaker(serverSocket);
        clientScheduler = new ThreadPerRequestScheduler();
     }

    @Override
    public void run() {
        System.out.printf("Server Starting\n");

        while (keepProcessing) {
            try {
                ClientConnection clientConnection = connectionMaker.awaitClient();
                ClientRequestProcessor requestProcessor = new ClientRequestProcessor(clientConnection);
                clientScheduler.schedule(requestProcessor);
            } catch (IOException e) {
                if((e instanceof SocketException)){
                    e.printStackTrace();
                }
            }
        }
            connectionMaker.shutdown();
    }

    void stopProcessing() {
        keepProcessing = false;
    }


}
