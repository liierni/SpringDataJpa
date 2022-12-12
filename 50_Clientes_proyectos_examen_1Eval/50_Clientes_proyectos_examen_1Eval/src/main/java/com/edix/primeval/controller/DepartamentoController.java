package com.edix.primeval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.primeval.modelo.dao.DepartamentoDao;

@Controller
@RequestMapping("/dep")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoDao ddao;
	
	@GetMapping("/verUno/{id}")
	public String verUno(@PathVariable("id") int idDepar, Model model) {
		
		model.addAttribute("departamento", ddao.findById(idDepar));
		return "pruebas";
	}

}
