package homework.model;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Service {
    private String surname;
    private FullName fullName;
    private DateOfBirth dateOfBirth;
    private PhoneNumber phoneNumber;
    private Sex sex;
    private String[] userData;

    public Service(String userInput) {
        parseUserInput(userInput);
    }

    public void parseUserInput(String userInput) {
        this.userData = userInput.split(";");
    }

    public void getFullNameFromInput() {
        for (int i = 0; i < userData.length; i++) {
            if (userData[i].length() > 1 && !containDigits(userData[i])) {
                fullName = new FullName(userData[i]);
                return;
            }
        }
    }

    public void getDateOfBirthFromInput() {
        int charPos = -1;
        for (int i = 0; i < userData.length; i++) {
            charPos = userData[i].indexOf('.');
            if (userData[i].length() > 1 && containDigits(userData[i]) && charPos != -1) {
                dateOfBirth = new DateOfBirth(userData[i]);
                return;
            }
        }
    }

    public void setSurname() {
        this.surname = fullName.getSurname();
    }

    public String getFullName() {
        return fullName.getFullName();
    }

    public String getDateOfBirth() {
        return dateOfBirth.getDate();
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

    public void writeToFile() throws IOException {
        FileWriter file = new FileWriter(surname);
        BufferedWriter writer = new BufferedWriter(file);

        writer.write(createDataString() + "\n");

        writer.close();
    }
}
