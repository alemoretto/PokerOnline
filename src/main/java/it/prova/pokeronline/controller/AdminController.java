package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;

import it.prova.pokeronline.dto.RuoloDTO;
import it.prova.pokeronline.dto.StatoUtenzaDTO;
import it.prova.pokeronline.dto.StatoUtenzaDTOEditor;
import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.RuoloService;
import it.prova.pokeronline.service.StatoUtenzaService;
import it.prova.pokeronline.service.UtenteService;
import it.prova.pokeronline.validator.AdminValidator;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private StatoUtenzaService statoUtenzaService;
	
	@Autowired
	private RuoloService ruoloService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
		binder.registerCustomEditor(StatoUtenzaDTO.class, new StatoUtenzaDTOEditor());
//		binder.registerCustomEditor(RuoloDTO.class, new RuoloDTOEditor());
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
		model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingoloCompleto(idUtente)));
        return "admin/show";
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
//		model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza());
		model.addAttribute("listRuoli", ruoloService.listAllRuoli().stream().map(r -> RuoloDTO.buildRuoloDTOInstance(r)).collect(Collectors.toList()));
//		model.addAttribute("listRuoli", ruoloService.listAllRuoli());
		model.addAttribute("utenteCommand", new UtenteDTO());
		return "admin/create";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("utenteCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model,
			HttpSession session,HttpServletRequest request) {

		String[] ruoliString = request.getParameterValues("ruoliInput");
		utenteDTOInstance.setRuoli(RuoloDTO.buildSetFromStringArray(ruoliString,ruoloService.listAllRuoli().stream().map(r -> RuoloDTO.buildRuoloDTOInstance(r)).collect(Collectors.toList())));
		utenteDTOInstance.setDataRegistrazione(new Date());
		
		// se la validazione fallisce
		new AdminValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
//			model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza());
			model.addAttribute("listRuoli", ruoloService.listAllRuoli().stream().map(r -> RuoloDTO.buildRuoloDTOInstance(r)).collect(Collectors.toList()));
//			model.addAttribute("listRuoli", ruoloService.listAllRuoli());
			return "admin/create";
		}

		
		Utente nuovoUtente = UtenteDTO.buildUtenteInstance(utenteDTOInstance);
//		nuovoUtente.setEsperienzaAccumulata(0);
//		nuovoUtente.setCreditoAccumulato(0d);
		nuovoUtente.setInGioco(false);
		utenteService.inserisciNuovo(nuovoUtente);
		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "admin/list";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("idUtente") Long idUtente, Model model) {
		model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
		model.addAttribute("listRuoli", ruoloService.listAllRuoli());
		model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingoloConStatoERuoli(idUtente)));
		return "admin/edit";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute("utenteCommand") UtenteDTO utenteDTOInstance, BindingResult result,
			Model model, HttpServletRequest request) {

		String[] ruoliString = request.getParameterValues("ruoliInput");
		utenteDTOInstance.setRuoli(RuoloDTO.buildSetFromStringArray(ruoliString,ruoloService.listAllRuoli().stream().map(r -> RuoloDTO.buildRuoloDTOInstance(r)).collect(Collectors.toList())));

		new AdminValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
			model.addAttribute("listRuoli", ruoloService.listAllRuoli());
			return "admin/edit";
		}

		Utente utenteAggiornato = UtenteDTO.buildUtenteInstance(utenteDTOInstance);
		utenteService.aggiorna(utenteAggiornato);

		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "admin/list";
	}
	
	@RequestMapping(value ="prepareDelete", method = RequestMethod.GET)
    public String prepareDelete(@RequestParam("idUtente") Long idUtente, Model model){
		model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingoloCompleto(idUtente)));
        return "admin/delete";
    }
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("idUtente") Long idUtente, Model model, HttpSession session) {

		Utente utenteDaEliminare = utenteService.caricaSingoloCompleto(idUtente);
		if(!utenteDaEliminare.getTavoliCreati().isEmpty()) {
			model.addAttribute("erroreTavoliCreati","Questo utente non può essere eliminato perchè possiede dei tavoli");
			model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingoloCompleto(idUtente)));

			return "admin/delete";
		}
		utenteService.rimuovi(utenteDaEliminare);

		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "admin/list";
	}
	
}
