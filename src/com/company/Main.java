package com.company;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    private static int n = 20;

    public static void main(String[] args) throws IOException {
        System.out.println("Эта программа сортирует файл по словам! \n");

        // Окно выбора файла
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();

            // Чтение файла и создание строки
            Long start = System.currentTimeMillis();
            Scanner in = new Scanner(file);
            StringBuilder builder = new StringBuilder();
            while (in.hasNext()) builder.append(in.nextLine());
            String s = builder.toString();

            String sortedString = getSortString(s, n);
            System.out.println(n + " наиболее часто встречающихся слов: \n" + sortedString);
            Long end = System.currentTimeMillis();
            System.out.println("\n Время работа программы: " + (end - start) + " ms");
        }
    }

    public static String getSortString(String s, int n) {
        int count = 0;
        String words [] = s.split("\\s+|\\, |\\. ");
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            count ++;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else if (!word.matches(".|..")) {   //убираем слова из одной и двух букв
                map.put(word, 1);
              }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        list.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> b.getValue() - a.getValue());
        System.out.println("Число слов в тексте = " + count);
        if (list.size() > n) return String.valueOf(list.subList(0,n));
        else return String.valueOf(list);
    }
}