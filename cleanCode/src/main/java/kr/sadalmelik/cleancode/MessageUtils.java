package kr.sadalmelik.cleancode;

import java.io.*;
import java.net.Socket;

/**
 * Created by SejongPark on 14. 10. 25..
 */
public class MessageUtils {
    public static void sendMessage(Socket socket, String message) throws IOException {
        OutputStream stream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(stream);
        oos.writeUTF(message);
        oos.flush();
    }

    public static String getMessage(Socket socket) throws IOException {
        InputStream stream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(stream);

        return ois.readUTF();
    }

}
