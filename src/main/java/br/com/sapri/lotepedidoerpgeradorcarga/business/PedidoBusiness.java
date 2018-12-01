package br.com.sapri.lotepedidoerpgeradorcarga.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Pedido;
import br.com.sapri.lotepedidoerpgeradorcarga.repository.PedidoRepository;

@Service
public class PedidoBusiness {
	
	@Autowired
	private PedidoRepository repository;
	
	public List<Pedido> list() {
		return repository.findAll();
	}
	
	public List<Pedido> saveAll(List<Pedido> pedidoList) {
		return this.repository.saveAll(pedidoList);
	}
}
