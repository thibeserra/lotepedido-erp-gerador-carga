package br.com.sapri.lotepedidoerpgeradorcarga.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Sku;
import br.com.sapri.lotepedidoerpgeradorcarga.repository.SkuRepository;

@Service
public class SkuBusiness {

	@Autowired
	private SkuRepository repository;
	
	public List<Sku> list() {
		return repository.findAll();
	}
	
	public List<Sku> saveAll(List<Sku> skuList) {
		return this.repository.saveAll(skuList);
	}
}
