# SpringBoot-Cassandra
Simple Youtube Service Backend, Data modeling using Cassandra. Tech : Cassandra + Rest + Spring Boot...

//Execute following scripts in your cassandra database.

Scripts
--------

CREATE TABLE video_by_tag (
	tag text, 
	videoid uuid, 
	added_date timestamp, 
	name text, 
	tagged_date timestamp, 
	PRIMARY_KEY(tag, videoid)
);


CREATE TABLE videos (
	videoid uuid, 
	userid uuid, 
	name varchar, 
	description varchar, 
	preview_images map<text, text>, 
	tags set<varchar>, 
	added_date timestamp, 
	PRIMARY KEY(videoid)
);

CREATE TABLE user_login (
	email text,
	userid uuid,
	password text,
	PRIMARY KEY(email)
);

CREATE TABLE users (
	userid uuid,
	firstname text,
	email text,
	lastname text,
	created_date timestamp,
	PRIMARY KEY(userid)
);
