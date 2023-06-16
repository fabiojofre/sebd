package com.jofre.sebd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.sebd.domain.Filial;
import com.jofre.sebd.domain.Pessoa;
import com.jofre.sebd.domain.UF;
import com.jofre.sebd.service.FilialService;
import com.jofre.sebd.service.PessoaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ebf2023")
public class EbfController {


	@Autowired
	private PessoaService pessoaService;

		
	@Autowired
	private FilialService filialService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/ebf/cadastro";
	}

		
	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/ebf/cadastro";
		}
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success","Inscrição efetuada com sucesso. Número de incrição: "+pessoa.getId());
		return "redirect:/ebf2023/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "ebf/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/ebf/cadastro";
		}
		pessoaService.editar(pessoa);
		attr.addFlashAttribute("success","Pessoa atualizada com sucesso.");
		return "redirect:/ebf2023/cadastrar";
	}
	
	

	@ModelAttribute("filiais")
	public List<Filial>listaDeFiliais(){
		return filialService.buscarTodos();
	}
	 
	
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
