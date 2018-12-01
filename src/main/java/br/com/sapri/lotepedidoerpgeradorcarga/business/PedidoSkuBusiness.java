package br.com.sapri.lotepedidoerpgeradorcarga.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sapri.lotepedidoerpgeradorcarga.model.PedidoSku;
import br.com.sapri.lotepedidoerpgeradorcarga.repository.PedidoSkuRepository;

@Service
public class PedidoSkuBusiness {

	@Autowired
	private PedidoSkuRepository repository;
	
	public List<PedidoSku> list() {
		return repository.findAll();
	}
	
	public List<PedidoSku> saveAll(List<PedidoSku> pedidoSkuList) {
		return this.repository.saveAll(pedidoSkuList);
	}
	
}
