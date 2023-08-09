create table user
(
    id       int auto_increment
        primary key,
    username varchar(50)  null,
    password varchar(50)  null,
    age      int          null,
    mark     varchar(255) null
);

INSERT INTO oauth2.user (id, username, password, age, mark) VALUES (1, 'wang', 'wang', 30, '30');