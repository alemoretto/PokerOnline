package it.prova.pokeronline.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.UtenteService;

@Controller
@RequestMapping("/utente/*")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	public String login() {
		
	}
	
}
