create table t_permission
(
    id          varchar(32)  not null
        primary key,
    code        varchar(32)  not null comment '权限标识符',
    description varchar(64)  null comment '描述',
    url         varchar(128) null comment '请求地址'
);

INSERT INTO user_db.t_permission (id, code, description, url) VALUES ('1', 'p1', '测试资源
1', '/r/r1');
INSERT INTO user_db.t_permission (id, code, description, url) VALUES ('2', 'p3', '测试资源2', '/r/r2');