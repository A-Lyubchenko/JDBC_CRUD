package ua.lyubchenko.repositories.entityRepositories;

import lombok.SneakyThrows;
import ua.lyubchenko.connection.ISqlHelper;
import ua.lyubchenko.connection.SqlHelper;
import ua.lyubchenko.domains.Customer;
import ua.lyubchenko.domains.Project;
import ua.lyubchenko.repositories.EntityRepository;

import java.sql.ResultSet;

public class ProjectRepository extends EntityRepository<Project> {
    private final ISqlHelper sqlHelper = new SqlHelper();

    @Override
    protected String getTableName() {
        return "projects";
    }

    @SneakyThrows
    @Override
    protected Project getEntity(ResultSet resultSet) {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setStart(resultSet.getString("start"));
        project.setCoast(resultSet.getInt("coast"));
        return project;
    }

    @Override
    public void create(Project project) {
        String sql = String.format("INSERT INTO %s (id, name, start, coast) VALUES(?,?,?,?)", getTableName());
        sqlHelper.update(sql, preparedStatement -> {
            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getName());
            preparedStatement.setString(3, project.getStart());
            preparedStatement.setInt(4, project.getCoast());
        });
        System.out.println("DEVELOPER WAS CREATOR");

    }

    @Override
    public void update(Project project) {
        String sql = String.format("UPDATE FROM %s SET name = ?, start = ?, coast = ? WHERE id = ?", getTableName());
        sqlHelper.update(sql, preparedStatement -> {
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getStart());
            preparedStatement.setInt(3, project.getCoast());
            preparedStatement.setInt(5, project.getId());
        });
        System.out.println("DEVELOPER WAS UPDATE");
    }
}
