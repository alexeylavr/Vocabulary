package com.jwd5.source;

import javafx.util.Pair;

import java.util.List;

public interface InputProcessor {

    void printError(String s);
    List<Pair<String, String>> scan();
    void printDictionary(List<Pair<String, String>> dictionary);
    void printWelcomeMessage();
    String waitAnswer();
    void wrongAnswers(String wordPair);

}
