package kr.sadalmelik.cleancode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by SejongPark on 14. 10. 25..
 */
public class ClientTest {
    private static final int PORT = 8009;
    private static final int TIMEOUT = 2000;

    Server server;
    Thread serverThread;

    @Before
    public void createServer() throws IOException {
        try {
            server = new Server(PORT, TIMEOUT);
            serverThread = new Thread(server);
            serverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void shutdownServer() throws InterruptedException {
        if (server != null) {
            server.stopProcessing();
            serverThread.join();
        }
    }

    class TrivialCleint implements Runnable {
        int clientNumber;

        TrivialCleint(int clientNumber) {
            this.clientNumber = clientNumber;
        }

        public void run() {
            try {
                connectSendReceive(clientNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 10000)
    public void shouldRunInUnder10Seconds() throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; ++i) {
            threads[i] = new Thread(new TrivialCleint(i));
            threads[i].start();
        }

        for (int i = 0; i < threads.length; ++i) {
            threads[i].join();
        }
    }

    private void connectSendReceive(int i) throws IOException {
        System.out.printf("Client %2d : connecting\n", i);
        Socket socket = new Socket("localhost", PORT);
        System.out.printf("Client %2d : sending message\n", i);
        //MessageUtils.sendMessage(socket, Integer.toString(i));
        System.out.printf("Client %2d : getting reply\n", i);
        MessageUtils.getMessage(socket);
        System.out.printf("Client %2d : finished\n", i);
        socket.close();
    }


}
