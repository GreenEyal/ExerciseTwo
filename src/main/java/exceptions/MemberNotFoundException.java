package exceptions;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
