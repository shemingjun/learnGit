create table oauth_approvals
(
    userId         varchar(255)                        null,
    clientId       varchar(255)                        null,
    scope          varchar(255)                        null,
    status         varchar(10)                         null,
    expiresAt      timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    lastModifiedAt timestamp default CURRENT_TIMESTAMP null
);

