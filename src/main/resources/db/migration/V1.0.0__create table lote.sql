create table lote (
   id bigint primary key auto_increment,
    numero int(11) not null,
    status varchar(1) not null default 'N',
    data_geracao datetime not null
)engine=InnoDB;
