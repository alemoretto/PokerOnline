package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.TavoloService;
import it.prova.pokeronline.service.UtenteService;

@Controller
@RequestMapping("/utente/play/*")
public class PlayController {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private TavoloService tavoloService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}
	
	@RequestMapping(value = "homePlay", method = RequestMethod.GET)
	public String homePlay(Model model, HttpSession session) {
		return "utente/play/homePlay";
	}

	@RequestMapping(value = "prepareRicarica", method = RequestMethod.GET)
	public String prepareRicarica(Model model, HttpSession session) {
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");

		model.addAttribute("creditoAccumulato", utenteInSession.getCreditoAccumulato());
		return "utente/play/ricarica";
	}

	@RequestMapping(value = "ricarica", method = RequestMethod.POST)
	public String ricarica(Model model, HttpSession session, HttpServletRequest request) {
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Double nuovoCredito = utenteInSession.getCreditoAccumulato();
		String erroreRicarica = "";
		try {
			nuovoCredito = Double.parseDouble(request.getParameter("nuovoCredito"));
			if (nuovoCredito < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			erroreRicarica = "Input non valido";
		}
		
		if (!erroreRicarica.equals("")) {
			model.addAttribute("erroreRicarica", erroreRicarica);
			model.addAttribute("creditoAccumulato", utenteInSession.getCreditoAccumulato());
			return "utente/play/ricarica";
		}

		utenteInSession = utenteService.caricaSingoloCompleto(utenteInSession.getId());
		utenteInSession.setCreditoAccumulato(nuovoCredito);
		utenteService.aggiorna(utenteInSession);
		session.setAttribute("userInfo", utenteService.caricaSingolo(utenteInSession.getId()));

		return "utente/play/homePlay";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "utente/play/search";
	}
	
	@RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
	public String list(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, Model model, HttpSession session) {
		
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Tavolo example = TavoloDTO.buildTavoloInstanceForFindPartita(tavoloDTOInstance);
		model.addAttribute("listTavoli", tavoloService.findByExamplePartita(example).stream().filter(t -> t.getEsperienzaMin() <= utenteInSession.getEsperienzaAccumulata()).collect(Collectors.toList()));

		return "utente/play/list";
	}
	
	@RequestMapping(value = "listByGiocatori", method = {RequestMethod.POST, RequestMethod.GET})
	public String listByGiocatori(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, Model model, HttpSession session) {
		
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Tavolo example = TavoloDTO.buildTavoloInstanceForFindPartita(tavoloDTOInstance);
//		model.addAttribute("listTavoli", tavoloService.findByExamplePartita(example).stream().filter(t -> t.getEsperienzaMin() <= utenteInSession.getEsperienzaAccumulata()).collect(Collectors.toList()));

//		model.addAttribute("listTavoli", tavoloService.findByExamplePartita(example));

		Set <Utente> set = new HashSet<>(0);
		for (Utente utente : example.getGiocatori()) {
			set.add(utenteService.findByUsername(utente.getUsername()));
		}
//		set.add(utenteService.findByUsername(tavoloDTOInstance.getPlayers()));
		if (set.size() > 0) {
			model.addAttribute("listTavoli", tavoloService.findByGiocatori(set));
			return "utente/play/list";
		}
		
		model.addAttribute("listTavoli", new ArrayList<>(0));
		return "utente/play/list";
	}
	
	@RequestMapping(value ="show", method = RequestMethod.GET)
    public String show(@RequestParam("idTavolo") Long idTavolo, Model model, HttpServletRequest request, HttpSession session){
		model.addAttribute("tavoloCommand", TavoloDTO.buildTavoloDTOInstance(tavoloService.caricaConGiocatori(idTavolo)));
        return "utente/play/showTavolo";
    }
	
	@RequestMapping(value ="siediti", method = RequestMethod.GET)
    public String siediti(@RequestParam("idTavolo") Long idTavolo, Model model, HttpServletRequest request, HttpSession session){
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Utente giocatore = utenteService.caricaSingolo(utenteInSession.getId());
		
		Double creditoAttuale = giocatore.getCreditoAccumulato();
		Tavolo tavoloDaGioco = tavoloService.caricaConGiocatori(idTavolo != null ? idTavolo : giocatore.getTavoloGiocato().getId() );
//		tavoloDaGioco.getGiocatori().add(giocatore);
		giocatore.setTavoloGiocato(tavoloDaGioco);
		giocatore.setInGioco(true);
		
		utenteService.aggiorna(giocatore);
//		tavoloService.aggiorna(tavoloDaGioco);
		session.setAttribute("userInfo", giocatore);
		request.setAttribute("creditoAttuale", creditoAttuale);
		
		
        return "utente/play/gioca";
    }
	
	@RequestMapping(value ="gioca", method = RequestMethod.GET)
    public String gioca(HttpServletRequest request, HttpSession session){
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Utente giocatore = utenteService.caricaSingolo(utenteInSession.getId());
		Double creditoAttuale = giocatore.getCreditoAccumulato();
		
		Double giocata = 100d;
		creditoAttuale = Math.random() < 0.5 ? creditoAttuale - giocata : creditoAttuale + giocata;
		
		giocatore.setCreditoAccumulato(creditoAttuale);
		utenteService.aggiorna(giocatore);
		request.setAttribute("creditoAttuale", creditoAttuale);

        return "utente/play/gioca";
    }
	
	@RequestMapping(value ="lascia", method = RequestMethod.GET)
    public String lascia(HttpServletRequest request, HttpSession session){
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Utente giocatore = utenteService.caricaSingolo(utenteInSession.getId());
		
		giocatore.setEsperienzaAccumulata(giocatore.getEsperienzaAccumulata() + 10);
		giocatore.setTavoloGiocato(null);
		giocatore.setInGioco(false);
		
		utenteService.aggiorna(giocatore);
		session.setAttribute("userInfo", giocatore);
        return "utente/play/homePlay";
    }
	
	@RequestMapping(value ="riprendi", method = RequestMethod.GET)
    public String riprendi(HttpServletRequest request, HttpSession session){
		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
		Utente giocatore = utenteService.caricaSingolo(utenteInSession.getId());
		
		request.setAttribute("idTavolo", giocatore.getTavoloGiocato().getId());
		request.setAttribute("creditoAttuale", giocatore.getCreditoAccumulato());
		session.setAttribute("userInfo", giocatore);
        return "utente/play/gioca";
    }
	
//	@RequestMapping(value = "list", method = {RequestMethod.POST, RequestMethod.GET})
//	public String list(@ModelAttribute("tavoloCommand") TavoloDTO tavoloDTOInstance, Model model, HttpSession session) {
//		
//		Utente utenteInSession = (Utente) session.getAttribute("userInfo");
//		Tavolo example = TavoloDTO.buildTavoloInstanceForFindPartita(tavoloDTOInstance);
////		model.addAttribute("listTavoli", tavoloService.findByExamplePartita(example).stream().filter(t -> t.getEsperienzaMin() <= utenteInSession.getEsperienzaAccumulata()).collect(Collectors.toList()));
//
////		model.addAttribute("listTavoli", tavoloService.findByExamplePartita(example));
//
//		Set <Utente> set = new HashSet<>();
//		for (Utente utente : example.getGiocatori()) {
//			set.add(utenteService.findByUsername(utente.getUsername()));
//		}
////		set.add(utenteService.findByUsername(tavoloDTOInstance.getPlayers()));
//		model.addAttribute("listTavoli", tavoloService.findByGiocatori(set));
//		
//		return "utente/play/list";
//	}
}
