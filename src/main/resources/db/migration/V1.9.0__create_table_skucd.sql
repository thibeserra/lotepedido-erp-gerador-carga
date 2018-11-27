create table skucd (
    id bigint primary key auto_increment,
    numero int(11) not null,
    codigo_barras int(12) not null,
    produtocd_id int(11),
    FOREIGN KEY (produtocd_id) REFERENCES produtocd(id)
)engine=InnoDB;
