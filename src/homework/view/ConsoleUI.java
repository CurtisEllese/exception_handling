package homework.view;

import homework.model.FullName;
import homework.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flag = true;
    }

    @Override
    public void start() {
        while(flag) {
            printMenu();
            handleEnteredInput();
        }
    }



    private void handleEnteredInput() {
        String enteredString = scanner.nextLine();

        int resultValueAmountCode = checkStringValuesAmount(enteredString);
        printAnswer(valueAmountErrorHandle(resultValueAmountCode));

        if (resultValueAmountCode == 0) {
            flag = false;
            presenter = new Presenter(this, enteredString);
        }
    }

    private int checkStringValuesAmount(String enteredString) {
        String[] enteredValues = enteredString.split(";");

        if (enteredValues.length == 4) {
            return 0;
        } else if (enteredValues.length < 4){
            return -1;
        } else if (enteredValues.length > 4){
            return 1;
        } else return -2;
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

    private String valueAmountErrorHandle(int errCode) {
        if (errCode == 0) return "Проверка на количество аргументов прошла успешно...";
        else if (errCode == 1) return "\nВведено слишком много аргументов в строке.\nАргументы должны отделятся символом ';'\n";
        else if (errCode == -1) return "\nВведено слишком мало аргументов в строке.\nАргументы должны отделятся символом ';'\n";
        else return "\nВведено неверное количество аргументов в строке.\nАргументы должны отделятся символом ';'\n";
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}
