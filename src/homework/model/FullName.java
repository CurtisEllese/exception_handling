package homework.model;

import homework.exceptions.NoFullNameException;
import homework.exceptions.NoPhoneNumException;

public class FullName {
    private String fullName;
    private String surname;
    private String name;
    private String familyName;

    public FullName(String fullName) {
        this.fullName = fullName.strip();
        try {
            parseFullName();
        } catch (NoFullNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFullName() {
        return fullName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    private void parseFullName() throws NoFullNameException{
        String[] nameValues = fullName.split(" ");
        if (nameValues.length == 3) {
            surname = nameValues[0];
            name = nameValues[1];
            familyName = nameValues[2];
        } else if (nameValues.length == 2) {
            surname = nameValues[0];
            name = nameValues[1];
        } else throw new NoFullNameException();
    }
}
