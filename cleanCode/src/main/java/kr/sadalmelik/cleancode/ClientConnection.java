package kr.sadalmelik.cleancode;

import java.net.Socket;

/**
 * Created by SejongPark on 14. 10. 26..
 */
public class ClientConnection {
    private Socket socket = new Socket();

    public ClientConnection(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket(){
        return this.socket;
    }
}
