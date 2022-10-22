package ru.gamesphere;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import ru.gamesphere.modules.Module;

public class Main {
    public static void main(@NotNull String[] args) {
        final Injector injector = Guice.createInjector(new Module(args));
        injector.getInstance(Application.class).waitForInput();
    }
}
