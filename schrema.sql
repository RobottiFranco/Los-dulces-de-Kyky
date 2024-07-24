CREATE TABLE Product (
    product_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE ProductType (
    product_type_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE ProductTypeMapping (
    product_id INT REFERENCES Product(product_id),
    product_type_id INT REFERENCES ProductType(product_type_id),
    PRIMARY KEY (product_id, product_type_id)
);

CREATE TABLE AppUser (
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    id_number VARCHAR(50) NOT NULL PRIMARY KEY,
    phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE Cart (
    cart_id SERIAL PRIMARY KEY,
    id_number VARCHAR(50) REFERENCES AppUser(id_number)
);

CREATE TABLE CartItem (
    cart_item_id SERIAL PRIMARY KEY,
    cart_id INT REFERENCES Cart(cart_id),
    product_id INT REFERENCES Product(product_id),
    quantity INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE PurchaseOrder (
    order_id SERIAL PRIMARY KEY,
    user_id VARCHAR(50) REFERENCES AppUser(id_number),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount NUMERIC(10, 2) NOT NULL
);

CREATE TABLE OrderItem (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES PurchaseOrder(order_id),
    product_id INT REFERENCES Product(product_id),
    quantity INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

INSERT INTO Product (name, description, price) VALUES
('Chocolate Cake', 'A rich and moist chocolate cake', 25.00),
('Vanilla Cupcake', 'Soft and fluffy vanilla cupcake with buttercream frosting', 3.50),
('Cheesecake', 'Creamy cheesecake with a graham cracker crust', 30.00);

INSERT INTO ProductType (name) VALUES
('Cake'),
('Cupcake'),
('Dessert');

INSERT INTO ProductTypeMapping (product_id, product_type_id) VALUES
(1, 1),  -- Chocolate Cake is a Cake
(2, 2),  -- Vanilla Cupcake is a Cupcake
(3, 3),  -- Cheesecake is a Dessert
(1, 3),  -- Chocolate Cake is also a Dessert
(2, 3);  -- Vanilla Cupcake is also a Dessert

INSERT INTO AppUser (first_name, last_name, id_number, phone_number) VALUES
('John', 'Doe', '1234567890', '555-1234'),
('Jane', 'Smith', '0987654321', '555-5678');

INSERT INTO Cart (user_id) VALUES
('1234567890'),  -- Cart for John Doe
('0987654321');  -- Cart for Jane Smith

INSERT INTO CartItem (cart_id, product_id, quantity, price) VALUES
(1, 1, 1, 25.00),  -- John Doe's cart contains 1 Chocolate Cake
(1, 2, 2, 3.50),   -- John Doe's cart contains 2 Vanilla Cupcakes
(2, 3, 1, 30.00);  -- Jane Smith's cart contains 1 Cheesecake

INSERT INTO PurchaseOrder (user_id, created_at, total_amount) VALUES
('1234567890', '2024-07-19 12:00:00', 32.00),  -- Order by John Doe
('0987654321', '2024-07-19 12:30:00', 30.00);  -- Order by Jane Smith

INSERT INTO OrderItem (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 25.00),  -- John Doe's order contains 1 Chocolate Cake
(1, 2, 2, 3.50),   -- John Doe's order contains 2 Vanilla Cupcakes
(2, 3, 1, 30.00);  -- Jane Smith's order contains 1 Cheesecake

select p.* from Product as p, product_type_mapping as ptm, product_type as pt where p.product_id = ptm.product_id and ptm.product_type_id = pt.product_type_id and pt.name = 'Cake';