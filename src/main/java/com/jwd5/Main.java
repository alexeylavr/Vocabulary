package com.jwd5;

import com.jwd5.console.ConsoleDictionary;
import com.jwd5.Impl.console.ConsoleDictionaryImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleDictionary app = new ConsoleDictionaryImpl();
        app.start();
    }
}
