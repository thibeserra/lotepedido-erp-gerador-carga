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

import br.com.sapri.lotepedidoerpgeradorcarga.business.PedidoBusiness;
import br.com.sapri.lotepedidoerpgeradorcarga.model.Lote;
import br.com.sapri.lotepedidoerpgeradorcarga.model.Pedido;

@RestController()
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoBusiness business;
	
	@GetMapping
	List<Pedido> list() {
		List<Pedido> response = null;
		try {
			response = this.business.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}
	
	@PostMapping
	ResponseEntity<List<Pedido>> mock() {
		List<Pedido> mockList = new ArrayList<>();
		try {
			
			// 10 pedidos para cada lote
			for(Long i = 0l; i < 10l; i++) {
				for (Long k = 0l; k < 10l; k++) {
					Pedido pedido = new Pedido();
					pedido.setNumero(i+k+1 * 2);
					pedido.setDataGeracao(new Date());
					pedido.setLoteId(i+1);
					mockList.add(pedido);
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
