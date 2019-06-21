package it.prova.pokeronline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.UtenteService;

@Controller
public class HomeController {
	
	@Autowired
	private UtenteService utenteService;
//	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(HttpSession session) {
//		return new ModelAndView("login");
	Utente utenteInSession = (Utente) session.getAttribute("userInfo");
	
	if (utenteInSession == null) {
		return new ModelAndView("login");
//		return "login";
	}
	return new ModelAndView("utente/home");
//		return "utente/home";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("utenteCommand") Utente utenteInstance, Model model, HttpSession session) {
		
		Utente utenteCheAccede = utenteService.eseguiAccesso(utenteInstance.getUsername(), utenteInstance.getPassword());
		if(utenteCheAccede != null) {
			session.setAttribute("userInfo", utenteCheAccede);
			return new ModelAndView("utente/home");
		}
		
		return new ModelAndView("login");
	}


}
