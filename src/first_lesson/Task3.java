//Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
//Метод должен пройтись по каждому элементу и проверить что он не равен null.
//А теперь реализуйте следующую логику:
//Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
//Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

package first_lesson;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rnd = new Random();

        Integer[] array = new Integer[] {1, null, 321, null, null, null, 432, 3421, null, 3424, 1, 543, null, null};
        checkArray(array);
    }

    public static void checkArray(Integer[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) sb.append("Найдено значение null в индексе ").append(i).append("\n");
        }

        if (!sb.isEmpty()) {
            throw new RuntimeException(String.valueOf(sb));
        }
    }
}
