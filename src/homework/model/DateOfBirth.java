package homework.model;

import homework.exceptions.IncorrectDateException;

public class DateOfBirth {
    private String date;
    public DateOfBirth(String date) {
        this.date = date;
    }

    public String getDate() throws NullPointerException {
        return date;
    }
}
