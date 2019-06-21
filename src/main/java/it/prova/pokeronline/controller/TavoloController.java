package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.TavoloService;
import it.prova.pokeronline.validator.TavoloValidator;

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

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("tavoloCommand", new TavoloDTO());
		return "utente/tavolo/create";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, BindingResult result, Model model, HttpSession session
	/* ,HttpServletRequest req */) {

		tavoloDTOInstance.setDataCreazione(new Date());
		// se la validazione fallisce
		new TavoloValidator().validate(tavoloDTOInstance, result);
		if (result.hasErrors()) {
			return "utente/tavolo/create";
		}
		
		Tavolo nuovoTavolo = TavoloDTO.buildTavoloInstanceForFindByExample(tavoloDTOInstance);
		nuovoTavolo.setCreatore((Utente) session.getAttribute("userInfo"));
		tavoloService.inserisciNuovo(nuovoTavolo);
		model.addAttribute("listTavoli", tavoloService.listMieiTavoli((Utente) session.getAttribute("userInfo")));
		return "utente/tavolo/list";
	}
	
}
