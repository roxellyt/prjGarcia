package com.app.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
