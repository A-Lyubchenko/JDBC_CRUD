package ua.lyubchenko.commands.entityCommands;

import ua.lyubchenko.commands.Commands;
import ua.lyubchenko.domains.Developer;
import ua.lyubchenko.repositories.entityRepositories.DeveloperRepository;
import java.util.List;


public class DeveloperCommand extends Commands {
    private final String WORD1 = "Если вы выберите ";
    private final String WORD2 = " - вам нужно ввести через пробел ";
    private final String WORD3 = "Например: ";
    private final Developer developer = new Developer();
    private final DeveloperRepository developerRepository = new DeveloperRepository();
    private final List<String> commands = List.of("\"create\", \"read\", \"update\", \"delete\", \"get\", \"count\"");


    public void update(String newParams) {
        String[] split = newParams.split(" ");
        developer.setName(split[0] + " " + split[1] + " " + split[2]);
        developer.setAge(Integer.parseInt(split[3]));
        developer.setSex(split[4]);
        developer.setPhone_number(split[5]);
        developer.setSalary(Integer.parseInt(split[6]));
        developer.setId(Integer.parseInt(split[7]));
        developerRepository.update(developer);
    }

    public void create(String newParams) {
        String[] split = newParams.split(" ");
        developer.setId(Integer.parseInt(split[0]));
        developer.setName(split[1] + " " + split[2] + " " + split[3]);
        developer.setAge(Integer.parseInt(split[4]));
        developer.setSex(split[5]);
        developer.setPhone_number(split[6]);
        developer.setSalary(Integer.parseInt(split[7]));
        developerRepository.create(developer);
    }

    public void delete(String param) {
        String[] words = param.split(" ");
        developerRepository.delete(Integer.parseInt(words[0]));
    }

    @Override
    public void printInstruction() {
        System.out.println("^--------- DEVELOPERS MENU ---------^");
        System.out.println("COMMAND: " + commands);
        System.out.println("ИНСТРУКЦИЯ ПО ВЫБОРУ КОМАНД:\n" + WORD1 + "\"create\"" + WORD2 + "(id name age sex phone_number salary). " +
                "" + WORD3 + "create 10 Гуськов Ф. Ф. 20 male 9999999999 4000\n" + WORD1 + "\"read\" - ничего вводить не нужно, выводится список сотрудников хранящихся в БД.\n" +
                "" + WORD1 + "\"update\"" + WORD2 + "(name age sex phone_number salary id). " +
                "" + WORD3 + "update Гуськов Ф. Ф. 20 male 9999999999 4000 10\n" + WORD1 + "\"delete\" - вам нужно вести (id). " +
                "" + WORD3 + "delete 10\n" + WORD1 + "\"get\" - вам нужно ввести (id). " +
                "" + WORD3 + "get 10\n" + WORD1 + "\"count\" - ничего вводить не нужно, выводится количество сотрудников работающих над проектами, хранящихся в БД.");
    }

    public void read() {
        List<Developer> read = developerRepository.read();
        read.forEach(System.out::println);
    }
}
