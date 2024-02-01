import java.util.Scanner;
public class Saiten {
    public static void main(String[] args) {
        //テストの点数をキーボードから入力させます。
        Scanner sc = new Scanner(System.in);

        //入力前に「テストの点数を入力してください。」のようなメッセージが表示されると良いでしょう。
        System.out.println("テストの点数を入力してください。");
        //入力された文字列を整数値に変換します。
        String input = sc.nextLine();
        //数字ではない文字が入力された場合は、ここで実行時エラーが発生し処理が中断します。
        int num = Integer.parseInt(input);
        if(num < 0 || num > 100) {
            System.out.println("入力された値は点数として正しくありません。");
            return;
        }
        //変換した整数値が、0〜100の範囲外だった場合、「入力された値は点数として正しくありません。」と表示して処理終了します。
        //処理を終了するには、mainメソッド内であれば、return;を書くことでその文が実行されると終了できます。
        //範囲内だった場合、以下の条件に応じてそれぞれ画面にメッセージを表示させてプログラムを終了してください。
        if(num >= 60) {
            System.out.println("合格です。おめでとう！");//100〜60:「合格です。おめでとう！」
        }else if (num >= 20) {
            System.out.println("不合格です。再テストを行いましょう！");//59〜20:「不合格です。再テストを行いましょう！」
        }else {
            System.out.println("不合格です。来年もう一度頑張りましょう。");//19〜0:「不合格です。来年もう一年頑張りましょう。」
        }
    }
}
