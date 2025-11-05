create sequence bookmark_seq start with 1 increment by 1;
create table bookmarks (
    id bigint default nextval('bookmark_seq') not null,
    created_at timestamp(6) with time zone not null,
    title varchar(255) not null,
    url varchar(255) not null,
    primary key (id)
 );

