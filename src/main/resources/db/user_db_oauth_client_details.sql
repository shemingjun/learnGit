create table oauth_client_details
(
    client_id               varchar(255)                        not null comment '客户端标
识'
        primary key,
    resource_ids            varchar(255)                        null comment '接入资源列表',
    client_secret           varchar(255)                        null comment '客户端秘钥',
    scope                   varchar(255)                        null,
    authorized_grant_types  varchar(255)                        null,
    web_server_redirect_uri varchar(255)                        null,
    authorities             varchar(255)                        null,
    access_token_validity   int                                 null,
    refresh_token_validity  int                                 null,
    additional_information  longtext                            null,
    create_time             timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    archived                tinyint                             null,
    trusted                 tinyint                             null,
    autoapprove             varchar(255)                        null
)
    comment '接入客户端信息';

INSERT INTO user_db.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, create_time, archived, trusted, autoapprove) VALUES ('c1', 'res1', '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', 'ROLE_ADMIN,ROLE_USER,ROLE_API', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', null, 7200, 259200, null, '2023-07-03 09:50:03', 0, 0, 'false');
INSERT INTO user_db.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, create_time, archived, trusted, autoapprove) VALUES ('c2', 'res2', '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', 'ROLE_API', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', null, 31536000, 2592000, null, '2023-07-03 09:50:03', 0, 0, 'false');