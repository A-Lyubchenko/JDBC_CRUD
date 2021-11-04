SELECT project AS Проект, MIN(coast) AS Цена_самого_дешевого_проекта, ROUND(AVG(salary),2) AS Средняя_ЗП_програмиста
FROM developer_project
INNER JOIN projects ON developer_project.project_id = projects.project_id
INNER JOIN developers ON developer_project.developer_id = developers.developer_id
GROUP BY project
ORDER BY Цена_самого_дешевого_проекта ASC
LIMIT 1;