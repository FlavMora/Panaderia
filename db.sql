-- Create user
CREATE USER 'panadero'@'%' IDENTIFIED BY 'panadero_password';
CREATE DATABASE panaderia CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
GRANT ALL PRIVILEGES ON panaderia.* TO 'panadero'@'%';
--------------
use panaderia;
-- Postres tabla
CREATE TABLE postres (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    calificacion DECIMAL(3, 2),
    precio DECIMAL(10, 2)
);
--------------

-- Postres seeders
INSERT INTO postres (nombre, descripcion, imagen, calificacion, precio) VALUES
('Galletas de Chispas de Chocolate', 'Clásicas galletas con trozos de chocolate.', 'https://cdn7.kiwilimon.com/recetaimagen/31079/640x426/35433.jpg.webp', 4.5, 1000.00),
('Brownies', 'Cuadrados de chocolate intensos y húmedos.', 'https://images.cookforyourlife.org/wp-content/uploads/2020/06/Dark-Chocolate-Brownies-shutterstock_112430981.jpg', 4.6, 2000.00),
('Tartaletas de Frutas', 'Tartaletas con crema pastelera y frutas frescas.', 'https://cocina-familiar.com/wp-content/uploads/2022/03/tartaletas-chocolate-frutas.jpg', 4.4, 3000.00),
('Pan Dulce Variado', 'Selección de panes dulces tradicionales, perfecto para sus fiestas.', 'https://www.panlilian.com/wp-content/uploads/2022/08/pan-dulce-tradicional01.png', 4.3, 5000.00),
('Donas', 'Panecillos fritos con forma de anillo.', 'https://www.clarin.com/img/2025/02/25/4puqndeoH_1256x620__2.jpg', 4.2, 1200.00),
('Milhojas', 'Capas de hojaldre con crema pastelera.', 'https://www.gourmet.cl/wp-content/uploads/2017/02/16-507x458.jpg', 4.5, 3500.00),
('Pie de Limón', 'Tarta con crema de limón y merengue.', 'https://origin.cronosmedia.glr.pe/large/2020/08/10/lg_5f31d8c2f003a0716f670d8e.jpg', 4.4, 3000.00),
('Pan de Banano', 'Bizcocho dulce y húmedo de banano.', 'https://www.splenda.com/wp-content/uploads/2020/08/easy-banana-bread-1-2000x1000.jpg', 4.3, 2500.00),
('Cajetas de Coco', 'Dulces de coco rallado y leche.', 'https://numar.net/wp-content/uploads/2018/09/miercolesweb_45.png', 4.1, 2000.00),
('Mousse de Maracuyá', 'Postre ligero y refrescante de maracuyá.', 'https://assets.elgourmet.com/wp-content/uploads/2023/03/0ab8d31e603028fcaa9550031b7d35dd_3_3_photo.png', 4.6, 4500.00),
('Pan de Yuca', 'Panecillos pequeños de harina de yuca y queso.', 'https://www.recetavenezolana.com/wp-content/uploads/2019/10/RFB-1610-2-pandeyuca.jpg', 4.2, 1500.00);

use panaderia;
-- Pasteles tabla
CREATE TABLE pasteles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    calificacion DECIMAL(3, 2),
    precio DECIMAL(10, 2)
);
--- Pasteles datos
INSERT INTO pasteles (nombre, descripcion, imagen, calificacion, precio) VALUES
('Pastel de Chocolate', 'Delicioso pastel de chocolate con cobertura de ganache.', 'https://www.recetasderechupete.com/wp-content/uploads/2020/03/Pastel-de-chocolate.jpg', 4.8, 15.99),
('Pastel de Fresa', 'Esponjoso pastel con fresas frescas y crema chantilly.', 'https://www.hogarmania.com/archivos/201207/6170-2-pastel-de-fresas-xl-668x400x80xX.jpg', 4.6, 13.50),
('Pastel de Zanahoria', 'Pastel húmedo con zanahoria y nueces, cubierto con crema de queso.', 'https://www.lavanguardia.com/files/og_thumbnail/uploads/2021/12/13/61b7f5e584ba8.jpeg', 4.7, 14.75),
('Cheesecake de Frutos Rojos', 'Tarta de queso con base de galleta y frutos rojos.', 'https://www.paulinacocina.net/wp-content/uploads/2022/06/Cheesecake-frutos-rojos-600x450.jpg', 4.9, 16.25),
('Pastel Red Velvet', 'Pastel rojo aterciopelado con crema de queso.', 'https://www.recetasderechupete.com/wp-content/uploads/2020/02/Red-Velvet.jpg', 4.5, 14.99);