package ru.malychev.jstasks.collections;

import java.io.*;
import java.util.*;

public class CollectionTask {
    public static void main(String[] args) {
        try (BufferedReader fileIn = new BufferedReader(new InputStreamReader(new FileInputStream (
                "C:\\Users\\Admin\\IdeaProjects\\JavaSchool\\JS Tasks\\Collectoins\\src\\ru\\malychev\\jstasks\\collections\\Text.txt")))) {
            List<String> list = new ArrayList<>();
            for (String str; (str = fileIn.readLine()) != null; list.add(str));

            Map<String, Integer> map = uniqueWord(list);

            System.out.println("\nСодержимое оригинального файла.");
            System.out.println("================================================================");
            for (String str : list) System.out.println(str);
            System.out.println("================================================================\n");
            System.out.println("Перечень различных слов и количество их повторений.");
            System.out.println("================================================================");
            List<String> differentWord = new ArrayList<>();
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                System.out.println("Слово - \"" + pair.getKey() + "\" встречается " + pair.getValue() +
                                   " " + razy(pair.getValue()) + ".");
                differentWord.add(pair.getKey());
            }
            System.out.println("================================================================\n" +
                               "Всего различных слов: " + differentWord.size() + " штук.");

            differentWord.sort(new LengthStringComparator());
            System.out.println("\nСписок различных слов отсортированных по возрастанию их длин и алфавиту." +
                               "\n================================================================");
            for (String str : differentWord) System.out.println(str);

            Collections.sort(differentWord);
            System.out.println("\nСписок различных слов отсортированных в алфавитном порядке." +
                               "\n================================================================");
            for (String str : differentWord) System.out.println(str);

            System.out.println("================================================================\n\n" +
                               "Вывод строк файла в обратном порядке с использованием реверсивного итератора.\n" +
                               "================================================================");
            ReversReadList<String> rrList = new ReversReadList<>(list);
            for (String str : rrList) System.out.println(str);

            System.out.println("================================================================\n\n" +
                               "Вывод строк файла в произвольном порядке.\n" +
                               "================================================================");
            int[] index = {1, 5, 8, 0, 11, 3, 7, 4, 9, 2, 6, 10};
            for (int i : index) System.out.println("Строка номер " + (i + 1) + " : " + rrList.get(i));

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e);
        }

    }

    public static String razy(int num) {
        switch (num % 10) {
            case 2:
            case 3:
            case 4:
                return "раза";
            default:
                return "раз";
        }
    }

    public  static Map<String, Integer> uniqueWord(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : list) {
            str = str.toLowerCase().trim();
            do {
                int i;
                if ((i = str.indexOf(' ')) == -1 && !str.isEmpty()) {
                    if (map.containsKey(str)) map.put(str, map.get(str) + 1);
                    else map.put(str, 1);
                    break;
                } else {
                    String word = str.substring(0, i);
                    str = str.substring(i).trim();
                    if (map.containsKey(word)) map.put(word, map.get(word) + 1);
                    else map.put(word, 1);
                }
            } while (true);
        }
        return map;
    }
}
