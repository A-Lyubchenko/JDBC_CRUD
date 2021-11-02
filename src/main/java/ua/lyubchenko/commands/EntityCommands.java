package ua.lyubchenko.commands;

import java.util.Optional;
import java.util.regex.Matcher;

import static ua.lyubchenko.commands.ICommands.pattern;

public class EntityCommands {
    private final ICommands iCommands = new TableMenu();
    private ICommands activeCommand = iCommands;

    public EntityCommands() {
        System.out.println("Введите \"start\" для работы с приложением, \"finish\" - для выхода из приложения, \"main\" - вернуться чтобы выбрать таблицу.");
    }

    public void getMenu(String params) {
        Matcher matcher = pattern.matcher(params);
        if (matcher.find()) {
            String firstWord = matcher.group();
            switch (firstWord) {
                case "exit":
                    System.exit(0);
                    return;
                case "start":
                    activeCommand = iCommands;
                    activeCommand.printInstruction();
                    return;
                case "main":
                    activeCommand = iCommands;
                    activeCommand.printInstruction();
                default:
                    activeCommand.handle(params, iCommands1 -> {
                        activeCommand = iCommands1;
                        activeCommand.printInstruction();
                    });
            }
        } else {
            System.out.println("UNKNOWN COMMAND");
        }
    }
}
