SELECT MIN(coast) AS Самый_дешевый_проект
FROM projects; -- 1 Вариант

SELECT project AS Проект, MIN(coast) AS Самый_дешевый_проект
FROM projects
GROUP BY project
ORDER BY Самый_дешевый_проект ASC
LIMIT 1; -- 2 вариант