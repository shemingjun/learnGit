create table oauth_client_details
(
    client_id               varchar(255)  not null
        primary key,
    resource_ids            varchar(255)  null,
    client_secret           varchar(255)  null,
    scope                   varchar(255)  null,
    authorized_grant_types  varchar(255)  null,
    web_server_redirect_uri varchar(255)  null,
    authorities             varchar(255)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(5000) null,
    autoapprove             varchar(255)  null
);

INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('book', 'all', '$2a$10$aS5vr3cb54H6mYAYce0bLeVQdv54Y2XwMGx3BWlDSodqSLetgNrxi', 'all', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', 'All', 7200, 7200, '{}', '1');
INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('jdbcclient', 'all', '112233', 'all', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', 'All', 100, 7200, '{}', '1');
INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('jwtclient', 'all', '$2a$10$Y5w/9PJFEiGgZbPMTuitqeNu3hroZcGRk9KxTNTzcvnu5wZq011sC', 'all', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', 'All', 7200, 7200, '{}', '1');
INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('redisclient', 'all', '$2a$10$oAn/751b5vhOMnL6nbPPpOaC31BdcYhtoP7Ru4lqhZ7hkdgSLMPcK', 'all', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', 'All', 7200, 7200, '{}', '1');
INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('smj', 'all', '$2a$10$EmrM4sWgCGNLNihriHPKBOe9dMHaJYKORKTGDVxSOa.ViYd.NUg96', 'all', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', 'All', 7200, 7200, '{}', '1');