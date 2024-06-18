
use usertasks;
CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
CREATE TABLE book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

insert into car (id, name, price) values (default, ‘Audi’,3000000 );
insert into car (id, name, price) values (default, ‘BMW’,4000000 );
insert into car (id, name, price) values (default, ‘Jaguar’,3500000 );
insert into car (id, name, price) values (default, ‘Audi’,3000000 );
insert into car (id, name, price) values (default, ‘BMW’,4000000 );
insert into car (id, name, price) values (default, ‘Jaguar’,3500000 );

insert into book (id, name, price) values (default, ‘Book-1’,600 );
insert into book (id, name, price) values (default, ‘Book-2’,500 );
insert into book (id, name, price) values (default, ‘Book-3’,800 );
insert into book (id, name, price) values (default, ‘Book-1’,600 );
insert into book (id, name, price) values (default, ‘Book-2’,500 );
insert into book (id, name, price) values (default, ‘Book-3’,800 );
 
 