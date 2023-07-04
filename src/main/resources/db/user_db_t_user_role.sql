create table t_user_role
(
    user_id     varchar(32)  not null,
    role_id     varchar(32)  not null,
    create_time datetime     null,
    creator     varchar(255) null,
    primary key (user_id, role_id)
);

INSERT INTO user_db.t_user_role (user_id, role_id, create_time, creator) VALUES ('1', '1', null, null);