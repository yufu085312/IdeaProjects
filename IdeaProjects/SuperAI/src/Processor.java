import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class Processor extends Thread {

    java.net.Socket socket;

    public Processor(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);) {

            out.println("ようこそ！");

            // 通信処理自体を無限ループ化
            while (true) {

                // クライアントからのデータ受信 待ち受け
                String message = in.readLine();

                // 「exit」メッセージを受け取ったら無限ループから抜ける
                if (message.equals("exit")) {
                    break;
                }

                if (message.startsWith("こんにちは")) {
                    out.println("こんにちは！今日はあいにくの天気ですね……。");
                } else if (message.startsWith("こんばんは")) {
                    out.println("今はお昼ですよ？？こんにちは！");
                } else if (message.endsWith("?") || message.endsWith("？")) {
                    out.println("その質問にはお答えしかねます。");
                } else if (message.contains("天気")) {
                    out.println("今日はいい天気ですよ！");
                } else {
                    out.println("おっしゃっている言葉が理解できません……");
                }
            }

            // ソケットを閉じる
            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}