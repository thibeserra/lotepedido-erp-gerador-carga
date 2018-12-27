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

import br.com.sapri.lotepedidoerpgeradorcarga.business.ProdutoBusiness;
import br.com.sapri.lotepedidoerpgeradorcarga.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoBusiness business;
	
	@GetMapping
	List<Produto> list() {
		List<Produto> response = null;
		try {
			response = this.business.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return response;
	}

	@PostMapping
	ResponseEntity<List<Produto>> mock() {
		List<Produto> mockList = new ArrayList<>();
		try {
			for (Long i = 0l; i < 100l; i++) {
				Produto produto = new Produto();
				produto.setNumero(i * 2);
				produto.setDescricao("Produto Mock " + i+1);
				mockList.add(produto);
			}
			mockList = this.business.saveAll(mockList);

			return ResponseEntity.status(HttpStatus.CREATED).body(mockList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
