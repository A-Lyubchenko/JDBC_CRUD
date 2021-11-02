package ua.lyubchenko.commands;

import lombok.SneakyThrows;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

public class InformationConnection {
    private static InformationConnection instance;
    private final Properties properties;

    @SneakyThrows
    private InformationConnection() {
        this.properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/information.properties"));
    }

    public static Properties getInstance() {
        if (instance == null)
            instance = new InformationConnection();
        return instance.properties;
    }
}
