package ru.gamesphere;

import org.jetbrains.annotations.NotNull;
import ru.gamesphere.annootations.LoggingType;
import ru.gamesphere.loggers.Logger;

import javax.inject.Inject;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    private int counter = 0;

    @NotNull
    private final String loggingType;

    @NotNull
    private final Logger logger;

    @Inject
    public Application(@NotNull Logger logger, @NotNull @LoggingType String loggingType) {
        this.logger = logger;
        this.loggingType = loggingType;
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String s = scanner.nextLine();

                logger.log(s, counter++);

                if (loggingType.equals("CF")) counter++;
            }
        } catch (IllegalStateException | NoSuchElementException ignored) {
        }
    }
}
