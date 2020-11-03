package com.app.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.app.app.model.Produtos;
import com.app.app.repository.ProdutoRepository;


@Controller	
public class HomeController {

	@Autowired
	private ProdutoRepository  produtoRepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		Produtos pedido = new Produtos();
	
		
		List<Produtos> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		
		return "home";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(Long id) {
	
		if(id == null) {
			return "home";
		}
		
		return "home";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(Long id) {
	
		if(id == null) {
			return "home";
		}
		
		Produtos produto = new Produtos();
		
		if(produtoRepository.findById(id) != null) {
			produtoRepository.deleteById(id);
		}
	
		return "home";
	}
}
