package third_lesson;

import java.io.FileNotFoundException;

// 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
//2. Создайте класс исключений, которое будет возникать при обращении к пустому
// элементу в массиве ссылочного типа. Исключение должно отображать понятное для пользователя сообщение об ошибке
//3. Создайте класс исключения, которое будет возникать при попытке открыть
//несуществующий файл. Исключение должно отображать понятное для
//пользователя сообщение об ошибке.
public class Task7 {
    public static void main(String[] args) {
        try {
            int a = div(5, 0);
        } catch (DivByZero e) {
            System.out.println(e.getMessage());
        }
    }

    public static int div(int a, int b) {
        if (b==0) throw new DivByZero();
        return  a / b;
    }
}

class DivByZero extends ArithmeticException{
    public DivByZero() {
        super("Деление на 0 недопустимо!");
    }

    public DivByZero(String s) {
        super(s);
    }
}

class EmptyArrayElement extends NullPointerException {
    public EmptyArrayElement(int index) {
        super("Обращение к пустому элементу запрещено, индекса элемента массива " + index);
    }

    public EmptyArrayElement() {
        super("Обращение к пустому элементу запрещено");
    }
}

class NonExistFile extends FileNotFoundException {
    public NonExistFile(String path) {
        super("Файл несуществует, путь: " + path);
    }

    public NonExistFile() {
        super("Файл несуществует");
    }
}