package com.jwd5.Impl.source;

import com.jwd5.source.InputProcessor;
import javafx.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputProcessorImpl implements InputProcessor {

    private final String WELCOME_MESSAGE = "This is an EN-RU Dictionary\n" +
            "It helps to learn EN words by Quiz\n" +
            "\t\tRULES\n" +
            "I'll show you 5 words and you must write the answer\n" +
            "If your answer will be wrong, you will see right answer\n" +
            "Good Luck!\n";

    private Scanner scanFile;

    public InputProcessorImpl(){
        try {
            File file = new File("src/main/java/com/jwd5/dictionary.txt");
            this.scanFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            printError(e.getMessage());
        }
    }

    @Override
    public List<Pair<String, String>> scan() {
        List<Pair<String, String>> dictionary = new ArrayList<>();
        Pattern pattern = Pattern.compile(" ");
        String[] words;
        String line;
        while(this.scanFile.hasNextLine()) {
            line = this.scanFile.nextLine();
            words = pattern.split(line);
            Pair<String, String> pair = new Pair<>(words[0], words[2]);
            dictionary.add(pair);
        }
        return dictionary;
    }

    @Override
    public void printDictionary(List<Pair<String, String>> dictionary) {
        System.out.println("\tEN\t\tRU");
        for (Pair<String, String> wordPair : dictionary) {
            System.out.println(wordPair.getKey() + " - " + wordPair.getValue());
        }
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    @Override
    public void printError(String s) {
        System.out.println("ERROR: " + s);
    }

    @Override
    public String waitAnswer() {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public void wrongAnswers(String wordPair) {
        System.out.println(wordPair);
    }
}
