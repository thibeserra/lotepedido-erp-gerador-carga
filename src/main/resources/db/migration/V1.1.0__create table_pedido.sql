create table pedido (
    id bigint primary key auto_increment,
    numero int(11) not null,
    data_geracao datetime not null,
    lote_id bigint default null,
    FOREIGN KEY (lote_id) REFERENCES lote(id)
)engine=InnoDB;
