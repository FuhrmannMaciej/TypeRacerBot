package com.company;

import java.io.BufferedReader;
import java.util.Scanner;

public class TextReader {
    Scanner scanner = new Scanner(System.in);
    private String text;

    public char[] getText() {
        System.out.println("Copy or write your text: ");
        text = scanner.nextLine();
        char[] textArray = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            textArray[i] = text.charAt(i);
        }
        return textArray;
    }

}

