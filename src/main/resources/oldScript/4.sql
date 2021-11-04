ALTER TABLE projects 
ADD COLUMN coast INT;

UPDATE projects
SET coast = 319345 WHERE project_id = 1;

UPDATE projects
SET coast = 302389 WHERE project_id = 2;

UPDATE projects
SET coast = 450763 WHERE project_id = 3;

UPDATE projects
SET coast = 469756 WHERE project_id = 4;

UPDATE projects
SET coast = 238673 WHERE project_id = 5;

UPDATE projects
SET coast = 248765 WHERE project_id = 6;