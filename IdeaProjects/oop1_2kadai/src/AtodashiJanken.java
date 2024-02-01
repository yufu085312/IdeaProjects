import java.util.Scanner;
public class AtodashiJanken {
    public static void main(String[] args) {
        //ランダムな数値を生成して、変数に退避しておきます。
        int randomNumber = new java.util.Random().nextInt(3);
        //生成されたランダムな値を元に、「0:グー,1:チョキ,2:パー」を画面表示します。
        switch (randomNumber){
            case 0:
                System.out.println("0:グー");
                break;
            case 1:
                System.out.println("1:チョキ");
                break;
            case 2:
                System.out.println("2:パー");
        }
        //「何を出しますか？ (0:グー,1:チョキ,2:パー)」のように画面表示し、数値を入力させます。(入力された値が数値変換できない場合の考慮は不要です)
        System.out.println("何を出しますか？0:グー,1 :チョキ,2:パー");
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();

        int num = Integer.parseInt(inputLine);

        //入力された数値と、1.で生成されたランダムな数値で、勝敗を判定します。
        //勝敗のメッセージを画面表示しますが、メッセージの内容は、それぞれ「勝ち」「負け」「あいこ」をどこかに表示してください。
        //入力された値が0,1,2のどれでもない場合は、「あなたの出した手が判断できません。勝負はしません。」というメッセージを出力し、プログラムを終了してください。
        switch (randomNumber){
            case 0:
                switch (num){
                    case 0:
                        System.out.println("あいこ");
                        break;
                    case 1:
                        System.out.println("負け");
                        break;
                    case 2:
                        System.out.println("勝ち");
                        break;
                    default:
                        System.out.println("あなたの出した手が判断できません。勝負はしません。");
                        break;
                }
                return;
            case 1:
                switch (num){
                    case 0:
                        System.out.println("勝ち");
                        break;
                    case 1:
                        System.out.println("あいこ");
                        break;
                    case 2:
                        System.out.println("負け");
                        break;
                    default:
                        System.out.println("あなたの出した手が判断できません。勝負はしません。");
                        break;
                }
                return;
            case 2:
                switch (num){
                    case 0:
                        System.out.println("負け");
                        break;
                    case 1:
                        System.out.println("勝ち");
                        break;
                    case 2:
                        System.out.println("あいこ");
                        break;
                    default:
                        System.out.println("あなたの出した手が判断できません。勝負はしません。");
                        break;
                }
                return;
        }
        in.close();
    }
}

