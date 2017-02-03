package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    public static String getUserInput (String prompt) {
        String input = null;

        System.out.println(prompt);
        input = scnr.nextLine();

        /*while(input.isEmpty()) {
            System.out.println(prompt);
            input = scnr.nextLine();
            }
            */

        return input;
    }

    public static boolean startsWithVowel (String word) {
        return "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
    }

    public static int indexOfVowel (String word) {
        int index = -1;
        for (int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            if ("AEIOUaeiou".indexOf(word.charAt(i)) != -1) {
                return word.indexOf(c);
            }
        }
        return index;
    }

    public static String convertWord (String word) {
        int split = indexOfVowel(word);
        StringBuilder latinWord = new StringBuilder();

        if(startsWithVowel(word)) {
            latinWord.append(word).append("way ");
        }
        else {
            latinWord.append(word.substring(split)).append(word.substring(0, split)).append("ay ");
        }
        return latinWord.toString();
    }

    public static void main(String[] args) {
        String input;
        String output;

        input = getUserInput("Enter a line of text:");

        input = input.toLowerCase();
        System.out.println(startsWithVowel(input));
        String[] words = input.split(" ");


        for (int i=0; i < words.length; i++){
            output = convertWord(words[i]);
            System.out.print(output);
        }



        }






        // write your code here
    }

