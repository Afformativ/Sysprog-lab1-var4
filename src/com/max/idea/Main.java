package com.max.idea;
import java.io.IOException;
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
                    word = word.toLowerCase();
                    if (word.length() > 30) {
                        word = word.substring(0, 30);
                    }
                    Boolean correct = true;
                    if (words.contains(word) || word.isEmpty()) {
                        correct = false;
                    }
                    for (int i = 0; i < word.length() - 1; i++) {
                        char first = word.charAt(i);
                        for (int j = i + 1; j < word.length(); j++) {
                            if (first == word.charAt(j)) {
                                correct = false;
                            }
                        }
                    }
                    if (correct) {
                        words.add(word);
                    }
                }
            }
            for(String Finalword : words){
                System.out.print(Finalword + " \n ");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e){
            //e.printStackTrace();
            System.out.println("Something wrong\n");
        }
    }
}
