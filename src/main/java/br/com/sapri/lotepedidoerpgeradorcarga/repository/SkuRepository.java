package br.com.sapri.lotepedidoerpgeradorcarga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {

}
