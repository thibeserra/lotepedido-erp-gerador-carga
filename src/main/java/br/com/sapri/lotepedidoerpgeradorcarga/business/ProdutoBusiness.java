package br.com.sapri.lotepedidoerpgeradorcarga.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Produto;
import br.com.sapri.lotepedidoerpgeradorcarga.repository.ProdutoRepository;

@Service
public class ProdutoBusiness {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> list() {
		return repository.findAll();
	}
	
	public List<Produto> saveAll(List<Produto> produtoList) {
		return this.repository.saveAll(produtoList);
	}
	
}
