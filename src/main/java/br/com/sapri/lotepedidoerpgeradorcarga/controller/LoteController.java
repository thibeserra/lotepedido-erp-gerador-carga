package br.com.sapri.lotepedidoerpgeradorcarga.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sapri.lotepedidoerpgeradorcarga.business.LoteBusiness;
import br.com.sapri.lotepedidoerpgeradorcarga.model.Lote;

@RestController
@RequestMapping("/lote")
public class LoteController {

	@Autowired
	private LoteBusiness business;

	@GetMapping
	List<Lote> list() {
		List<Lote> response = null;
		try {
			response = this.business.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	@PostMapping
	ResponseEntity<List<Lote>> mock() {
		List<Lote> mockList = new ArrayList<>();
		try {
			for (Long i = 0l; i < 10l; i++) {
				Lote lote = new Lote();
				lote.setNumero(i * 2);
				lote.setDataGeracao(new Date());
				lote.setStatus("N");
				mockList.add(lote);
			}
			mockList = this.business.saveAll(mockList);

			return ResponseEntity.status(HttpStatus.CREATED).body(mockList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
