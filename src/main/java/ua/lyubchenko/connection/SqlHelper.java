package ua.lyubchenko.connection;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class SqlHelper implements ISqlHelper {
    @SneakyThrows
    @Override
    public int update(String sql, SettPrepare settPrepare) {
        Properties instance = ApplicationConnection.getInstance();
        try (Connection connection = DriverManager.getConnection(instance.getProperty("URL"), instance.getProperty("NAME"), instance.getProperty("PASSWORD"));
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            settPrepare.set(preparedStatement);
            return preparedStatement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public void query(String sql, SettPrepare settPrepare) {
        Properties instance = ApplicationConnection.getInstance();
        try (Connection connection = DriverManager.getConnection(instance.getProperty("URL"), instance.getProperty("NAME"), instance.getProperty("PASSWORD"));
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            settPrepare.set(preparedStatement);
            preparedStatement.executeQuery();
        }
    }
}
