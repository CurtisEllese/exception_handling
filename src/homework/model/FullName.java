package homework.model;

public class FullName {
    private String fullName;
    private String surname;
    private String name;
    private String familyName;

    public FullName(String fullName) {
        this.fullName = fullName;
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

    private void parseFullName() {
        surname = fullName.split(" ,")[0];
        name = fullName.split(" ,")[1];
        familyName = fullName.split(" ,")[2];
    }
}
