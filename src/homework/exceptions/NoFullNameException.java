package homework.exceptions;

public class NoFullNameException extends NullPointerException {
    public NoFullNameException() {
        super("В ФИО не хватает аргументов или оно написано некорректно!");
    }

    public NoFullNameException(String s) {
        super(s);
    }
}
