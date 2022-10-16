package ru.gamesphere.loggers;

public class ConsoleLogger implements Logger {
    public void log(String s, int counter) {
        System.out.println(counter + " " + s);
    }
}
