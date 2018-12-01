create table pedido_sku (
    id bigint primary key auto_increment,
    pedido_id bigint not null,
    sku_id bigint not null,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (sku_id) REFERENCES sku(id)
)engine=InnoDB;
