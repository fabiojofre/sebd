package com.jofre.sebd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.sebd.domain.Filial;
import com.jofre.sebd.service.FilialService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/filiais")
public class FilialController {
	
	@Autowired
	private FilialService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Filial filial) {
		return "/filial/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("filiais", service.buscarTodos());
		return "/filial/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Filial filial, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/filial/cadastro";
		}
		service.salvar(filial);
		attr.addFlashAttribute("success","Filial cadastrada com sucesso.");
		return "redirect:/filiais/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("filial", service.buscarPorId(id));
		return "/filial/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Filial filial,  BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/filial/cadastro";
		}
		service.editar(filial);
		attr.addFlashAttribute("success","Filial editada com sucesso.");
		return "redirect:/filiais/cadastrar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Integer id, ModelMap model) {
		if(service.filialTemPessoa(id)) {
			model.addAttribute("fail", "Filial não removida. Possui pessoa(s) vinculada(s)");
		}else {
			
			service.excluir(id);
			model.addAttribute("success", "Filial removida com sucesso.");
		}
		return listar(model);
		
	}
	
}
