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

CREATE TABLE Cart (
    cart_id SERIAL PRIMARY KEY
);

CREATE TABLE CartItem (
    cart_item_id SERIAL PRIMARY KEY,
    cart_id INT REFERENCES Cart(cart_id) ON DELETE CASCADE,
    product_id INT REFERENCES Product(product_id),
    quantity INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

CREATE TABLE PurchaseOrder (
    order_id SERIAL PRIMARY KEY,
    user_first_name VARCHAR(255) NOT NULL,
    user_last_name VARCHAR(255) NOT NULL,
    user_phone_number VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount NUMERIC(10, 2) NOT NULL
);

CREATE TABLE OrderItem (
    order_item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES PurchaseOrder(order_id) ON DELETE CASCADE,
    product_id INT REFERENCES Product(product_id),
    quantity INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

INSERT INTO Product (name, description, price) VALUES
('Torta de Chocolate', 'Deliciosa torta de chocolate con cobertura de ganache', 500.00),
('Tarta de Manzana', 'Tarta de manzana con masa crujiente y relleno jugoso', 350.00),
('Brownies', 'Brownies de chocolate con nueces', 200.00),
('Cheesecake', 'Cheesecake de frutilla con base de galleta', 450.00);


INSERT INTO Product_Type (name) VALUES
('Postre'),
('Dulce'),
('Salado'),
('Bebida');

INSERT INTO Product_Type_Mapping (product_id, product_type_id) VALUES
(1, 1), -- Torta de Chocolate es un Postre
(1, 2), -- Torta de Chocolate es Dulce
(2, 1), -- Tarta de Manzana es un Postre
(2, 2), -- Tarta de Manzana es Dulce
(3, 1), -- Brownies es un Postre
(3, 2), -- Brownies es Dulce
(4, 1), -- Cheesecake es un Postre
(4, 2); -- Cheesecake es Dulce


INSERT INTO Purchase_Order (user_first_name, user_last_name, user_phone_number, total_amount) VALUES
('Juan', 'Pérez', '12345678', 1050.00),
('Ana', 'González', '87654321', 700.00);

INSERT INTO Order_Item (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 500.00), -- Juan Pérez compró 1 Torta de Chocolate
(1, 2, 2, 700.00), -- Juan Pérez compró 2 Tartas de Manzana (2 * 350.00)
(2, 3, 3, 600.00), -- Ana González compró 3 Brownies (3 * 200.00)
(2, 4, 1, 450.00); -- Ana González compró 1 Cheesecake



select p.* from Product as p, product_type_mapping as ptm, product_type as pt where p.product_id = ptm.product_id and ptm.product_type_id = pt.product_type_id and pt.name = 'Cake';