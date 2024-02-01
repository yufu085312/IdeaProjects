import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;
public class HtmlGetter extends JFrame{
    private JPanel panel1;
    private JTextField txtURL;
    private JButton btnGet;
    private JButton btnSave;
    private JTextArea txtHtml;
    private void saveTextFileActionPerformed(ActionEvent evt) {

        JFileChooser dai = new JFileChooser(System.getProperty("user.home"));
        File file = null;
        int selected;
        selected = dai.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                file = dai.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default:
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生しました");
                break;
        }

        if (file != null) {
            try (BufferedWriter b = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
                Scanner scanner = new Scanner(txtHtml.getText());
                while (scanner.hasNextLine()) {
                    b.append(scanner.nextLine());
                    b.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラーが発生しました");
            }
        }
    }

    public HtmlGetter() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        setContentPane(panel1);

        var client = HttpClient.newHttpClient();

        btnGet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    var request = HttpRequest.newBuilder()
                            .uri(URI.create(txtURL.getText()))
                            .build();
                    var response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    txtHtml.setText(response.body());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saveTextFileActionPerformed(ae);
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {new HtmlGetter().setVisible(true);
        });
    }
}
