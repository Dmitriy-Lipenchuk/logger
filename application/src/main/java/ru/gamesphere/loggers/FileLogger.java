package ru.gamesphere.loggers;

import org.jetbrains.annotations.NotNull;
import ru.gamesphere.annootations.LogTag;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    @NotNull
    private final FileWriter fileWriter;

    @NotNull
    private final String tag;

    @Inject
    public FileLogger(@NotNull FileWriter fileWriter, @NotNull @LogTag String tag) {
        this.fileWriter = fileWriter;
        this.tag = tag;
    }

    public void log(@NotNull String s, int counter) {
        String taggedS = String.format("%d <%s> %s </%s> \n", counter, tag, s, tag);

        try {
            fileWriter.write(taggedS);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
