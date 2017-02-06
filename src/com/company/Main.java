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

    public static boolean containsSymbolsNumbers(String word) {

        if (!Pattern.matches("[a-zA-Z!.?',]+", word)) {
            return true;
        } else {
            return false;
        }
    }

    public static String findPunctuation(String word) {
        String punctuation = "";
        for (int i = word.length() - 1; i > 0; i--) {
            if (!Character.isLetter((word.charAt(i)))) {
                punctuation = word.charAt(i) + punctuation;
            } else {
                break;
            }
        }
        return punctuation;
    }

    public static boolean isFirstLetterUpper(String word) {
        if (Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        return false;
    }

    public static boolean isWordAllUpper(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase((word.charAt(i)))) {
                return false;
            }
        }
        return true;
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
        String punctuation = findPunctuation(word);
        StringBuilder latinWord = new StringBuilder();

        if (containsSymbolsNumbers(word)) {
            latinWord.append(word);
        } else if (startsWithVowel(word) || split == -1) {
            latinWord.append(word.substring(0, word.length() - punctuation.length())).append("way").append(punctuation);
        } else {
            latinWord.append(word.substring(split, word.length() - punctuation.length())).append(word.substring(0, split)).append("ay").append(punctuation);
        }

        String newWord = latinWord.toString();

        if (isWordAllUpper(word)) {
            newWord = newWord.toUpperCase();
        } else if (isFirstLetterUpper(word) && !startsWithVowel(word)) {
                newWord = newWord.substring(0, 1).toUpperCase() + newWord.substring(1);
                char c[] = newWord.toCharArray();
                int num = (word.length() - split - punctuation.length());
                c[num] = Character.toLowerCase(c[num]);
                newWord = new String(c);

        }

        return newWord;
    }


    public static void main(String[] args) {
        String input;
        String output;

        input = getUserInput("Enter a line of text:");

        String[] words = input.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            output = convertWord(words[i]);
            System.out.print(output + " ");
        }


    }


    // write your code here
}

