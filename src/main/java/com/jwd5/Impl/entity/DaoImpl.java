package com.jwd5.Impl.entity;

import com.jwd5.Impl.source.InputProcessorImpl;
import com.jwd5.entity.Dao;
import com.jwd5.source.InputProcessor;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    private InputProcessor message = new InputProcessorImpl();
    private List<Pair<String, String>> dictionary;

    public DaoImpl() {
        this.dictionary = new ArrayList<>(10);
        this.dictionary = message.scan();
    }

    @Override
    public List<Pair<String, String>> getDictionary() {
        return this.dictionary;
    }

    @Override
    public Pair<String, String> getElement(int elementNumber){
        return this.dictionary.get(elementNumber);
    }

    @Override
    public void setElement(Pair<String,String> wordPair) {
        if (findWord(wordPair)){
            this.dictionary.add(wordPair);
        } else{
            message.printError("We have this word in our dictionary, we will rewrite it now");
            for (int i = 0; i < this.dictionary.size(); i++) {
                if (this.dictionary.get(i).getKey().equals(wordPair.getKey())) {
                    this.dictionary.set(i, wordPair);
                }
            }
        }
    }

    @Override
    public Integer numOfWords() {
        return this.dictionary.size();
    }

    private boolean findWord(Pair<String, String> wordPair){
        for (Pair<String,String> word : this.dictionary) {
            if (word.getKey().equals(wordPair.getKey()) || word.getValue().equals(wordPair.getValue())){
                return false;
            }
        }
        return true;
    }

}
