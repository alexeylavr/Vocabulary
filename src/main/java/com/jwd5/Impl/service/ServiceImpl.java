package com.jwd5.Impl.service;

import com.jwd5.Impl.entity.DaoImpl;
import com.jwd5.Impl.source.InputProcessorImpl;
import com.jwd5.entity.Dao;
import com.jwd5.service.Service;
import com.jwd5.source.InputProcessor;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceImpl implements Service {

    private InputProcessor message = new InputProcessorImpl();
    private Dao dictionary = new DaoImpl();
    private final String WRONG_ANSWERS_LINE = "WRONG ANSWER!!!\t Correct: ";
    private final String ALL_RIGHT = "All answers are correct!!!";

    @Override
    public Boolean hasWord(String word) {
        for (int i = 0; i < dictionary.numOfWords(); i++) {
            if (dictionary.getElement(i).getKey().equals(word)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String findEnWord(String word) {
        for (int i = 0; i < dictionary.numOfWords(); i++) {
            if (dictionary.getElement(i).getKey().equals(word)) {
                return dictionary.getElement(i).getValue();
            }
        }
        message.printError("We don't have the word " + word + " in our dictionary");
        return null;
    }

    @Override
    public void printNumOfWords() {
        System.out.println("We have " + dictionary.numOfWords() + " words in our dictionary");
    }

    @Override
    public void printWords() {
        message.printDictionary(dictionary.getDictionary());
    }

    @Override
    public void Quiz() {
        printQuiz();
    }

    @Override
    public void printQuiz() {
        List<Pair<String, String>> quiz = dictionary.getDictionary();
        Random random = new Random();
        List<Pair<String, String>> wordPairs = new ArrayList<>();
        String[] answers = new String[5];
        Integer randomInt;
        for (int i = 0; i < 5; i++) {
            randomInt = random.nextInt(quiz.size());
            System.out.print(quiz.get(randomInt).getKey() + " - ");
            wordPairs.add(quiz.get(randomInt));
            answers[i] = message.waitAnswer();
        }
        Integer count = new Integer(5);
        String answer = "";
        for (int i = 0; i < 5; i++) {
            if (!answers[i].equals(wordPairs.get(i).getValue())){
                answer += WRONG_ANSWERS_LINE + wordPairs.get(i).getKey() + " - " + wordPairs.get(i).getValue() + "\n";
                count--;
            }
        }
        if (answer.equals("")){
            answer = ALL_RIGHT;
        }
        message.wrongAnswers(answer);

    }

}
