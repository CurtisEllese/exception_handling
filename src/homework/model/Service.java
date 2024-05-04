package homework.model;


import homework.exceptions.IncorrectDateException;
import homework.exceptions.IncorrectSexException;
import homework.exceptions.NoFullNameException;
import homework.exceptions.NoPhoneNumException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    private String surname;
    private FullName fullName;
    private DateOfBirth dateOfBirth;
    private PhoneNumber phoneNumber;
    private Sex sex;
    private String[] userData;
    String currentDirectory = System.getProperty("user.dir");

    public Service(String userInput) {
        parseUserInput(userInput);
    }

    private void parseUserInput(String userInput) {
        this.userData = userInput.split(";");
    }

    public void getFullNameFromInput() throws NoFullNameException {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].length() > 1 && !containDigits(userData[i])) {
                fullName = new FullName(userData[i]);
                return;
            }
        }
    }

    public void getDateOfBirthFromInput() throws IncorrectDateException {
        for (int i = 0; i < userData.length; i++) {
            try {
                if (isValidDateFormat(userData[i])) {
                    dateOfBirth = new DateOfBirth(userData[i]);
                    return;
                }
            } catch (ParseException e) {
                throw new IncorrectDateException();
            }
        }

    }


    private boolean isValidDateFormat(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public void setSurname() {
        try {
            this.surname = fullName.getSurname();
        } catch (NoFullNameException e) {
            e.getMessage();
        }
    }

    public String getFullName() {
        try {
            return fullName.getFullName();
        } catch (NoFullNameException e) {
            e.getMessage();
        }
        return null;
    }

    public String getDateOfBirth() {
        try {
            checkDate();
            return dateOfBirth.getDate();
        } catch (IncorrectDateException e) {
            e.getMessage();
        }
        return null;
    }

    private void checkDate() {
        if (dateOfBirth.getDate() == null) throw new IncorrectDateException();
    }

    public void getPhoneNumFromInput() {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].length() > 1 && containDigits(userData[i]) && !userData[i].contains(".")) {
                phoneNumber = new PhoneNumber(userData[i]);
                return;
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

    public void getSexFromInput() {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].length() == 1) {
                sex = new Sex(userData[i]);
                return;
            }
        }
    }

    public String getSex() {
        return sex.getSex();
    }

    public boolean containDigits(String string) {
        for(int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public String createDataString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getFullName());
        sb.append(" ");
        sb.append(getDateOfBirth());
        sb.append(" ");
        sb.append(getPhoneNumber());
        sb.append(" ");
        sb.append(getSex());

        return sb.toString();
    }

    public void writeToFile() {
        try (FileWriter writer = new FileWriter(currentDirectory + File.separator + checkSurname(), true)){
            writer.write(createDataString() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        } catch (NoFullNameException e) {
            System.out.println("Ошибка записи в файл. Не предоставлено полное имя");
        } catch (IncorrectDateException e) {
            System.out.println("Ошибка записи в файл. Неверный формат даты");
        }
    }

    private String checkSurname() {
        if (surname == null) throw new NoFullNameException();
        else return surname;
    }
}
