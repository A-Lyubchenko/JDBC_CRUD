package ua.lyubchenko.commands;

import ua.lyubchenko.domains.Project;
import ua.lyubchenko.repositories.entityRepositories.DeveloperRepository;
import ua.lyubchenko.repositories.entityRepositories.ProjectRepository;
import ua.lyubchenko.repositories.entityRepositories.SkillRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;

public abstract class Commands implements ICommands, ICommandsCrud, IFunctional {
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final SkillRepository skillRepository = new SkillRepository();
    private final DeveloperRepository developerRepository = new DeveloperRepository();



    @Override
    public void listOfCountDevelopersOnProject(String param) {
        List<String> listOfCountDevelopersWorkingOnProjects = developerRepository.listOfCountDevelopersWorkingOnProjects();
        listOfCountDevelopersWorkingOnProjects.forEach(dev -> System.out.println("INFO: " + dev));
    }

    @Override
    public void listOfMiddleDevelopers(String param) {
        List<String> developersOfJava = skillRepository.getMiddleDevelopers();
        developersOfJava.forEach(dev -> System.out.println("DEVELOPER OF MIDDLE: " + dev));
    }

    @Override
    public void listOfJavaDevelopers(String param) {
        List<String> developersOfJava = skillRepository.getJavaDevelopers();
        developersOfJava.forEach(dev -> System.out.println("DEVELOPER OF JAVA: " + dev));
    }

    @Override
    public void listOfDevelopers(String param) {
        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            String firstWord = matcher.group();
            Project project = new Project();
            project.setName(firstWord);
            List<String> developersOfProject = projectRepository.getDevelopersOfProject(project);
            developersOfProject.forEach(dev -> System.out.println("DEVELOPER: " + dev));
        }

    }

    @Override
    public void sum(String param) {
        Matcher matcher = pattern.matcher(param);
        if (matcher.find()) {
            String firstWord = matcher.group();
            Project project = new Project();
            project.setName(firstWord);
            Integer integer = projectRepository.salaryDevelopers(project);
            System.out.println("SALARY: " + integer);
        }
    }

    @Override
    public void handle(String param, Consumer<ICommands> iCommandsConsumer) {
        Optional<String> firstWord = getFirstWorld(param);
        if (firstWord.isPresent()){
            String newParams = param.replace(firstWord.get(), "").trim();
            switch (firstWord.get()) {
                case "create":
                    create(newParams);
                    return;
                case "read":
                    read();
                    return;
                case "delete":
                    delete(newParams);
                    return;
                case "update":
                    update(newParams);
                    return;
                case "sum":
                    sum(newParams);
                    return;
                case "list":
                    listOfDevelopers(newParams);
                    return;
                case "java":
                    listOfJavaDevelopers(newParams);
                    return;
                case "middle":
                    listOfMiddleDevelopers(newParams);
                    return;
                case "count":
                    listOfCountDevelopersOnProject(newParams);
            }
        }
    }
}
