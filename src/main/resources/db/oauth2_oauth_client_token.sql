create table oauth_client_token
(
    token_id          varchar(255) null,
    token             mediumtext   null,
    authentication_id varchar(255) not null
        primary key,
    user_name         varchar(255) null,
    client_id         varchar(255) null
);

