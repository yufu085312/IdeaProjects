import java.net.ServerSocket;
import java.net.Socket;

public class SuperAI {

    public static void main(String[] args) throws Exception {

        System.out.println("きどう");
        try (ServerSocket ss = new ServerSocket(12345)) {
            while (true) {
                Socket s = ss.accept();
                System.out.printf("クライアントからの接続: %s:%d\n", s.getInetAddress(), s.getPort());
                Processor app = new Processor(s);
                app.start();
            }
        }
    }
}
