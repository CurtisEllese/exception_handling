package homework.presenter;

import homework.model.Service;
import homework.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(view.getUserInput());
    }
}
