create table author
(
    id serial
        primary key,
    first_name varchar(50) not null,
    second_name varchar(50) null,
    family_name varchar(50) not null,
    birth_date date null
);

create table customer
(
    id serial
        primary key,
    first_name  varchar(255) null,
    family_name varchar(255) null,
    sex varchar(50) null,
    status varchar(50) null,
    birth_date date null
);

create table book
(
    id serial
        primary key,
    book_title varchar(100) null,
    updated timestamp null,
    author_id  bigint       null,
    customer_id    bigint       null,
    constraint FKklnrv3weler2ftkweewlky958
            foreign key (author_id) references author (id)
);

create table users
(
    id serial
        primary key,
    login varchar(50) not null,
    password varchar(50) null,
    role varchar(50) null
);

INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (1, 'Дмитрий', 'Дмитриев', 'М', 'Free', '1995-09-21');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (2, 'Марина', 'Алексеева', 'Ж', 'Married', '1991-11-21');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (3, 'Евгений', 'Осев', 'М', 'Married', '1976-09-25');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (4, 'Евгения', 'Андреева', 'Ж', 'Married', '1966-09-25');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (5, 'Арина', 'Царева', 'Ж', 'Free', '1956-01-05');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (6, 'Денис', 'Корев', 'М', 'Free', '1985-05-16');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (7, 'Егор', 'Молчанов', 'М', 'Free', '1989-02-20');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (8, 'Мария', 'Молчанова', 'Ж', 'Married', '1973-06-15');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (9, 'Кристина', 'Шаповалова', 'Ж', 'Married', '1991-12-14');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (10, 'Андрей', 'Малинов', 'М', 'Free', '2000-12-23');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (11, 'Олег', 'Колчин', 'М', 'Free', '2000-12-23');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (12, 'Георгий', 'Жаров', 'М', 'Free', '1999-02-13');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (13, 'Марина', 'Лосева', 'Ж', 'Married', '1986-01-04');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (14, 'Диана', 'Воробьева', 'Ж', 'Married', '1995-01-19');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (15, 'Дмитрий', 'Воробьев', 'М', 'Married', '1993-08-22');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (16, 'Олеся', 'Авдеева', 'Ж', 'Free', '1979-03-04');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (17, 'Никита', 'Соев', 'М', 'Married', '1965-02-19');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (18, 'Никита', 'Горгиев', 'Ж', 'Free', '2001-04-11');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (19, 'Галина', 'Калинина', 'Ж', 'Free', '1997-08-15');
INSERT INTO customer (id, first_name, family_name, sex, status, birth_date) VALUES (20, 'Андрей', 'Михайлов', 'М', 'Married', '1981-05-01');

INSERT INTO users (id, login, password, role) VALUES (1, 'master_log', 'qweasdzxc', 'ROLE_USER');
INSERT INTO users (id, login, password, role) VALUES (2, 'test_log', '123qweasd', 'ROLE_USER');