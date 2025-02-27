drop database if exists library;
CREATE database library;
USE library;

CREATE TABLE library (
id INT auto_increment primary key,
name VARCHAR(50) not null,
address_id INT not null,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE address (
id INT auto_increment primary key,
country varchar (50) not null,
city varchar(50) not null,
state varchar (50) not null,
street varchar (100) not null,
zip_code varchar(10) not null,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE book (
id INT auto_increment primary key,
library_id INT not null, 
title VARCHAR (50) NOT NULL,
author VARCHAR (50) NOT NULL,
pages INT,
editorial VARCHAR (50),
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE category (
id INT auto_increment primary key,
name VARCHAR (50) not null unique,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);


CREATE TABLE category_book (
book_id INT not null,
category_id INT not null,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp
);

CREATE TABLE user(
id int auto_increment primary key,
role_id INT not null,
name VARCHAR(100) not null,
lastname VARCHAR (100) not null,
mail VARCHAR (100) not null,
phone VARCHAR (100) not null,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);


CREATE TABLE role (
id INT auto_increment primary key,
name VARCHAR (50) NOT NULL UNIQUE,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE status_copy(
id INT auto_increment primary key,
name VARCHAR (50) NOT NULL UNIQUE,
description TEXT,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE status_loan(
id INT auto_increment primary key,
name VARCHAR (50) NOT NULL UNIQUE,
description TEXT,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE loan(
id INT auto_increment primary key,
user_id INT NOT NULL,
copy_id INT NOT NULL,
status_loan_id INT NOT NULL,
loan_date DATE NOT NULL,
return_date DATE,
expiration_date DATE NOT NULL,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

CREATE TABLE copy (
id INT auto_increment primary key,
book_id INT NOT NULL,
status_copy_id INT,
created_at datetime default current_timestamp,
updated_at datetime default current_timestamp on update current_timestamp);

ALTER TABLE library 
ADD CONSTRAINT fk_library_address 
FOREIGN KEY (address_id) REFERENCES address(id) 
ON DELETE CASCADE;

ALTER TABLE book
ADD constraint fk_book_library
foreign key (library_id) REFERENCES library(id)
ON DELETE CASCADE;

ALTER TABLE category_book 
ADD CONSTRAINT fk_category_book_book 
FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE;
ALTER TABLE category_book
ADD CONSTRAINT fk_category_book_category
FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE;

ALTER TABLE user 
ADD CONSTRAINT fk_user_role 
FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE RESTRICT;

ALTER TABLE loan 
ADD CONSTRAINT fk_loan_user 
FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE;
ALTER TABLE loan 
ADD CONSTRAINT fk_loan_copy 
FOREIGN KEY (copy_id) REFERENCES copy(id) ON DELETE CASCADE;
ALTER TABLE loan 
ADD CONSTRAINT fk_loan_status_loan 
FOREIGN KEY (status_loan_id) REFERENCES status_loan(id) ON DELETE CASCADE;

ALTER TABLE copy 
ADD CONSTRAINT fk_copy_book 
FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE;
ALTER TABLE copy 
ADD CONSTRAINT fk_copy_status_copy
FOREIGN KEY (status_copy_id) REFERENCES status_copy(id) ON DELETE SET NULL;

