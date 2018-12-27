create table sku (
    id bigint primary key auto_increment,
    numero int(11) not null,
    codigo_barras int(12) not null,
    produto_id bigint not null,
    pedido_id bigint not null,
    FOREIGN KEY(produto_id) REFERENCES produto(id),
    FOREIGN KEY(pedido_id) REFERENCES pedido(id)
)engine=InnoDB;
