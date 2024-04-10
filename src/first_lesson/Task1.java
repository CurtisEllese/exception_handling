package first_lesson;

//Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение. Метод ищет в массиве
// заданное значение и возвращает его индекс. При этом, например:
//если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
//если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//если вместо массива пришел null, метод вернет -3
//придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
//Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое число у
// пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю. Например,
// если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите минимальную длину массива: ");
        String enteredValue = sc.nextLine();
        int minLenght = turnStringToInt(enteredValue);
        System.out.println("Введите искомое число: ");
        enteredValue = sc.nextLine();
        int number = turnStringToInt(enteredValue);
        ArrayList<Integer> array = makeRndArr();
        printArray(array);

        int result = findIndex(array, number, minLenght);
        System.out.println(errorsHandle(result));
    }

    public static int findIndex(ArrayList<Integer> arr, int number, int minLength) {
        if (arr == null) return -3;
        if (arr.size() < minLength) return -1;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == number) return i;
        }

        return -2;
    }

    public static int turnStringToInt(String str) {
        if (str == null) return -1;
        return Integer.parseInt(str);
    }

    public static ArrayList<Integer> makeRndArr() {
        Random rnd = new Random();
        ArrayList<Integer> intList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            intList.add(rnd.nextInt(10));
        }

        return intList;
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (Integer i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static String errorsHandle(int errCode) {
        if (errCode == -3) return "Передан пустой массив";
        if (errCode == -1) return "Массив слишком маленький";
        if (errCode == -2) return "Искомое число не найдено";
        return "Номер индекса числа в массиве: " + Integer.toString(errCode);
    }
}
