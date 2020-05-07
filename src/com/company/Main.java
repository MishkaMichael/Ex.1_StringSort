package com.company;

import java.io.File;
import java.util.*;

public class Main {

    private static int n = 20;

    public static void main(String[] args) throws Exception {
        System.out.println("Эта программа сортирует файл по словам! \n");
        Long start = System.currentTimeMillis();

        // Чтение файла и создание строки
        Scanner in = new Scanner(new File("C:\\Users\\User\\Documents\\Java\\StringSort\\Text.txt"));
        StringBuilder builder = new StringBuilder();
        while (in.hasNext())   builder.append(in.nextLine());
        String s = builder.toString();

        String sortedString = getSortString(s,n);
        System.out.println(n + " наиболее часто встречающихся слов: \n" + sortedString);
        Long end = System.currentTimeMillis();
        System.out.println("\n Время работа программы: " + (end - start) + " ms");
    }

    public static String getSortString(String s, int n) {
        String words [] = s.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else if (!word.matches(".|..")) {   //убираем слова из одной и двух букв
                map.put(word, 1);
              }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        list.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> b.getValue() - a.getValue());

        return String.valueOf(list.subList(0,n));
    }
}