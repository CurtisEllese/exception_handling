package homework.exceptions;

public class IncorrectDateException extends NullPointerException {
    public IncorrectDateException() {
        super("Дата рождения введена неккоректно\nДата должна быть в формате дд.мм.гггг");
    }

    public IncorrectDateException(String s) {
        super(s);
    }
}
