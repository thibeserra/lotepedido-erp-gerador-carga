create table sku (
    id bigint primary key auto_increment,
    numero int(11) not null,
    codigo_barras int(12) not null,
    produto_id int(11),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
)engine=InnoDB;
