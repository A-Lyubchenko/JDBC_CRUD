package ua.lyubchenko.connection;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationConnection {
    private static ApplicationConnection instance;
    private final Properties properties;

    @SneakyThrows
    private ApplicationConnection() {
        this.properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/application.properties"));
    }

    public static Properties getInstance() {
        if (instance == null)
            instance = new ApplicationConnection();
        return instance.properties;
    }
}
