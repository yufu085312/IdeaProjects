package jp.ac.ait.k21101;
import java.util.*;
public class PasswordManager {
    public static boolean validate(String password)
        throws PasswordRulesViolationException {
        //16以上120以下
        if(password.length() < 16 || 128 < password.length()) {
            throw new PasswordRulesViolationException("パスワードは16以上128以下である必要がある.");
        }
        int numberCharCount = 0;
        int upperCharCount = 0;
        int lowerCharCount = 0;
        int symbolCharCount = 0;

        //入力可能な記号をリストで保持
        List<Character> symbolList = Arrays.asList(',', '.', '+', '-', '*', '/', '=', '_', '#', '!', '?', '@', ' ');
        for(char c : password.toCharArray()) {
            if(Character.isDigit(c)){
                numberCharCount++;
            }if(Character.isUpperCase(c)){
                upperCharCount++;
            }if(Character.isLowerCase(c)){
                lowerCharCount++;
            }if(symbolList.contains(c)){
                symbolCharCount++;
            }
        }
        if(numberCharCount + upperCharCount + lowerCharCount + symbolCharCount != password.length()) {
            throw new PasswordRulesViolationException("仕様できない文字が含まれている可能性があります");
        }
        if(numberCharCount == 0 || upperCharCount == 0|| lowerCharCount == 0 || symbolCharCount ==0){
            throw new PasswordRulesViolationException("パスワードには必ず、大文字のアルファベット、小文字のアルファベット、数字、記号のうちそれぞれ一文字以上使用してください");
        }
        Set<String> unusableStringSet = new HashSet<>(Arrays.asList(
               "assword","p@ssw0rd","p@55w0rd","qwerty","asdfgh","zxcvbn","abcdef","123456"));
        for(String str: unusableStringSet) {
            if(password.toLowerCase().contains(str.toLowerCase())) {
                throw new PasswordRulesViolationException(str + "を含めることができません");
            }
        }
        return true;
    }
}
