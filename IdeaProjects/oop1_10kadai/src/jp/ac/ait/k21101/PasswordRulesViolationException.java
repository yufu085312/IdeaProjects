package jp.ac.ait.k21101;

public class PasswordRulesViolationException extends Exception{
    public PasswordRulesViolationException(){super();}
    public PasswordRulesViolationException(String message) {super(message);}
    public PasswordRulesViolationException(Throwable cause) {super(cause);}
    public PasswordRulesViolationException(String message, Throwable cause) {super(message, cause);}
    protected PasswordRulesViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
