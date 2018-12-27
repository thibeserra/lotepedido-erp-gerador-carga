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

import br.com.sapri.lotepedidoerpgeradorcarga.business.PedidoSkuBusiness;
import br.com.sapri.lotepedidoerpgeradorcarga.model.PedidoSku;

@RestController
@RequestMapping("/pedidosku")
public class PedidoSkuController {

	@Autowired
	private PedidoSkuBusiness business;
	
	@GetMapping
	List<PedidoSku> list() {
		List<PedidoSku> response = null;
		try {
			response = this.business.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	@PostMapping
	ResponseEntity<List<PedidoSku>> mock() {
		List<PedidoSku> mockList = new ArrayList<>();
		try {
			// inclui 10 sku's em cada pedido
			for (Long i = 0l; i < 100l; i++) { // pedido
				for(Long k = 0l; k < 10l; k++) { // sku
					PedidoSku pedidoSku = new PedidoSku();
					pedidoSku.setPedidoId(i+1);
					pedidoSku.setSkuId(k+1);
					mockList.add(pedidoSku);
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
