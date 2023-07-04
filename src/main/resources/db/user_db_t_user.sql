create table t_user
(
    id       bigint       not null comment '用户id'
        primary key,
    username varchar(64)  not null,
    password varchar(64)  not null,
    fullname varchar(255) not null comment '用户姓名',
    mobile   varchar(11)  null comment '手机号'
);

