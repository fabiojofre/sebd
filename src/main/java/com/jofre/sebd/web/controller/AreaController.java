package com.jofre.sebd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jofre.sebd.domain.Area;
import com.jofre.sebd.service.AreaService;

@Controller
@RequestMapping("/areas")
public class AreaController {
	
	@Autowired
	private AreaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Area area) {
		return "/area/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("areas", service.buscarTodos());
		return "/area/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Area area, RedirectAttributes attr) {
		service.salvar(area);
		attr.addFlashAttribute("success","Área cadastrada com sucesso.");
		return "redirect:/areas/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("area", service.buscarPorId(id));
		return "/area/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Area area, RedirectAttributes attr) {
		service.editar(area);
		attr.addFlashAttribute("success","Área editada com sucesso.");
		return "redirect:/areas/cadastrar";
		
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Integer id, ModelMap model) {
		if(service.areaTemCongregacao(id)) {
			model.addAttribute("fail", "Área não removida. Possui congregação(ões) vinculada(s)");
		}else {
			
			service.excluir(id);
			model.addAttribute("success", "Área removida com sucesso.");
		}
		return listar(model);
		
	}
	
}
