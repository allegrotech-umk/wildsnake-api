CREATE TABLE product (
    id bigserial primary key,
    name varchar(20) NOT NULL,
    image_url varchar(250),
    description text
);
