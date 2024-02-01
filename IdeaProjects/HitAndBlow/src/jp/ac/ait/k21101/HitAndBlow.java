package jp.ac.ait.k21101;

import java.util.Scanner;

/**
 * メインクラス
 */
public class HitAndBlow {
    public static void main(String[] args) {
        //1.Managerクラスをappなどの名前の変数でインスタンス化する。
        //答えの生成など、ゲームの準備が整います。
        Manager app = new Manager();

        //2.(デバッグ時のみ、1でインスタンス化したオブジェクトのapp.getAnswer().get()で答え取得し画面に出力してください。 提出時にはこの出力を消しておきましょう。 )
        //System.out.println(app.getAnswer().get());

        //3.ユーザー(回答者)から入力を受け付けます。
        //System.out.println("input " + Answer.DIGITS + " numbers :");などのメッセージを差し込んでおくと、丁寧です。
        while (true) {
            Scanner num = new Scanner(System.in);
            System.out.println("input " + Answer.DIGITS + " numbers :");
            String number = num.nextLine();

            //4.入力された文字列が、
            // 符号なし整数値のみで、
            if(!StringUtilities.isUnsignedInteger(number)) {
                System.out.println("符号なしの整数値ではありません");
                return;
            }
            // かつ文字の長さがAnswer.DIGITSと等しいかをチェックし、
            if(number.length() != Answer.DIGITS) {
                System.out.println("文字の長さが正しくありません");
            }
            // 合致しない場合はエラーとしてプログラムを終了します。

            //5.Managerのインスタンスより、
            // solve(String value)メソッドを呼び、 <- valueは入力された3桁の文字列
            // Responseのインスタンスを受け取ります。
            Response ret = app.solve(number); //(value);

            //6.受け取ったResponseのインスタンスのgetHit()の戻り値が、
            // Answer.DIGITSと等しい場合、
            // 正解のメッセージと、試行回数(Managerのインスタンス.getCount())を出力します。
            if(ret.getHit() == Answer.DIGITS) {
                System.out.println("正解しました！");
                System.out.println(app.getCount() + "回目です。");
                break;
            }else {
                //7.6.の条件に合致しない場合、
                // ResponseのインスタンスのgetHit()とgetBlow()を
                // Hit,Blowの値として画面に出力し、
                System.out.println("Hit : " + ret.getHit() + "  Blow : " + ret.getBlow());
                // 3.に戻ります。
            }
        }

        //ret.getHit()
        //ret.getBlow
    }
}
