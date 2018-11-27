create table pedido_sku (
    id bigint primary key auto_increment,
    pedido_id int(11),
    sku_id int(11),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (sku_id) REFERENCES sku(id),
)engine=InnoDB;
