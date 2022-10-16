package ru.gamesphere.loggers;

import ru.gamesphere.annootations.LogTag;

import javax.inject.Inject;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private final FileWriter fileWriter;
    private final String tag;

    @Inject
    public FileLogger(FileWriter fileWriter, @LogTag String tag) {
        this.fileWriter = fileWriter;
        this.tag = tag;
    }

    public void log(String s, int counter) {
        String taggedS = String.format("%d <%s> %s </%s> \n", counter, tag, s, tag);

        try {
            fileWriter.write(taggedS);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
