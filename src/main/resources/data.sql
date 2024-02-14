INSERT INTO categories (name) VALUES ('jeans');
INSERT INTO categories (name) VALUES ('jacket');
INSERT INTO categories (name) VALUES ('gloves');
INSERT INTO categories (name) VALUES ('accessory');
INSERT INTO categories (name) VALUES ('helmet');
INSERT INTO categories (name) VALUES ('boots');

INSERT INTO genders (name) VALUES ('male');
INSERT INTO genders (name) VALUES ('female');
INSERT INTO genders (name) VALUES ('other');

INSERT INTO colours (name) VALUES ('black');
INSERT INTO colours (name) VALUES ('white');
INSERT INTO colours (name) VALUES ('green');
INSERT INTO colours (name) VALUES ('yellow');
INSERT INTO colours (name) VALUES ('red');
INSERT INTO colours (name) VALUES ('blue');
INSERT INTO colours (name) VALUES ('orange');
INSERT INTO colours (name) VALUES ('pink');
INSERT INTO colours (name) VALUES ('violet');
INSERT INTO colours (name) VALUES ('brown');

INSERT INTO sizes (name) VALUES ('XS');
INSERT INTO sizes (name) VALUES ('S');
INSERT INTO sizes (name) VALUES ('M');
INSERT INTO sizes (name) VALUES ('L');
INSERT INTO sizes (name) VALUES ('XL');
INSERT INTO sizes (name) VALUES ('XXL');
INSERT INTO sizes (name) VALUES ('2XL');
INSERT INTO sizes (name) VALUES ('3XL');

INSERT INTO discounts (discount_percent) VALUES (0);
INSERT INTO discounts (discount_percent) VALUES (5);
INSERT INTO discounts (discount_percent) VALUES (10);
INSERT INTO discounts (discount_percent) VALUES (7);
INSERT INTO discounts (discount_percent) VALUES (15);
INSERT INTO discounts (discount_percent) VALUES (3);

INSERT INTO discounts (discount_percent) VALUES (0);
INSERT INTO discounts (discount_percent) VALUES (5);
INSERT INTO discounts (discount_percent) VALUES (10);
INSERT INTO discounts (discount_percent) VALUES (7);
INSERT INTO discounts (discount_percent) VALUES (15);
INSERT INTO discounts (discount_percent) VALUES (3);

INSERT INTO discounts (discount_percent) VALUES (0);
INSERT INTO discounts (discount_percent) VALUES (5);
INSERT INTO discounts (discount_percent) VALUES (10);
INSERT INTO discounts (discount_percent) VALUES (7);
INSERT INTO discounts (discount_percent) VALUES (15);
INSERT INTO discounts (discount_percent) VALUES (3);

INSERT INTO inventories (quantity) VALUES (120);
INSERT INTO inventories (quantity) VALUES (68);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (24);
INSERT INTO inventories (quantity) VALUES (455);
INSERT INTO inventories (quantity) VALUES (328);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (875);
INSERT INTO inventories (quantity) VALUES (96);

INSERT INTO inventories (quantity) VALUES (120);
INSERT INTO inventories (quantity) VALUES (68);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (24);
INSERT INTO inventories (quantity) VALUES (455);
INSERT INTO inventories (quantity) VALUES (328);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (875);
INSERT INTO inventories (quantity) VALUES (96);

INSERT INTO inventories (quantity) VALUES (120);
INSERT INTO inventories (quantity) VALUES (68);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (24);
INSERT INTO inventories (quantity) VALUES (455);
INSERT INTO inventories (quantity) VALUES (328);
INSERT INTO inventories (quantity) VALUES (78);
INSERT INTO inventories (quantity) VALUES (875);
INSERT INTO inventories (quantity) VALUES (96);

INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 128, 2, 1, 1, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 98, 3, 2, 2, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 545, 3, 3, 3, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 788, 2, 4, 4, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 54, 2, 5, 5, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 88, 3, 6, 6, "gloves with nice holes", "alpinestars", "gloves");

INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 136, 2, 7, 9, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 102, 3, 8, 7, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 422, 3, 9, 8, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 688, 2, 10, 13, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 65, 2, 11, 14, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 79, 3, 12, 15, "gloves with nice holes", "alpinestars", "gloves");

INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 220, 2, 13, 16, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 89, 3, 14, 17, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 468, 3, 15, 18, "gloves with nice holes", "alpinestars", "gloves");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 695, 2, 16, 10, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 67, 2, 17, 11, "jacket with nice buttons", "alpinestars", "jacket");
INSERT INTO products (deleted_flag, price, category_id, discount_id, inventory_id, description, manufacturer, name) VALUES (0, 100, 3, 18, 12, "gloves with nice holes", "alpinestars", "gloves");


INSERT INTO product_colour (colour_id, product_id) VALUES (1,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (2,2);
INSERT INTO product_colour (colour_id, product_id) VALUES (3,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (4,4);
INSERT INTO product_colour (colour_id, product_id) VALUES (5,5);
INSERT INTO product_colour (colour_id, product_id) VALUES (6,6);

INSERT INTO product_colour (colour_id, product_id) VALUES (1,7);
INSERT INTO product_colour (colour_id, product_id) VALUES (2,8);
INSERT INTO product_colour (colour_id, product_id) VALUES (3,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (4,10);
INSERT INTO product_colour (colour_id, product_id) VALUES (5,11);
INSERT INTO product_colour (colour_id, product_id) VALUES (6,12);

INSERT INTO product_colour (colour_id, product_id) VALUES (1,13);
INSERT INTO product_colour (colour_id, product_id) VALUES (2,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (3,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (4,1);
INSERT INTO product_colour (colour_id, product_id) VALUES (5,17);
INSERT INTO product_colour (colour_id, product_id) VALUES (6,18);

INSERT INTO product_colour (colour_id, product_id) VALUES (6,3);
INSERT INTO product_colour (colour_id, product_id) VALUES (6,9);
INSERT INTO product_colour (colour_id, product_id) VALUES (2,14);
INSERT INTO product_colour (colour_id, product_id) VALUES (3,15);
INSERT INTO product_colour (colour_id, product_id) VALUES (1,16);

INSERT INTO product_gender (gender_id, product_id) VALUES (1,1);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,2);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,3);
INSERT INTO product_gender (gender_id, product_id) VALUES (1,4);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,5);
INSERT INTO product_gender (gender_id, product_id) VALUES (1,6);

INSERT INTO product_gender (gender_id, product_id) VALUES (1,7);
INSERT INTO product_gender (gender_id, product_id) VALUES (1,8);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,9);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,10);
INSERT INTO product_gender (gender_id, product_id) VALUES (1,11);
INSERT INTO product_gender (gender_id, product_id) VALUES (1,12);

INSERT INTO product_gender (gender_id, product_id) VALUES (1,13);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,14);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,15);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,16);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,17);
INSERT INTO product_gender (gender_id, product_id) VALUES (2,18);

INSERT INTO product_size (size_id, product_id) VALUES (1,1);
INSERT INTO product_size (size_id, product_id) VALUES (3,2);
INSERT INTO product_size (size_id, product_id) VALUES (6,1);
INSERT INTO product_size (size_id, product_id) VALUES (5,4);
INSERT INTO product_size (size_id, product_id) VALUES (7,5);
INSERT INTO product_size (size_id, product_id) VALUES (6,6);

INSERT INTO product_size (size_id, product_id) VALUES (1,3);
INSERT INTO product_size (size_id, product_id) VALUES (4,9);
INSERT INTO product_size (size_id, product_id) VALUES (3,16);

INSERT INTO product_size (size_id, product_id) VALUES (7,7);
INSERT INTO product_size (size_id, product_id) VALUES (8,8);
INSERT INTO product_size (size_id, product_id) VALUES (7,1);
INSERT INTO product_size (size_id, product_id) VALUES (6,10);
INSERT INTO product_size (size_id, product_id) VALUES (6,11);
INSERT INTO product_size (size_id, product_id) VALUES (6,12);

INSERT INTO product_size (size_id, product_id) VALUES (4,13);
INSERT INTO product_size (size_id, product_id) VALUES (5,14);
INSERT INTO product_size (size_id, product_id) VALUES (4,15);
INSERT INTO product_size (size_id, product_id) VALUES (1,1);
INSERT INTO product_size (size_id, product_id) VALUES (8,17);
INSERT INTO product_size (size_id, product_id) VALUES (2,18);


INSERT INTO bmoto.users (username, password, deleted_flag)
VALUES
('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',0),
('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',0),
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',0);


INSERT INTO bmoto.authorities (authority)
VALUES
('ROLE_CUSTOMER'),
('ROLE_MANAGER'),
('ROLE_ADMIN');

INSERT INTO bmoto.user_authorities VALUES (1,1),(2,1),(2,2),(3,1),(3,2),(3,3);

