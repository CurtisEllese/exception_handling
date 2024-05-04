package homework.exceptions;

public class NoPhoneNumException extends NullPointerException {
    public NoPhoneNumException() {
        super("Номер введен некорректно");
    }

    public NoPhoneNumException(String s) {
        super(s);
    }
}
