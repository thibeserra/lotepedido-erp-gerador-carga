create table lotecd (
   id bigint primary key auto_increment,
    numero int(11) not null,
    data_geracao datetime not null,
    cargacd_id int (11),
    FOREIGN KEY (cargacd_id) REFERENCES cargacd(id)
)engine=InnoDB;

