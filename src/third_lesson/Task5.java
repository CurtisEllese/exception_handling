package third_lesson;
// Создайте метод doSomething(), который может быть источником одного из
// типов checked exceptions (тело самого метода прописывать не обязательно).
// Вызовите этот метод из main и обработайте в нем исключение, которое
// вызвалметод doSomething().

import java.io.FileNotFoundException;

public class Task5 {
    public static void main(String[] args) {
        try {
            doSomething("src");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void doSomething(String path) throws FileNotFoundException {
    }
}
