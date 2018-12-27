package br.com.sapri.lotepedidoerpgeradorcarga.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sapri.lotepedidoerpgeradorcarga.business.SkuBusiness;
import br.com.sapri.lotepedidoerpgeradorcarga.model.Sku;

@RestController
@RequestMapping("/sku")
public class SkuController {
	
	@Autowired
	private SkuBusiness business;
	
	@GetMapping
	List<Sku> list() {
		List<Sku> response = null;
		try {
			response = this.business.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	@PostMapping
	ResponseEntity<List<Sku>> mock() {
		List<Sku> mockList = new ArrayList<>();
		try {
			// inclui 10 sku's para cada produto
			for(Long i = 0l; i < 100l; i++) {
				for (Long k = 0l; k < 10l; k++) {
					Sku sku = new Sku();
					sku.setNumero(i * 2);
					sku.setCodigoBarras(i+1 * 11);
					sku.setProdutoId(i+1);
					sku.setPedidoId(i+1);
					mockList.add(sku);
				}				
			}
			mockList = this.business.saveAll(mockList);

			return ResponseEntity.status(HttpStatus.CREATED).body(mockList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
