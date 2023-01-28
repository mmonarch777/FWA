drop table if exists users cascade;
drop table if exists info cascade;
drop table if exists images cascade;

create table users(
    id serial   primary key ,
    name        varchar(30) not null ,
    surname     varchar(30) not null ,
    phone       varchar(30) not null ,
    password    varchar not null
);

create table info(
    owner   integer references users(id) not null,
    date    timestamp default current_timestamp,
    ip      varchar(30) not null
);

create table images(
    owner       integer references users(id) not null,
    name        varchar(50) not null,
    uniqName    varchar(50) not null,
    mime        varchar(50) not null,
    size        integer not null
);
