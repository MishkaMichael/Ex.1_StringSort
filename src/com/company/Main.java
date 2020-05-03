package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Эта программа сортирует строку по словам! \n      Введите строку из латинских символов");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String sortedString = getSortString(s);
        System.out.println("Сортировка HashMap: \n" + sortedString);
    }


    public static String getSortString(String s) {
        String words [] = s.split("\\W+");
        //  StringBuilder builder = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
                    int count = 0;
                    String currentWord = words[i];
                    for (String word : words) {
                        if (currentWord.equals(word)) {
                            count += 1;
                        }
                    }
                    map.put(currentWord, count);
                    //  builder.append( currentWord + " " + count + ";");
        }
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            @Override
                    public int compare (Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        Collections.reverse(list);

        /*map.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue());
         System.out.println(map);
        */

        return String.valueOf(list);     //builder.toString();
    }
}