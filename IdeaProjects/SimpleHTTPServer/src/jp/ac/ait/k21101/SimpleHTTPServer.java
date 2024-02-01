package jp.ac.ait.k21101;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {

    public static void main(String[] args) throws Exception {

        try (ServerSocket ss = new ServerSocket(8088)) {
            while (true) {
                Socket s = ss.accept();
                System.out.printf("クライアントからの接続: %s:%d\n", s.getInetAddress(), s.getPort());
                Processor app = new Processor(s);
                app.start();
            }
        }
    }
}