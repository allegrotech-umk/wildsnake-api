CREATE TABLE IF NOT EXISTS product  (
    id SERIAL,
    name VARCHAR(20),
    description VARCHAR(10000),
    image_url VARCHAR (250),
    price DECIMAL
);
