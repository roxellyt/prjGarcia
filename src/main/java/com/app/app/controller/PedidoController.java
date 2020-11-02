package com.app.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.app.dtoIn.PedidoDTO;
import com.app.app.model.Produtos;
import com.app.app.repository.ProdutoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}	
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDTO pedido, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Produtos pedidoDTO = pedido.toProduto();
		produtoRepository.save(pedidoDTO);
		
		return "pedido/formulario";
	}
}
