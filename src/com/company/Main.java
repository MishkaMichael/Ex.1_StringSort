package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Эта программа сортирует строку по словам! \n      Введите строку из латинских символов");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Long start = System.currentTimeMillis();
        String sortedString = getSortString(s);
        System.out.println("Сортировка HashMap: \n" + sortedString);
        Long end = System.currentTimeMillis();
        System.out.println("Время работа программы: " + (end - start) + " ms");
    }


    public static String getSortString(String s) {
        String words [] = s.split("\\W+");
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
              }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        list.sort((Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> b.getValue() - a.getValue());

//        List<Map.Entry<String,Integer>> sortedList = map
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
//                .collect(Collectors.toList());
//         System.out.println(sortedList);

        return String.valueOf(list);     //builder.toString();
    }
}