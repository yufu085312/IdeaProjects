import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CSVFileViewer {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            System.out.print("読み込むCSVファイルパスを入力してください > ");
            String filepath = in.nextLine();

            // ファイル存在チェック
            while (!Files.exists(Path.of(filepath))) {
                System.out.println("指定されたファイルが見つかりません。");
                System.out.print("読み込むCSVファイルパスを入力してください > ");
                filepath = in.nextLine();
            }

            // ファイル読み取り可チェック
            while (!Files.isReadable(Path.of(filepath))) {
                System.out.println("指定されたファイルは読み取りできません。");
                System.out.print("読み込むCSVファイルパスを入力してください > ");
                filepath = in.nextLine();
            }

            // ファイルパスがディレクトリだった場合のチェック
            while (Files.isDirectory(Path.of(filepath))) {
                System.out.println("指定されたファイルパスはディレクトリを指しています。");
                System.out.print("読み込むCSVファイルパスを入力してください > ");
                filepath = in.nextLine();
            }


            // 事前チェック完了後、ファイルの読み込み処理を行う
            try (Scanner sc = new Scanner(Files.newBufferedReader(Path.of(filepath)))) {
                // 行番号
                int row = 0;
                while (sc.hasNextLine()) {
                    row += 1;
                    System.out.printf("%d:\t", row);
                    String line = sc.nextLine();
                    String[] cols = line.split(",", -1);
                    // 列番号
                    int colnum = 0;
                    for (String d : cols) {
                        // 列番号は自分でインクリメントする
                        colnum += 1;
                        System.out.printf("%d:%s\t", colnum, d);
                    }
                    System.out.println();
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
