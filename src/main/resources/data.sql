INSERT INTO brand(name) VALUES
('ADIDAS'),
('PUMA'),
('NIKE'),
('ASICS');

INSERT INTO color(name,code) VALUES
('RED','RD'),
('GREEN','GRN'),
('BLUE','BLU');

INSERT INTO product_category(name) VALUES
('SHIRT'),
('PANT'),
('ACCESSORIES');

INSERT INTO product(name,quantity,size,price,brand_id,color_id,product_category_id) VALUES
  ('STRIPED TSHIRT',10,'M',2000,1,1,1),
  ('BLUE WASHED JEANS',20,'S',3000,2,3,2),
  ('SOCKS',200,'L',300,4,2,3),
  ('WINDCHEATER JACKET',200,'S',300,4,2,2),
  ('SHIRT',200,'XL',300,4,2,1),
  ('FULL TSHIRT',200,'XXL',300,4,2,3),
  ('POLO TSHIRT',200,'XXL',300,4,1,3);