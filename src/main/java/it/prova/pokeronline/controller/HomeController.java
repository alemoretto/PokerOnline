package it.prova.pokeronline.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.prova.pokeronline.dto.RuoloDTO;
import it.prova.pokeronline.dto.StatoUtenzaDTO;
import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.StatoUtenza;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.RuoloService;
import it.prova.pokeronline.service.StatoUtenzaService;
import it.prova.pokeronline.service.UtenteService;
import it.prova.pokeronline.validator.NewUtenteValidator;
import it.prova.pokeronline.validator.TavoloValidator;

@Controller
public class HomeController {

	@Autowired
	private UtenteService utenteService;
	@Autowired
	private RuoloService ruoloService;
	@Autowired
	private StatoUtenzaService statoUtenzaService;
	
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
	public ModelAndView login(@ModelAttribute("utenteCommand") Utente utenteInstance, Model model,
			HttpSession session) {

		Utente utenteCheAccede = utenteService.eseguiAccesso(utenteInstance.getUsername(),
				utenteInstance.getPassword());
		if (utenteCheAccede != null) {
			session.setAttribute("userInfo", utenteService.caricaSingoloConStatoERuoli(utenteCheAccede.getId()));
			return new ModelAndView("utente/home");
		}

		return new ModelAndView("login");
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {

		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Utente giocatore = utenteService.caricaSingolo(utenteInSession.getId());
		
		giocatore.setTavoloGiocato(null);
		giocatore.setInGioco(false);
		
		utenteService.aggiorna(giocatore);
		session.invalidate();

		return new ModelAndView("login");
	}

	@RequestMapping(value = "prepareSignup", method = RequestMethod.GET)
	public String prepareSignup( Model model) {

		model.addAttribute("utenteCommand", new UtenteDTO());
		return "signup";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("utenteCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {

		utenteDTOInstance.setDataRegistrazione(new Date());
//		utenteDTOInstance.getRuoli().add(RuoloDTO.buildRuoloDTOInstance(ruoloService.findByCodice(Ruolo.CLASSIC_PLAYER_ROLE)));
		utenteDTOInstance.getRuoli().add(new RuoloDTO(2L));
		utenteDTOInstance.setStatoUtenza(StatoUtenzaDTO.buildStatoUtenzaDTOInstance(statoUtenzaService.findByCodice(StatoUtenza.CREATO)));
		// se la validazione fallisce
		
		
		new NewUtenteValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			return "signup";
		}

		if (utenteService.findByUsername(utenteDTOInstance.getUsername()) != null) {
			request.setAttribute("erroreUsername", "Questo username non è disponibile");
			return "signup";
		}

		Utente nuovoUtente = UtenteDTO.buildUtenteInstance(utenteDTOInstance);
		utenteService.inserisciNuovo(nuovoUtente);
		return "login";

	}
}
