package ua.lyubchenko.view;

import ua.lyubchenko.commands.EntityCommands;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityCommands entityCommands = new EntityCommands();
        while (scanner.hasNext()) {
            entityCommands.getMenu(scanner.nextLine());
        }
    }
}
