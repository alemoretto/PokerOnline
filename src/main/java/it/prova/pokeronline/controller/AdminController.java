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
import org.springframework.web.bind.annotation.RequestParam;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.UtenteService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private UtenteService utenteService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "admin/search";
	}
	
	@RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
	public String list(@ModelAttribute("utenteCommand") UtenteDTO utenteDTOInstance, Model model) {

		Utente example = UtenteDTO.buildUtenteInstanceForFindByExample(utenteDTOInstance);
		model.addAttribute("listUtenti", utenteService.findByExample(example));
		return "admin/list";
	}
	
	@RequestMapping(value ="show", method = RequestMethod.GET)
    public String show(@RequestParam("idUtente") Long idUtente, Model model){
		model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingolo(idUtente)));
        return "admin/show";
    }
}
