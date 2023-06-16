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
@RequestMapping("/pessoas")
public class PessoaController {


	@Autowired
	private PessoaService pessoaService;

		
	@Autowired
	private FilialService filialService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pessoa pessoa) {
		return "/pessoa/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarTodos());
		return "/pessoa/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/pessoa/cadastro";
		}
		pessoaService.salvar(pessoa);
		attr.addFlashAttribute("success","Pessoa cadastrada com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("pessoa", pessoaService.buscarPorId(id));
		return "pessoa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "/pessoa/cadastro";
		}
		pessoaService.editar(pessoa);
		attr.addFlashAttribute("success","Pessoa atualizada com sucesso.");
		return "redirect:/pessoas/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
			pessoaService.excluir(id);
			attr.addFlashAttribute("success","Cadastro excluido com sucesso.");
		return "redirect:/pessoas/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarPorNome(nome));
		return "/pessoa/lista";
	}
	
	@GetMapping("/buscar/filial")
	public String getPorFilial(@RequestParam("id") Integer id, ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarPorFilial(id));
		return "/pessoa/lista";
	}
	
	@GetMapping("/buscar/cartao")
	public String getPorCartao(@RequestParam("cartaoMembro") Long cartaoMembro, ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarPorCartao(cartaoMembro));
		return "/pessoa/lista";
	}
	@GetMapping("/buscar/telefone")
	public String getPorTelefone(@RequestParam("telefone") String telefone, ModelMap model) {
		model.addAttribute("pessoas", pessoaService.buscarPorTelefone(telefone));
		return "/pessoa/lista";
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
