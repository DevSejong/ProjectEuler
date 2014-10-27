package kr.sadalmelik.cleancode;

/**
 * Created by SejongPark on 14. 10. 26..
 */
public class ThreadPerRequestScheduler implements ClientScheduler {
    @Override
    public void schedule(final ClientRequestProcessor requestProcessor) {
        Runnable clientHandler = new Runnable() {
            @Override
            public void run() {
                requestProcessor.process();
            }
        };

        Thread clientConnection = new Thread(clientHandler);
        clientConnection.start();
    }
}
