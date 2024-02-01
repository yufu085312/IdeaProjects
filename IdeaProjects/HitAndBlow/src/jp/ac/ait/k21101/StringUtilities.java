package jp.ac.ait.k21101;

public class StringUtilities {

    /**
     * 渡された文字列が正の整数かどうか
     * 使い方は、
     * StringUtilities.isUnsignedInteger("1234567890") -> true
     * StringUtilities.isUnsignedInteger("-1234567890") -> false
     * StringUtilities.isUnsignedInteger("aaa") -> false
     *
     * @param val 正の整数かどうか判断できない文字列
     * @return 正の整数だった場合 true
     */

    public static boolean isUnsignedInteger(String val) {
     if (val == null || val.length() == 0) return false;
     return java.util.regex.Pattern.compile("\\A[0-9]+\\z").matcher(val).find();
     }

}
