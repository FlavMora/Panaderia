-- Create user
CREATE USER 'panadero'@'%' IDENTIFIED BY 'panadero_password';
CREATE DATABASE panaderia CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
GRANT ALL PRIVILEGES ON panaderia.* TO 'panadero'@'%';
--------------