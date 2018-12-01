package br.com.sapri.lotepedidoerpgeradorcarga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
