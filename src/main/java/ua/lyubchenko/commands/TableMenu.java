package ua.lyubchenko.commands;

import lombok.SneakyThrows;
import ua.lyubchenko.commands.entityCommands.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Consumer;

public class TableMenu implements ICommands {

    private final Map<String, ICommands> iCommandsMap = Map.of(
            "companies", new CompanyCommand(),
            "customers", new CustomerCommand(),
            "developers", new DeveloperCommand(),
            "projects", new ProjectCommand(),
            "skills", new SkillCommand()
    );


    @Override
    public void handle(String param, Consumer<ICommands> iCommandsConsumer) {
        Optional<String> firstWorld = getFirstWorld(param);
        firstWorld.map(iCommandsMap::get).ifPresent(iCommands -> {
            iCommandsConsumer.accept(iCommands);
            iCommands.handle(param.replace(firstWorld.get().trim(), ""), iCommandsConsumer);
        });
    }

    @SneakyThrows
    @Override
    public void printInstruction() {
        System.out.println("---------- MAIN MENU ----------");
        System.out.println("REPOSITORIES: " + this.iCommandsMap.keySet());
        System.out.println("Если вы хотите узнать сумму денег(всех сотрудников работающих) по определенному проекту, выберите таблицу - projects");
        System.out.println("Если вы хотите узнать список сотрудников работающих по определенному проекту, выберите таблицу - projects");
        System.out.println("Если вы хотите узнать список сотрудников владеющих языком програмирования \"Java\", выберите таблицу - skills");
        System.out.println("Если вы хотите узнать список сотрудников уровня \"Middle\", выберите таблицу - skills");
        System.out.println("Если вы хотите узнать количество сотрудников работающих на всех проектах из таблицы, выберите таблицу - developers");
    }
}
