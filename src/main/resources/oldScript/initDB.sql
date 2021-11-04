CREATE TABLE skills
(skill_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
department Varchar(30),
skill_level Varchar(30));

CREATE TABLE projects
(project_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
project Varchar(30),
deadline_date DATE);

CREATE TABLE companies
(companie_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
it_companie Varchar(30),
location_companie Varchar(30));

CREATE TABLE customers
(customer_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
customer_name Varchar(30),
location_customer Varchar(30));

CREATE TABLE developers
(developer_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
developer_name Varchar(40),
developer_age INT,
developer_sex Varchar(10),
developer_phone_number Varchar(20));

CREATE TABLE developer_skill
(developer_id INT REFERENCES developers(developer_id) NOT Null,
skill_id INT REFERENCES skills(skill_id) NOT Null);

CREATE TABLE developer_project
(developer_id INT REFERENCES developers(developer_id) NOT Null,
project_id INT REFERENCES projects(project_id) NOT Null);

CREATE TABLE developer_companie
(developer_id INT REFERENCES developers(developer_id) NOT Null,
companie_id INT REFERENCES companies(companie_id) NOT Null);

CREATE TABLE companie_project
(companie_id INT REFERENCES companies(companie_id) NOT Null,
project_id INT REFERENCES projects(project_id) NOT Null);

CREATE TABLE customer_project
(customer_id INT REFERENCES customers(customer_id) NOT Null,
project_id INT REFERENCES projects(project_id) NOT Null);
