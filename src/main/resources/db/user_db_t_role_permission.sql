create table t_role_permission
(
    role_id       varchar(32) not null,
    permission_id varchar(32) not null,
    primary key (role_id, permission_id)
);

INSERT INTO user_db.t_role_permission (role_id, permission_id) VALUES ('1', '1');
INSERT INTO user_db.t_role_permission (role_id, permission_id) VALUES ('1', '2');