package ru.gamesphere.loggers;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class ConsoleFileLogger implements Logger {
    @NotNull
    private final ConsoleLogger consoleLogger;

    @NotNull
    private final FileLogger fileLogger;

    @Inject
    public ConsoleFileLogger(@NotNull ConsoleLogger consoleLogger, @NotNull FileLogger fileLogger) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
    }

    @Override
    public void log(@NotNull String s, int counter) {
        consoleLogger.log(s, counter++);
        fileLogger.log(s, counter);
    }
}
