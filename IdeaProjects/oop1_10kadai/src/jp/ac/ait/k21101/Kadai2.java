package jp.ac.ait.k21101;

import java.util.Scanner;
public class Kadai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean pasu = true;

        while (pasu) {
            System.out.println("パスワードを入力してください");
            String input = sc.nextLine();
            try{
                pasu = !PasswordManager.validate(input);
            }catch (PasswordRulesViolationException prvex) {
                System.out.println("パスワードのルール基準を満たしていません" + prvex.getMessage());
                pasu = true;
            }
        }
        System.out.println("パスワードを確認しました");
    }
}