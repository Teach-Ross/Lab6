package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Scanner scnr = new Scanner(System.in);

    public static String getUserInput(String prompt) {
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

    public static boolean startsWithVowel(String word) {
        return "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
    }

    //excludes aposrophes (it doesn't yet)
    public static boolean containsSymbolsNumbers(String word) {

        if (!Pattern.matches("[a-zA-Z]+", word)) {
            return true;
        }else{
            return false;
        }
    }

    public static int indexOfVowel(String word) {
        int index = -1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ("AEIOUaeiou".indexOf(word.charAt(i)) != -1) {
                return word.indexOf(c);
            }
        }
        return index;
    }

    public static String convertWord(String word) {
        int split = indexOfVowel(word);
        StringBuilder latinWord = new StringBuilder();

        if (startsWithVowel(word)) {
            latinWord.append(word).append("way ");
        } else if (containsSymbolsNumbers(word) || split == -1) {
            latinWord.append(word).append(" ");
        } else {
            latinWord.append(word.substring(split)).append(word.substring(0, split)).append("ay ");
        }
        return latinWord.toString();
    }

    public static void main(String[] args) {
        String input;
        String output;

        input = getUserInput("Enter a line of text:");

        input = input.toLowerCase();

        String[] words = input.split("\\s+");


        for (int i = 0; i < words.length; i++) {
            output = convertWord(words[i]);
            System.out.print(output);
        }


    }


    // write your code here
}

