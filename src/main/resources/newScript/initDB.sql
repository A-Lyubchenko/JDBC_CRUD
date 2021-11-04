-- auto-generated definition
create table companies
(
    id       integer generated by default as identity
        constraint companies_pkey
            primary key,
    name     varchar(30),
    location varchar(30)
);

alter table companies
    owner to postgres;

-- auto-generated definition
create table customers
(
    id       integer generated by default as identity
        constraint customers_pkey
            primary key,
    name     varchar(30),
    location varchar(30)
);

alter table customers
    owner to postgres;

-- auto-generated definition
create table developers
(
    id           integer generated by default as identity
        constraint developers_pkey
            primary key,
    name         varchar(40),
    age          integer,
    sex          varchar(10),
    phone_number varchar(30),
    salary       integer
);

alter table developers
    owner to postgres;

-- auto-generated definition
create table projects
(
    id       integer generated by default as identity
        constraint projects_pkey
            primary key,
    name     varchar(30),
    start    date,
    coast    integer
);

alter table projects
    owner to postgres;

-- auto-generated definition
create table skills
(
    id         integer generated by default as identity
        constraint skills_pkey
            primary key,
    department varchar(30),
    level      varchar(30)
);

alter table skills
    owner to postgres;


