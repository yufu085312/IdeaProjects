import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileDialogSample extends JFrame {
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton openButton;
    private JButton saveButton;
    private JPanel panel1;

    /**
     * メインメソッド
     * @param args
     */
    public static void main(String[] args) {
        // イベントキューに画面の起動スレッドを追加
        EventQueue.invokeLater(() -> {
            new FileDialogSample().setVisible(true);
        });
    }

    public FileDialogSample() {

        // ウィンドウを閉じたら終了させる
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // ウィンドウ起動位置とウィンドウサイズの指定
        setBounds(100, 100, 800, 600);

        // コンテンツパネル設定
        setContentPane(panel1);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTextFileActionPerformed(e);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTextFileActionPerformed(e);
            }
        });
    }

    /**
     * テキストファイル読み込みアクションイベント
     * @param evt
     */
    private void openTextFileActionPerformed(ActionEvent evt) {

        // システムのホームディレクトリを初期パスとしてjavax.swing.JFileChooserを初期化
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));

        // 開いたファイルを格納するオブジェクトを用意
        File f = null;

        // ダイアログを開き、戻り値を取得
        int selected = jfc.showOpenDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                f = jfc.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default: // case JFileChooser.ERROR_OPTION: でも良い
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
                break;
        }

        if (f != null) {

            // ファイルパスを表示する
            textField1.setText(f.getAbsolutePath());

            // 開かれたファイルに対する処理
            try {
                // ファイル読み込み
                List<String> lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
                for (String line : lines) {
                    // 1行ずつテキスト領域に追記
                    textArea1.append(line);
                    textArea1.append(System.lineSeparator());
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを開く際にエラー発生");
            }
        }
    }

    /**
     * テキストファイル保存アクションイベント
     * @param evt
     */
    private void saveTextFileActionPerformed(ActionEvent evt) {

        JFileChooser jfc = null;
        // 画面上のファイルパスを取得
        String pathString = textField1.getText();
        if (pathString.isEmpty()) {
            // システムのホームディレクトリを初期パスとしてjavax.swing.JFileChooserを初期化
            jfc = new JFileChooser(System.getProperty("user.home"));
        } else {
            Path p = Path.of(pathString);
            // ファイルの親(ディレクトリ)を取得してその絶対パスを文字列化
            pathString = p.getParent().toAbsolutePath().toString();
            jfc = new JFileChooser(pathString);
        }

        // 開いたファイルを格納するオブジェクトを用意
        File f = null;

        // ダイアログを開き、戻り値を取得
        int selected = jfc.showSaveDialog(this);

        switch (selected) {
            case JFileChooser.APPROVE_OPTION:
                f = jfc.getSelectedFile();
                break;
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "キャンセル");
                break;
            default: // case JFileChooser.ERROR_OPTION: でも良い
                JOptionPane.showMessageDialog(this, "取り消しまたはエラー発生");
                break;
        }

        if (f != null) {

            // 書き込み対象をBufferedWriterで開く
            try (BufferedWriter bw = Files.newBufferedWriter(f.toPath(), Charset.defaultCharset())) {
                // テキスト領域から文字列を読み込み(Scannerを使用するパターン)
                Scanner sc = new Scanner(textArea1.getText());
                while (sc.hasNextLine()) {
                    bw.append(sc.nextLine());
                    bw.newLine();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "ファイルを保存する際にエラー発生");
            }
        }
    }
}