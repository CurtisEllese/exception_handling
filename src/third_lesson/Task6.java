package third_lesson;

// Создайте класс Счетчик, у которого есть метод add(), увеличивающий
//значение внутренней int переменной на 1.Сделайте так, чтобы с объектом
//такого типа можно было работать в блоке try-with-resources. Нужно бросить
//исключение, если работа с объектом типа счетчик была не в ресурсном try
//и/или ресурс остался открыт.Подумайте какой тип исключения подойдет
//лучше всего.

import java.io.IOException;

public class Task6 {
    public static void main(String[] args) {
        try (Task6Counter counter = new Task6Counter()) {
            counter.add();
            counter.add();
            counter.add();
            counter.add();
            counter.add();
            System.out.println(counter.getCounter());
            counter.close();
            System.out.println(counter.getCounter());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
