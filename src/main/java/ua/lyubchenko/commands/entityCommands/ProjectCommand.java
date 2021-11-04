package ua.lyubchenko.commands.entityCommands;

import ua.lyubchenko.commands.Commands;
import ua.lyubchenko.domains.Project;
import ua.lyubchenko.repositories.entityRepositories.ProjectRepository;
import java.util.List;


public class ProjectCommand extends Commands {
    private final String WORD1 = "Если вы выберите ";
    private final String WORD2 = " - вам нужно ввести через пробел ";
    private final String WORD3 = "Например: ";
    private final Project project = new Project();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final List<String> commands = List.of("\"create\", \"read\", \"update\", \"delete\", \"get\", \"sum\", \"list\"");


    @Override
    public Integer getMaxId() {
        return projectRepository.getMaxId();

    }
    public void update(String param) {
        String[] words = param.split(" ");
        project.setName(words[0]);
        project.setStart(words[1]);
        project.setCoast(Integer.parseInt(words[2]));
        project.setId(Integer.parseInt(words[3]));
        projectRepository.update(project);
    }

    public void create(String param) {
        String[] words = param.split(" ");
        project.setId(Integer.parseInt(words[0]));
        project.setName(words[1]);
        project.setStart(words[2]);
        project.setCoast(Integer.parseInt(words[3]));
        projectRepository.create(project);
    }

    public void delete(String param) {
        String[] words = param.split(" ");
        projectRepository.delete(Integer.parseInt(words[0]));
    }

    @Override
    public void printInstruction() {
        System.out.println("^-------- PROJECTS MENU ----------^");
        System.out.println("COMMAND: " + commands);
        System.out.println("ИНСТРУКЦИЯ ПО ВЫБОРУ КОМАНД:\n" + WORD1 + "\"create\"" + WORD2 + "(id name deadline coast). " +
                "" + WORD3 + "create 10 BBC 2022-03-13 700000\n" + WORD1 + "\"read\" - ничего вводить не нужно, выводится список проектов хранящихся в БД.\n" +
                "" + WORD1 + "\"update\"" + WORD2 + "(name deadline coast id). " +
                "" + WORD3 + "update BBC 2022-03-13 700000 10\n" + WORD1 + "\"delete\" - вам нужно вести (id). " +
                "" + WORD3 + "delete 10\n" + WORD1 + "\"get\" - вам нужно ввести (id). " +
                "" + WORD3 + "get 10\n" + WORD1 + "\"sum\" - вам нужно ввести (name-(названия проекта хранящихся в БД)). " +
                "" + WORD3 + "sum Telegram\n" + WORD1 + "\"list\" - вам нужно ввести (name-(названия проекта хранящихся в БД)). " +
                "" + WORD3 + "list Viber.\nМаксимальный id \"PROJECTS\" - " +getMaxId());
    }

    public void read() {
        List<Project> read = projectRepository.read();
        read.forEach(System.out::println);
    }
}
