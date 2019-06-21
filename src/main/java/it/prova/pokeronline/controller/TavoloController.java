package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.TavoloService;

@Controller
@RequestMapping("/utente/tavolo/*")
public class TavoloController {

	@Autowired
	private TavoloService tavoloService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "utente/tavolo/search";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, Model model, HttpSession session) {
		
		Tavolo example = TavoloDTO.buildTavoloInstanceForFindByExample(tavoloDTOInstance);
		example.setCreatore((Utente) session.getAttribute("userInfo"));
		model.addAttribute("listTavoli", tavoloService.findByExample(example));
		return "utente/tavolo/list";
	}
}
