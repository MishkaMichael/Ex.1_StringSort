package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Эта программа сортирует строку по словам! \n      Введите строку");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String sortedString1 = getSortMassiv(s);
        //String sortedString2 = getSortHashmap(s);
        System.out.println("Сортировка массивом: \n" + sortedString1);
        //System.out.println("Сортировка с помощью HashMap: \n" + sortedString2);
    }


    public static String getSortMassiv(String s) {
        String words [] = s.split("\\W+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
                    int count = 0;
                    String currentWord = words[i];
                    for (String word : words) {
                        if (currentWord.equals(word)) {
                            count += 1;
                        }
                    }
                    //System.out.println( currentWord + " " + count + ";" );
                    builder.append( currentWord + " " + count + ";");
        }
        return builder.toString();
    }

    public String getSortHashmap(String s) {

        return s;
    }
}