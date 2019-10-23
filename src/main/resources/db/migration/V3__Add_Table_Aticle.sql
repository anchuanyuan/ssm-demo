create table aticle
(
	title varchar(256) not null,
	description text not null,
	tag varchar(10) null,
	comment varchar(256)  null,
	comment_count long  null,
	view_count long null,
	gmt_cteat bigint null,
	gmt_modified bigint null,
	id int not null,
	constraint table_name_pk
		primary key (id)
);
