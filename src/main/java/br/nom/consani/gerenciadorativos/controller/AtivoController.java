package br.nom.consani.gerenciadorativos.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.nom.consani.gerenciadorativos.model.Ativo;
import br.nom.consani.gerenciadorativos.model.Categoria;
import br.nom.consani.gerenciadorativos.repositorio.Ativos;

@Controller
//@RequestMapping("/ativos")
public class AtivoController {
	
	@Autowired
	private Ativos ativos;
		
	@RequestMapping("/ativos/novo")
	public ModelAndView nova(){
		ModelAndView mv = new ModelAndView("CadastroAtivo");
		mv.addObject(new Ativo());
		return mv;
	}
	
	@RequestMapping(path="/ativos", method = RequestMethod.POST)
	public String salvar(@Validated Ativo ativo, Errors errors, RedirectAttributes attributes) {
		System.out.println(ativo);
		
		if (errors.hasErrors()) {
			return "CadastroAtivo";
		}
		
		try {
			ativos.save(ativo);
			attributes.addFlashAttribute("mensagem", "Ativo salvo com sucesso!");
			return "redirect:/ativos/novo";
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("data", null, "Formato de data inválido!");
			return "CadastroAtivo";
		}		
	}

	@RequestMapping(path="/ativos", method=RequestMethod.GET)
	public ModelAndView ativos(@RequestParam(defaultValue="") String descricao){
		List<Ativo> listaAtivos = null;
		
		if(descricao == null || descricao.isBlank()) {
			listaAtivos = ativos.findAll();
		}else {
			listaAtivos = ativos.findByDescricaoContainingIgnoreCase(descricao);
		}
		
		
		ModelAndView mv = new ModelAndView("ListagemAtivos");
		mv.addObject("ativos",listaAtivos);
		return mv;
	}
	
	@RequestMapping(value="/ativos/{codigo}")//, method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo ) {
		ativos.deleteById(codigo);
		return "redirect:/ativos";
	}
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String Login() {
		return "Login";
	}
	
	
	@ModelAttribute("todasCategorias")
	public List<Categoria> todasCategorias(){
		return Arrays.asList(Categoria.values());
	}
	
	
}
