package ru.gamesphere.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import ru.gamesphere.annootations.*;
import ru.gamesphere.loggers.ConsoleLogger;
import ru.gamesphere.loggers.FileLogger;
import ru.gamesphere.loggers.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class Module extends AbstractModule {

    private final String[] args;

    public Module(String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        bind(Logger.class).annotatedWith(ConsoleLog.class).to(ConsoleLogger.class);

        bind(Logger.class).annotatedWith(FileLog.class).to(FileLogger.class);

        bind(String.class).annotatedWith(LoggingType.class).toInstance(args[0]);

        bind(String.class).annotatedWith(LogTag.class).toInstance(args[1]);
    }

    @Provides
    FileWriter provideFileWriter() {
        try {
            return new FileWriter("application/src/main/resources/log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
