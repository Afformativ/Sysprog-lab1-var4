package com.max.idea;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Scanner userPathInput = new Scanner(System.in);
        Scanner inputFile = null;
        String filePath;
        String nextLine;
        try {
            System.out.println("Enter path for the input file: ");
            filePath = userPathInput.nextLine();
            userPathInput.close();
            inputFile = new Scanner(Paths.get(filePath));
            while (inputFile.hasNext()) {
                nextLine = inputFile.nextLine();
                if(nextLine.isEmpty()) {
                    nextLine = " ";
                }
                List<String> wordsInLine = Arrays.asList(nextLine.split("[^a-zA-ZА-Яа-яЮюЄєІіҐґЇї]", 0));
                for (String word : wordsInLine) {
                    String current = word;
                    current = current.trim().toLowerCase();
                    if (current.length() > 30) {
                        current = current.substring(0, 30);
                    }
                    Boolean corect = true;
                    if (words.contains(current) || current.isEmpty()) {
                        corect = false;
                    }
                    for (int i = 0; i < current.length() - 1; i++) {
                        char first = current.charAt(i);
                        for (int j = i + 1; j < current.length(); j++) {
                            if (first == current.charAt(j)) {
                                corect = false;
                            }
                        }
                    }
                    if (corect) {
                        words.add(current);
                    }
                }
            }
            for(String word : words){
                System.out.print(word + " ");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }
        finally {
            inputFile.close();
        }
    }
}
