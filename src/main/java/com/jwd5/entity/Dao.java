package com.jwd5.entity;

import javafx.util.Pair;

import java.util.List;

public interface Dao {

    List<Pair<String, String>> getDictionary();
    Pair<String, String> getElement(int elementNumber);
    void setElement(Pair<String,String> wordPair);
    Integer numOfWords();

}
