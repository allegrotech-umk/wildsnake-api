DROP TABLE product IF EXISTS ;

CREATE TABLE product  (
    id BIGINT IDENTITY PRIMARY KEY,
    name VARCHAR(20),
    description VARCHAR(10000),
    image_url VARCHAR (250),
    price DECIMAL
);