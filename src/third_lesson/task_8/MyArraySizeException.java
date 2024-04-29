package third_lesson.task_8;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int i, int j) {
        super("Размер массива некорректный: " + i + "x" + j);
    }

    public MyArraySizeException() {
        super("Размер массива некорректный");
    }
}
