// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//Необходимо посчитать и вернуть сумму элементов этого массива.
//При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
//(кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
//Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.


package first_lesson;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();

        //create random array

        int[][] array2D = new int[rnd.nextInt(10)][rnd.nextInt(10)];

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = rnd.nextInt(10);
            }
        }
//        printInt2DArr(array2D);

        //create binary quadratic array

        int[][] array2DBinary = new int[10][10];

        for (int i = 0; i < array2DBinary.length; i++) {
            for (int j = 0; j < array2DBinary[i].length; j++) {
                array2DBinary[i][j] = rnd.nextInt(2);
            }
        }
//        printInt2DArr(array2DBinary);

        //create binary random length array

        int[][] array2DBinRndLen = new int[rnd.nextInt(10)][rnd.nextInt(10)];

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                array2D[i][j] = rnd.nextInt(2);
            }
        }
//        printInt2DArr(array2DBinRndLen);


//        int rndArrResult = sumElements2DArray(array2D);
//        System.out.println(rndArrResult);

        int trueArrResult = sumElements2DArray(array2DBinary);
        System.out.println(trueArrResult);

//        int rndBinArrResult = sumElements2DArray(array2DBinRndLen);
//        System.out.println(rndBinArrResult);

    }

    public static int sumElements2DArray(int[][] array2D) {
        if (array2D.length != array2D[0].length) throw new RuntimeException("Для работы программы нужен двумерный массив!");

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (array2D[i][j] != 0 && array2D[i][j] != 1) throw new RuntimeException("Для работы программы массив должен быть бинарный!");
            }
        }

        int result = 0;

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                result += array2D[i][j];
            }
        }

        return result;
    }

    public static void printInt2DArr(int[][] arr2D) {
        for (int[] ints : arr2D) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
