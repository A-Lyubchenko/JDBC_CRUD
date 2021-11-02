package ua.lyubchenko.repositories;

import java.util.List;

public interface IRepositories<T> {

    Integer salaryDevelopers(T entity);

    List<String> getDevelopersOfProject(T entity);

    List<String> getJavaDevelopers();

    List<String> getMiddleDevelopers();

    List<String> listOfCountDevelopersWorkingOnProjects();
}
