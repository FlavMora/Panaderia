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
-- Pasteles datos
INSERT INTO pasteles (nombre, descripcion, imagen, calificacion, precio) VALUES
('Pastel de Chocolate', 'Delicioso pastel de chocolate con cobertura de ganache.', 'https://www.suqiee.com.mx/wp-content/uploads/2022/12/instagram-pastel-de-chocolate-1.jpg', 4.8, 15.99),
('Pastel de Fresa', 'Esponjoso pastel con fresas frescas y crema chantilly.', 'https://content-cocina.lecturas.com/medio/2021/05/17/paso_a_paso_para_realizar_mona_de_pascua_de_fresa_con_coco_y_merengues_resultado_final_da1c7a67_1200x1200.jpg', 4.6, 13.50),
('Pastel de Zanahoria', 'Pastel húmedo con zanahoria y nueces, cubierto con crema de queso.', 'https://cdn0.uncomo.com/es/posts/5/3/7/como_hacer_un_pastel_de_zanahoria_25735_600.jpg', 4.7, 14.75),
('Cheesecake de Frutos Rojos', 'Tarta de queso con base de galleta y frutos rojos.', 'https://www.recetasnestle.com.ar/sites/default/files/styles/recipe_detail_desktop_new/public/srh_recipes/5776df29deabe397c967bffb09f6ca3c.webp?itok=xASngN1r', 4.9, 16.25),
('Pastel Red Velvet', 'Pastel rojo aterciopelado con crema de queso.', 'https://i.ytimg.com/vi/aQOJEu77Pxs/maxresdefault.jpg', 4.5, 14.99);


use panaderia;
-- Reposteria tabla
CREATE TABLE reposterias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    calificacion DECIMAL(3, 2),
    precio DECIMAL(10, 2)
);
-- Datos Reposteria
INSERT INTO reposterias (nombre, descripcion, imagen, calificacion, precio) VALUES
('Tarta de Manzana', 'Clásica tarta de manzana con canela y crujiente de hojaldre.', 'https://www.hogarmania.com/archivos/201402/5317-2-tarta-de-manzana-702-xl-668x400x80xX.jpg', 4.7, 12.50),
('Croissants Artesanales', 'Cruasanes recién horneados con mantequilla pura.', 'https://www.iberianpress.es/wp-content/uploads/2024/04/croissants-artesanos-IP.jpg', 4.6, 2.50),
('Profiteroles', 'Bolitas de masa choux rellenas de crema y bañadas en chocolate.', 'https://recetasdecocina.elmundo.es/wp-content/uploads/2024/12/profiteroles.jpg', 4.8, 8.75),
('Macarons Franceses', 'Delicados macarons de distintos sabores y colores.', 'https://www.hogarmania.com/archivos/202101/cocina-recetas-como-hacer-croissants-cruasanes-caseros-XxXx80.jpg', 4.9, 3.00),
('Strudel de Manzana', 'Postre tradicional austríaco con manzana, pasas y canela.', 'https://content-cocina.lecturas.com/medio/2021/10/07/paso-a-paso-para-hacer-el-strudel-clasico-de-manzana-y-pinones-resultado-final_c41d7762_1200x1200.jpg', 4.5, 10.25),
('Éclairs de Chocolate', 'Barquillos rellenos de crema pastelera y cubiertos de chocolate.', 'https://es.cravingsjournal.com/wp-content/uploads/2023/04/eclairs-5-500x500.jpg', 4.7, 3.50),
('Cheesecake de Dulce de Leche', 'Suave tarta de queso con salsa de dulce de leche.', 'https://www.recetasnestle.com.do/sites/default/files/srh_recipes/4abc94c93dd9be951ea36cafb183206f.png', 4.8, 14.00),
('Volcán de Chocolate', 'Pastel individual con corazón líquido de chocolate.', 'https://www.gourmet.cl/wp-content/uploads/2012/04/volcan-de-chocolate.jpg', 4.9, 6.50),
('Tiramisú Clásico', 'Postre italiano con café, mascarpone y bizcochos de soletilla.', 'https://cdn7.kiwilimon.com/recetaimagen/35448/960x640/42520.jpg.jpg', 4.8, 9.75),
('Mousse de Chocolate', 'Postre ligero de chocolate con un 70% de cacao.', 'https://www.recetasderechupete.com/wp-content/uploads/2015/12/mousse-de-chocolate.jpg', 4.6, 7.25),
('Panna Cotta con Frutos Rojos', 'Crema italiana cocida con salsa de frutos del bosque.', 'https://s1.elespanol.com/2020/06/29/cocinillas/recetas/postres/reposteria-postres_501460704_154722864_1706x960.jpg', 4.7, 8.00),
('Galletas Decoradas', 'Galletas de mantequilla con diseños artesanales.', 'https://assets.elgourmet.com/wp-content/uploads/2023/03/cover_a0wtn7j2ex_galle-1024x683.jpg.webp', 4.4, 1.75),
('Tarta de Queso con Frambuesas', 'Clásica New York cheesecake con coulis de frambuesa.', 'https://s1.elespanol.com/2017/04/07/cocinillas/cocinillas_206742125_116317697_1706x960.jpg', 4.9, 15.50),
('Bombones de Chocolate', 'Surrido de bombones rellenos de distintos sabores.', 'https://content-cocina.lecturas.com/medio/2021/01/04/chocovasitos_de_frutos_secos_y_bombones_rellenos_de_caramelo_06101458_800x800.jpg', 4.8, 12.00),
('Crepes Suzette', 'Crepes flambeados con salsa de naranja y Grand Marnier.', 'https://www.divinacocina.es/wp-content/uploads/crepes-suzette.jpg', 4.7, 11.25);



-- Reseña tabla
CREATE TABLE resena (
    id INT AUTO_INCREMENT PRIMARY KEY,
    autor VARCHAR(50) NOT NULL,
    contenido VARCHAR(500) NOT NULL,
    calificacion INT NOT NULL CHECK (calificacion BETWEEN 1 AND 5),
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO resena (autor, contenido, calificacion, fecha) VALUES
('María Pérez', 'El mejor pan dulce que he probado, ¡siempre fresco!', 5, NOW()),
('Juan López', 'Buen servicio pero el estacionamiento es complicado', 4, NOW() - INTERVAL 1 DAY),
('Ana Sánchez', 'Los pasteles son una obra de arte, vale cada centavo', 5, NOW() - INTERVAL 2 DAY);