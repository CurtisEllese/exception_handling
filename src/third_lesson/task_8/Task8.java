package third_lesson.task_8;
//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
// текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой
// именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
// и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
public class Task8 {
    public static void main(String[] args) {
//        String[][] myArr = new String[][] {{"123", "1"}, {"123", "1"}, {"123", "1"}};

        String[][] myArr = new String[][] {{"123", "1", "5", "6"}, {"dfs", "1", "5", "6"}, {"3", "1", "5", "6"}, {"8", "7", "5", "6"}};

        try {
            int sum = Array2DElementsSum(myArr);
            System.out.println(sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int Array2DElementsSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) throw new MyArraySizeException(array.length, array[0].length);

        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (isNumeric(array[i][j])) {
                    result += stringToInt(array[i][j]);
                } else { throw new MyArrayDataException(i, j); }
            }
        }

        return result;
    }

    public static boolean isNumeric(String string) {
        boolean isOnlyDigits = true;
        for(int i = 0; i < string.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(string.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        return isOnlyDigits;
    }

    public static int stringToInt(String string) {
        return Integer.parseInt(string);
    }
}
