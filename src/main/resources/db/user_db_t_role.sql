create table t_role
(
    id          varchar(32)  not null
        primary key,
    role_name   varchar(255) null,
    description varchar(255) null,
    create_time datetime     null,
    update_time datetime     null,
    status      char         not null,
    constraint unique_role_name
        unique (role_name)
);

INSERT INTO user_db.t_role (id, role_name, description, create_time, update_time, status) VALUES ('1', '管理员', null, null, null, '');