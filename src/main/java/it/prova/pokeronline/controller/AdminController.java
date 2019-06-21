package it.prova.pokeronline.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
//	@RequestMapping(value = "list", method = { RequestMethod.POST, RequestMethod.GET })
//	public String list(@ModelAttribute("autoreCommand") UtenteDTO autoreDTOInstance, Model model) {
//		Autore example = AutoreDTO.buildAutoreInstanceForFindByExample(autoreDTOInstance);
//		model.addAttribute("listAutori", autoreService.findByExample(example));
//		return "autore/list";
//	}
}
