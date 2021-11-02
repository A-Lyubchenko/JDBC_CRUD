package ua.lyubchenko.commands.entityCommands;

import ua.lyubchenko.commands.Commands;
import ua.lyubchenko.domains.Skill;
import ua.lyubchenko.repositories.entityRepositories.SkillRepository;

import java.util.List;
import java.util.Optional;

public class SkillCommand extends Commands {
    private final String WORD1 = "Если вы выберите ";
    private final String WORD2 = " - вам нужно ввести через пробел ";
    private final String WORD3 = "Например: ";
    private final Skill skill = new Skill();
    private final SkillRepository skillRepository = new SkillRepository();
    private final List<String> commands = List.of("\"create\", \"read\", \"update\", \"delete\", \"get\", \"java\", \"middle\"");


    public void update(String param) {
        String[] words = param.split(" ");
        skill.setDepartment(words[0]);
        skill.setLevel(words[1]);
        skill.setId(Integer.parseInt(words[2]));
        skillRepository.update(skill);
    }

    public void create(String param) {
        String[] words = param.split(" ");
        skill.setId(Integer.parseInt(words[0]));
        skill.setDepartment(words[1]);
        skill.setLevel(words[2]);
        skillRepository.create(skill);
    }

    public void delete(String param) {
        String[] words = param.split(" ");
        skillRepository.delete(Integer.parseInt(words[0]));
    }

    @Override
    public void printInstruction() {
        System.out.println("^--------- SKILLS MENU ---------^");
        System.out.println("COMMAND: " + commands);
        System.out.println("ИНСТРУКЦИЯ ПО ВЫБОРУ КОМАНД:\n" + WORD1 + "\"create\"" + WORD2 + "(id department level). " +
                "" + WORD3 + "create 10 JS Senior\nЕсли вы выберите \"read\" - ничего вводить не нужно, выводится список скилов хранящихся в БД.\n" +
                "" + WORD1 + "\"update\"" + WORD2 + "(department level id). " +
                "" + WORD3 + "update JS Senior 10\n" + WORD1 + "\"delete\" - вам нужно вести (id). " +
                "" + WORD3 + "delete 10\n" + WORD1 + "\"get\" - вам нужно ввести (id). " +
                "" + WORD3 + "get 10\n" + WORD1 + "\"java\" - ничего вводить не нужно, выводится список сотрудников владеющих языком \"Java\", хранящихся в БД.\n" +
                ""+WORD1+"\"middle\" - ничего вводить не нужно, выводится список сотрудников уровня \"middle\", хранящихся в БД.");
    }

    public void read() {
        List<Skill> read = skillRepository.read();
        read.forEach(System.out::println);
    }
}
