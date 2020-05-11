package com.company;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private static int n = 30;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Эта программа сортирует файл по словам! \n");
        String s = getFileAsString ();
        Long start = System.currentTimeMillis();
        String [] words = getWordsFromString (s);
        HashMap<String, Integer> map = getWordCountMap (words);
        String result = formatResultMapToString (map);
        System.out.println(n + " наиболее часто встречающихся слов: \n" + result);
        Long end = System.currentTimeMillis();
        System.out.println("\n Время работа программы: " + (end - start) + " ms");
    }

    public static String getFileAsString () throws FileNotFoundException {
        //Окно выбора файла
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        String s = new String();
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            // Чтение файла и создание строки
            Scanner in = new Scanner(file);
            StringBuilder builder = new StringBuilder();
            while (in.hasNext()) builder.append(in.nextLine());
            s = builder.toString();
        }
        return s;
    }

    public static String[] getWordsFromString (String s) {
            String[] words = s.split("[\\s,\\.]+");
            return words;
    }

    private static HashMap<String, Integer> getWordCountMap(String[] words) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            count++;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
//            } else if (word.length() > 2) {   //убираем слова из одной и двух букв
            } else if (word.matches("(?U)\\p{Lu}\\w+")) {  // Выборка только слов с большой буквы
                map.put(word, 1);
            }
        }
        System.out.println("Число слов в тексте = " + count);
        return map;
    }

    private static String formatResultMapToString(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        list.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> b.getValue() - a.getValue());
        if (list.size() > n) return String.valueOf(list.subList(0, n));
        else return String.valueOf(list);
    }
}