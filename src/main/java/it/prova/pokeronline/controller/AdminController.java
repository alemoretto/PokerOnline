package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

import it.prova.pokeronline.dto.StatoUtenzaDTO;
import it.prova.pokeronline.dto.StatoUtenzaDTOEditor;
import it.prova.pokeronline.dto.UtenteDTO;
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
		model.addAttribute("utenteCommand", UtenteDTO.buildUtenteDTOInstance(utenteService.caricaSingoloConStatoERuoli(idUtente)));
        return "admin/show";
    }
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
//		model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza());
		model.addAttribute("listRuoli", ruoloService.listAllRuoli());
		model.addAttribute("utenteCommand", new UtenteDTO());
		return "admin/create";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("utenteCommand") UtenteDTO utenteDTOInstance, BindingResult result, Model model,
			HttpSession session
	/* ,HttpServletRequest req */) {

		utenteDTOInstance.setDataRegistrazione(new Date());
		// se la validazione fallisce
		new AdminValidator().validate(utenteDTOInstance, result);
		if (result.hasErrors()) {
			model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza().stream().map(s -> StatoUtenzaDTO.buildStatoUtenzaDTOInstance(s)).collect(Collectors.toList()));
//			model.addAttribute("listStatiUtenza", statoUtenzaService.listAllStatiUtenza());
			model.addAttribute("listRuoli", ruoloService.listAllRuoli());
			return "admin/create";
		}

		Utente nuovoUtente = UtenteDTO.buildUtenteInstanceForFindByExample(utenteDTOInstance);
//		nuovoUtente.setStatoUtenza(statoUtenzaService.caricaSingolo(1L));;
		nuovoUtente.getRuoli().add(ruoloService.caricaSingolo(3L));;
		nuovoUtente.setEsperienzaAccumulata(0);
		nuovoUtente.setCreditoAccumulato(0d);
		nuovoUtente.setInGioco(false);
		utenteService.inserisciNuovo(nuovoUtente);
		model.addAttribute("listUtenti", utenteService.listAllUtenti());
		return "admin/list";
	}
}
