package homework.presenter;

import homework.exceptions.IncorrectDateException;
import homework.model.Service;
import homework.view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, String enteredString) {
        this.view = view;
        service = new Service(enteredString);
        try {
            program();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void program() throws IOException {
        service.getFullNameFromInput();
        try {
            service.getDateOfBirthFromInput();
        } catch (IncorrectDateException e) {
            System.out.println(e.getMessage());
        }
        service.setSurname();
        service.getPhoneNumFromInput();
        service.getSexFromInput();
        service.writeToFile();
    }
}
