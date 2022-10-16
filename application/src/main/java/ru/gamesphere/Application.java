package ru.gamesphere;

import ru.gamesphere.annootations.ConsoleLog;
import ru.gamesphere.annootations.FileLog;
import ru.gamesphere.annootations.LoggingType;
import ru.gamesphere.loggers.Logger;

import javax.inject.Inject;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    private boolean CONSOLE_LOG_ENABLED = false;
    private boolean FILE_LOG_ENABLED = false;

    private int counter = 0;
    private final String loggingType;
    private final Logger consoleLogger;
    private final Logger fileLogger;

    @Inject
    public Application(@ConsoleLog Logger consoleLogger, @FileLog Logger fileLogger, @LoggingType String loggingType) {
        this.consoleLogger = consoleLogger;
        this.fileLogger = fileLogger;
        this.loggingType = loggingType;
    }

    public void waitForInput() {
        setLoggingType(loggingType);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String s = scanner.nextLine();

                if (CONSOLE_LOG_ENABLED) consoleLogger.log(s, counter++);
                if (FILE_LOG_ENABLED) fileLogger.log(s, counter++);
            }
        } catch (IllegalStateException | NoSuchElementException ignored) {
        }
    }

    private void setLoggingType(String s) {
        switch (s) {
            case "C" -> CONSOLE_LOG_ENABLED = true;
            case "F" -> FILE_LOG_ENABLED = true;
            case "CF" -> {
                CONSOLE_LOG_ENABLED = true;
                FILE_LOG_ENABLED = true;
            }
        }
    }
}
