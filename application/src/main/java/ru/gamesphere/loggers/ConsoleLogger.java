package ru.gamesphere.loggers;

import org.jetbrains.annotations.NotNull;

public class ConsoleLogger implements Logger {
    public void log(@NotNull String s, int counter) {
        System.out.println(counter + " " + s);
    }
}
