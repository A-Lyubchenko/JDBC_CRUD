package ua.lyubchenko.commands;

import java.util.regex.Matcher;

import static ua.lyubchenko.commands.ICommands.pattern;

public class EntityCommands {
    private final ICommands iCommands = new TableMenu();
    private ICommands activeCommand = iCommands;

    public EntityCommands() {
        System.out.println("Введите \"start\" для работы с приложением, \"finish\" - для выхода из приложения, \"main\" - вернуться чтобы выбрать таблицу.");
    }

    public void getMenu(String params){
        Matcher matcher = pattern.matcher(params);
        if (matcher.find()){
            String firstWord = matcher.group();
            if ("exit".equalsIgnoreCase(firstWord)){
                System.exit(0);
            }else if("start".equalsIgnoreCase(firstWord)){
                activeCommand = iCommands;
                activeCommand.printInstruction();
            }else if("main".equalsIgnoreCase(firstWord)){
                activeCommand = iCommands;
                activeCommand.printInstruction();
            }else {

                activeCommand.handle(params,iCommands1 -> {
                    activeCommand = iCommands1;
                    activeCommand.printInstruction();
                });
            }
        }else {
            System.out.println("UNKNOWN COMMAND");
        }
    }
}
