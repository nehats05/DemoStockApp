CREATE DATABASE IF NOT EXISTS stockschema;

CREATE USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON stockschema.* TO 'root'@'localhost';

use stockschema;