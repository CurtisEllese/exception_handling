package homework.exceptions;

public class IncorrectSexException extends NullPointerException {
    public IncorrectSexException() {
        super("Неверно введен пол");
    }

    public IncorrectSexException(String s) {
        super(s);
    }
}
