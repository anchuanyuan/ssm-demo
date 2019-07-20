create table user
(
    ID           int auto_increment
        primary key,
    ACCOUNT      varchar(100) null,
    NAME         varchar(50)  null,
    TOKEN        varchar(100) null,
    GMT_CREATE   bigint       null,
    GMT_MODIFIED bigint       null
);
