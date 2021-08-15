package com.jwd5.Impl.console;

import com.jwd5.Impl.service.ServiceImpl;
import com.jwd5.Impl.source.InputProcessorImpl;
import com.jwd5.console.ConsoleDictionary;
import com.jwd5.service.Service;
import com.jwd5.source.InputProcessor;

public class ConsoleDictionaryImpl implements ConsoleDictionary {

    private final InputProcessor message = new InputProcessorImpl();
    private final Service service = new ServiceImpl();

    @Override
    public void start() {
        message.printWelcomeMessage();
        service.Quiz();
    }

}
