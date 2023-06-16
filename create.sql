create table area (id serial not null, nome varchar(8) not null unique, primary key (id));
create table congregacao (id serial not null, id_area integer not null, nome varchar(60) not null, primary key (id));
create table endereco (id serial not null, uf varchar(2) check (uf in ('AC','AL','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG','PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO')), numero varchar(5), cep varchar(9), bairro varchar(255), cidade varchar(255), complemento varchar(255), logradouro varchar(255), primary key (id));
create table filial (id serial not null, nome varchar(60) not null unique, primary key (id));
create table pessoa (area_numero integer not null, conferido boolean, filial_id integer not null, id serial not null, cartao_membro bigint not null, nome varchar(60) not null, nome_congregacao varchar(60) not null, funcao varchar(255), telefone varchar(255) not null, primary key (id));
alter table if exists congregacao add constraint FKqs9oj7m040jnsi1edq6fwho85 foreign key (id_area) references area;
alter table if exists pessoa add constraint FKkse6nmaob6bms0020vv0abnye foreign key (filial_id) references filial;
