package homework.presenter;

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
            System.out.println(e.getMessage());
        }
    }

    private void program() throws IOException {
        service.writeToFile();
    }
}
