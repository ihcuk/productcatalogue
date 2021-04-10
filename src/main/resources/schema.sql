DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS color;
DROP TABLE IF EXISTS seller;
DROP TABLE IF EXISTS product_category;
CREATE TABLE Brand(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
CREATE TABLE Color(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  code VARCHAR(5) NOT NULL
);
CREATE TABLE Product_Category(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);
CREATE TABLE Product(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    quantity INT NOT NULL,
    size VARCHAR(5) NOT NULL,
    price INT NOT NULL,
    brand_id INT NOT NULL,
    foreign key (brand_id) references Brand(id),
    color_id INT NOT NULL,
    foreign key (color_id) references Color(id),
    product_category_id INT NOT NULL,
    foreign key (product_category_id) references Product_Category(id)
);