package ua.lyubchenko.commands;

import java.util.List;

public interface ICommandsCrud {
    void create(String param);

    void read();

    void update(String param);

    void delete(String param);
}

