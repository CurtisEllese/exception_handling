package homework.model;


import homework.exceptions.IncorrectDateException;
import homework.exceptions.IncorrectSexException;
import homework.exceptions.NoFullNameException;
import homework.exceptions.NoPhoneNumException;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

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

        getFullNameFromInput();
        getDateOfBirthFromInput();
        setSurname();
        getPhoneNumFromInput();
        getSexFromInput();
    }

    private void parseUserInput(String userInput) {
        this.userData = userInput.split(";");
    }

    public void getFullNameFromInput() throws NoFullNameException {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].strip().length() > 1 && !containDigits(userData[i])) {
                fullName = new FullName(userData[i].strip());
                return;
            }
        }
    }

    public void getDateOfBirthFromInput() throws IncorrectDateException {
        for (int i = 0; i < userData.length; i++) {
            if (isDateValid(userData[i].strip())) {
                dateOfBirth = new DateOfBirth(userData[i].strip());
                break;
            }
        }
    }



    public static boolean isDateValid(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            try {
                LocalDate.parse(date, dateFormatter);
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
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
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getDateOfBirth() {
        try {
            dateOfBirth.getDate();
        } catch (NullPointerException e) {
            System.out.println("Дата введена в неверном формате");
        }
        return dateOfBirth.getDate();
    }


    public void getPhoneNumFromInput() {
        for (int i = 0; i < userData.length; i++) {
            String value = userData[i].strip();

            if (value.length() > 1 && containDigits(value) && !value.contains(".")) {
                try {
                    checkPhoneNum(value);
                    phoneNumber = new PhoneNumber(value);
                    return;
                } catch (NoPhoneNumException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private void checkPhoneNum(String value) throws NoPhoneNumException {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NoPhoneNumException();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

    public void getSexFromInput() {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].strip().length() == 1) {
                sex = new Sex(userData[i].strip());
                return;
            }
        }
    }

    public String getSex() {
        if (Objects.equals(sex.getSex(), "f") || Objects.equals(sex.getSex(), "m")) {
            return sex.getSex();
        } else {
            throw new IncorrectSexException();
        }
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
        if (getFullName() != null) {
            sb.append(getFullName());
            sb.append(" ");
        } else {
            return null;
        }

        if (getDateOfBirth() != null) {
            sb.append(getDateOfBirth());
            sb.append(" ");
        } else {
            return null;
        }

        if (getPhoneNumber() != null) {
            sb.append(getPhoneNumber());
            sb.append(" ");
        } else {
            return null;
        }

        if (getSex() != null) {
            try {
                if (Objects.equals(getSex(), "f")) {
                    sb.append("женский пол");
                } else if (Objects.equals(getSex(), "m")) {
                    sb.append("мужской пол");
                }
            } catch (IncorrectSexException e) {
                System.out.println(e.getMessage());
            }
        } else {
            return null;
        }

        return sb.toString();
    }

    public void writeToFile() {
        try (FileWriter writer = new FileWriter(currentDirectory + File.separator + checkSurname(), true)){
            writer.write(createDataString() + "\n");
            System.out.println("Данные записаны в файл успешно!");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Данные не записаны в файл, введите корректные данные");
        }
    }

    private String checkSurname() {
        if (surname == null) throw new NoFullNameException();
        else return surname;
    }
}
