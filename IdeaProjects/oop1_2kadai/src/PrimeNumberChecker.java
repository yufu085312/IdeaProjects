import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        //任意の整数値をキーボードから入力させます。
        Scanner sc = new Scanner(System.in);
        System.out.println("整数を入力してください");
        //入力された文字列を整数値に変換します。
        String input = sc.nextLine();
        //数字ではない文字が入力された場合は、ここで実行時エラーが発生し処理が中断します。
        int num = Integer.parseInt(input);
        int x;
        int han = 0;
        //入力された整数値が、素数かどうかを判定します。
        for(x = 2; x < num; ++x){
            if(num % x == 0){
                han = 1;
                break;
            }
        }
        if(num <= 1){

            han = 1;
        }
        //素数の場合、「素数です」と表示
        //素数でない場合、「素数ではありません」と表示
        if(han == 1){
            System.out.println(num);
            System.out.println("は素数ではありません");
        } else{
            System.out.println(num);
            System.out.println("は素数です");
        }
    }
}
