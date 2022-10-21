package ru.gamesphere.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.jetbrains.annotations.NotNull;
import ru.gamesphere.annootations.*;
import ru.gamesphere.loggers.ConsoleFileLogger;
import ru.gamesphere.loggers.ConsoleLogger;
import ru.gamesphere.loggers.FileLogger;
import ru.gamesphere.loggers.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class Module extends AbstractModule {
    @NotNull
    private final String loggingType;

    @NotNull
    private final String logTag;

    public Module(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Number of args must be 2");
        }
        this.loggingType = args[0];
        this.logTag = args[1];
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(LoggingType.class).toInstance(loggingType);

        bind(String.class).annotatedWith(LogTag.class).toInstance(logTag);

        switch (loggingType) {
            case "C" -> bind(Logger.class).to(ConsoleLogger.class);
            case "F" -> bind(Logger.class).to(FileLogger.class);
            case "CF" -> bind(Logger.class).to(ConsoleFileLogger.class);
        }

        bind(FileWriter.class).toInstance(provideFileWriter());
    }

    FileWriter provideFileWriter() {
        try {
            return new FileWriter(System.getProperty("user.dir") + "/application/src/main/resources/log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
