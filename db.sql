create table comment
(
    id          int auto_increment,
    nickname    varchar(20)  null,
    content     text         null,
    avatar      varchar(255) null,
    create_time datetime     null,
    blog_id     int          null,
    title       varchar(20)  null,
    constraint comment_id_uindex
        unique (id)
);

alter table comment
    add primary key (id);

create table db_blog
(
    id       int auto_increment,
    title    varchar(100) null,
    content  text         null,
    poster   varchar(20)  null,
    likes    int          null,
    postTime datetime     null,
    image    text         null,
    posterId int          null,
    avatar   varchar(255) null,
    constraint db_blog_id_uindex
        unique (id)
);

alter table db_blog
    add primary key (id);

create table db_top
(
    id       int auto_increment,
    title    varchar(100) null,
    content  text         null,
    poster   varchar(20)  null,
    likes    int          null,
    postTime datetime     null,
    image    varchar(255) null,
    posterId int          null,
    constraint db_top_id_uindex
        unique (id)
);

alter table db_top
    add primary key (id);

create table db_user
(
    id       int auto_increment
        primary key,
    username varchar(20)  not null,
    password varchar(20)  not null,
    avater   varchar(255) null
);

create table goods
(
    id          int auto_increment,
    name        varchar(20)  not null,
    image       varchar(255) null,
    seller      varchar(20)  null,
    description text         null,
    state       varchar(20)  null,
    datetime    datetime     null,
    avatar      varchar(255) null,
    constraint goods_id_uindex
        unique (id)
);

alter table goods
    add primary key (id);

create table team
(
    team_id       int auto_increment,
    leader        varchar(20) not null,
    teamMsg       text        null,
    leader_avatar varchar(20) null,
    max_num       int         null,
    constraint team_team_id_uindex
        unique (team_id)
);

alter table team
    add primary key (team_id);

create table team_members
(
    member_id  int auto_increment,
    team_id    int         not null,
    memberName varchar(20) null,
    role       varchar(20) not null,
    state      varchar(10) null,
    avatar     varchar(20) null,
    constraint team_members_member_id_uindex
        unique (member_id)
);

alter table team_members
    add primary key (member_id);

create table top_comment
(
    id          int auto_increment,
    nickname    varchar(20)  null,
    content     text         null,
    avatar      varchar(255) null,
    create_time datetime     null,
    blog_id     int          null,
    title       varchar(20)  null,
    constraint top_comment_id_uindex
        unique (id)
);

alter table top_comment
    add primary key (id);

