package code;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTcp  {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();
            new Thread(new Web(socket)).start();
        }

    }
}
