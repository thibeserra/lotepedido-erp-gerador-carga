package br.com.sapri.lotepedidoerpgeradorcarga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
