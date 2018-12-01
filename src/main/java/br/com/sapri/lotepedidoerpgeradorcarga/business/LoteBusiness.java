package br.com.sapri.lotepedidoerpgeradorcarga.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sapri.lotepedidoerpgeradorcarga.model.Lote;
import br.com.sapri.lotepedidoerpgeradorcarga.repository.LoteRepository;

@Service
public class LoteBusiness {
	
	@Autowired
	private LoteRepository repository;
	
	public List<Lote> list() {
		return repository.findAll();
	}
	
	public List<Lote> saveAll(List<Lote> loteList) {
		return this.repository.saveAll(loteList);
	}
	
}
