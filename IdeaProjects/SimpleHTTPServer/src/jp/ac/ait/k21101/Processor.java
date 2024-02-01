package jp.ac.ait.k21101;

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

            // クライアントからのデータ受信 待ち受け
            String message = in.readLine();
            System.out.println(message);
            String path = message.split(" ")[1];

            if (path.endsWith(".css")) {

                out.println("HTTP/1.0 200 OK\n" +
                        "Content-Type: text/css\n" +
                        "\n" +
                        "* {\n" +
                        "  margin: 0;\n" +
                        "  padding: 0;\n" +
                        "  box-sizing: border-box;\n" +
                        "}\n" +
                        "body {\n" +
                        "  height: 100vh;\n" +
                        "  display: flex;\n" +
                        "  justify-content: center;\n" +
                        "  align-items: center;\n" +
                        "}\n" +
                        "main {\n" +
                        "  height: 450px;\n" +
                        "  max-height: 90vh;\n" +
                        "  width: 800px;\n" +
                        "  max-width: 90vw;\n" +
                        "  border-radius: 10px;\n" +
                        "  box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 60px -10px;\n" +
                        "  display: flex;\n" +
                        "  justify-content: center;\n" +
                        "  align-items: center;\n" +
                        "  flex-direction: column;\n" +
                        "}\n" +
                        "h1 {\n" +
                        "  padding: 0 3em;\n" +
                        "  margin-bottom: 2em;\n" +
                        "  text-align: center;\n" +
                        "}\n" +
                        "button {\n" +
                        "  font-size: 1.25em;\n" +
                        "  padding: 0.5em 1em;\n" +
                        "}\n" +
                        ".copyright {\n" +
                        "  margin-top: 20px;\n" +
                        "  text-decoration: underline;\n" +
                        "  font-style: italic;\n" +
                        "}");
            } else if (path.endsWith(".js")) {

                out.println("HTTP/1.0 200 OK\n" +
                        "Content-Type: text/javascript\n" +
                        "\n" +
                        "var btn = document.querySelector('button.fire');\n" +
                        "btn.addEventListener('click', function() {\n" +
                        "  alert('Hello, SimpleHTTPServer!!');\n" +
                        "});");

            } else {

                out.println("HTTP/1.0 200 OK\n" +
                        "Content-Type: text/html\n" +
                        "\n" +
                        "<!DOCTYPE html>\n" +
                        "<html lang=\"ja\">\n" +
                        "<head>\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <title>SimpleHTTPServer</title>\n" +
                        "  <link rel=\"stylesheet\" href=\"style.css\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "  <main>\n" +
                        "    <h1>このページはSimpleHTTPServerより生成されて返されています。</h1>\n" +
                        "    <p><button class=\"fire\">Push!!</button></p>\n" +
                        "    <p class=\"copyright\">K21101 - 福原優太</p>\n" +
                        "  </main>\n" +
                        "  <script src=\"script.js\"></script>\n" +
                        "</body>\n" +
                        "</html>");


            }

            // ソケットを閉じる
            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
