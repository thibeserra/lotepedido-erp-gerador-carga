create table pedidocd_skucd (
    id bigint primary key auto_increment,
    pedidocd_id int(11),
    skucd_id int(11),
    FOREIGN KEY (pedidocd_id) REFERENCES pedidocd(id),
    FOREIGN KEY (skucd_id) REFERENCES skucd(id)
)engine=InnoDB;
