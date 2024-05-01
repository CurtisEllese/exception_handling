package homework.view;

import homework.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        flag = true;
    }

    @Override
    public void start() {
        while(flag) {
            printMenu();

        }
    }

    private void printMenu() {
        System.out.println("Введите свои данные в одной строчке");
        System.out.println("Все параметры должны быть разделены через точку с запятой (;)");
        System.out.println("ФИО в формате: Фамилия Имя Отчество");
        System.out.println("Дата рождения в формате: дд.мм.гггг");
        System.out.println("Номер телефона в формате: 77472507816 - то есть без знаков и пробелов, только цифры");
        System.out.println("Пол в формате: f или m - то есть одной буквой, без каких-то символов и знаков, пробелов");
        System.out.println("f - женский пол");
        System.out.println("m - мужской пол");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
