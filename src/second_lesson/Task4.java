// Запишите в файл следующие строки:
//Анна=4
//Елена=5
//Марина=6
//Владимир=?
//Константин=?
//Иван=4
//Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
//студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
//значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от
//числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?

package second_lesson;

import java.io.*;
import java.util.HashMap;

public class Task4 {
    public static void main(String[] args) {
        String path = "src/second_lesson/task4.txt";

        HashMap<String, String> fileContent = readFileToHashMap(path);
        checkHashMapContent(fileContent);
        writeNewDataInFile(fileContent, path);

    }

    public static HashMap<String, String> readFileToHashMap(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            HashMap<String, String> result = new HashMap<>();

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] keyVal = line.split("=");

                if (keyVal.length == 2) result.put(keyVal[0], keyVal[1]);
                else System.out.println("Найдена невалидная строка: " + line + "\nОна не будет добавлена в массив!");
            }

            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Возникла ошибка при чтении файла " + e.getMessage());
        }
        return null;
    }

    public static void checkHashMapContent(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) throw new RuntimeException("Массив данных или файл пустой!");

        for (var keyVal : hashMap.entrySet()) {
            if (!keyVal.getValue(). matches("\\d+") && !keyVal.getValue().equals("?")) {
                throw new IllegalArgumentException("Строка с ключом " + keyVal.getKey() + " содержит инородное значение. " +
                        "Удалите или измените эту строку в файле");
            } else if (keyVal.getValue().equals("?")) hashMap.put(keyVal.getKey(), Integer.toString(keyVal.getKey().length()));
        }
    }

    public static void writeNewDataInFile(HashMap<String, String> data, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (var keyVal : data.entrySet()) {
                bw.write(keyVal.getKey() + "=" + keyVal.getValue() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Возникла ошибка при чтении файла " + e.getMessage());
        }
    }
}
