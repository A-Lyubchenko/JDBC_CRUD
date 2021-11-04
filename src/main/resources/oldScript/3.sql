SELECT department AS Разработчик, SUM(salary) AS Общая_ЗП_JAVA_Разработчиков
FROM developer_skill
INNER JOIN skills ON developer_skill.skill_id = skills.skill_id
INNER JOIN developers ON developer_skill.developer_id = developers.developer_id
WHERE skills.department = 'Java'
GROUP BY department;