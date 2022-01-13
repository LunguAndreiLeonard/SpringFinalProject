use cardealershipdb;

create table if not exists dealerships (
    id varchar(255) not null,
    name varchar(255),
    city varchar(255),
    address varchar(255),
    ownerId varchar(255),
    primary key(id),
    foreign key(ownerId) references owners (id)
);

create table if not exists owners (
    id varchar(255) not null,
    name varchar(255),
    phone varchar(255),
    primary key (id)
);

create table if not exists payments (
    id int(10) not null AUTO_INCREMENT,
    title varchar(255),
    debt int(100),
    details varchar(255),
    ownerId varchar(255),
    primary key (id),
    foreign key(ownerId) references owners (id)

);

create table if not exists cars (
    id varchar(255) not null,
    name varchar(255),
    brand varchar(255),
    plate varchar(255),
    dealership_id varchar(255),
    ownerId varchar(255),
primary key (id),
foreign key (dealership_id) references dealerships(id),
foreign key (ownerId) references owners(id)
);

