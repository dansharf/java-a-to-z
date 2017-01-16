package ru.job4j.lesson5;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class ConsoleChatTest {

    /**
     * Тест консьльного чата.
     *
     * @throws IOException Ошибка ввода вывода.
     */
    @Test
    public void runChat() throws IOException {
        final Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream(new File("app.properties"))));
        final String[] test = new String[]{"Hi", "стоп", "Ответь", "Продолжить", "Закончить"};
        final StubInput stubInput = new StubInput(test);
        final File in = new File(prop.getProperty("pathIn"));
        final File out = new File(prop.getProperty("pathOut"));
        final ConsoleChat consoleChat = new ConsoleChat(in, out, stubInput);
        consoleChat.runChat();
        final List<String> expected = Arrays.asList("hi", "Привет", "стоп", "ответь", "продолжить", "Привет", "Закончить");
        final List<String> actual = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(out)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actual.add(line);
            }
        }
        assertThat(actual, is(expected));
    }

    /**
     * Тест броска исключения если фаил не найден.
     * @throws IOException ошибка ввода вывода.
     */
    @Test(expected = IOException.class)
    public void chatException() throws IOException {
        final Properties prop = new Properties();
        prop.load(new InputStreamReader(new FileInputStream(new File("../app.properties"))));
        final String[] test = new String[]{"Hi", "стоп", "Ответь", "Продолжить", "Закончить"};
        final StubInput stubInput = new StubInput(test);
        final File in = new File("empty");
        final File out = new File(prop.getProperty("pathOut"));
        final ConsoleChat consoleChat = new ConsoleChat(in, out, stubInput);
        consoleChat.runChat();
    }
}