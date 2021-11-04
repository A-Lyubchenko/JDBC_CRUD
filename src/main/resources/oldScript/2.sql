SELECT project AS Самый_дорогой_проект, SUM(salary) AS Цена
FROM developer_project
INNER JOIN projects ON developer_project.project_id = projects.project_id
INNER JOIN developers ON developer_project.developer_id = developers.developer_id
GROUP BY project
ORDER BY Цена DESC
LIMIT 1;