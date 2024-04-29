package third_lesson.task_8;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("В ячейке: " + i + ";" + j + " найдены данные не числового формата!");
    }

    public MyArrayDataException() {
        super("В массиве присутствуют данные не числового формата");
    }
}
