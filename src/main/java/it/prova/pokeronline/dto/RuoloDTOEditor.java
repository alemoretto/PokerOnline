package it.prova.pokeronline.dto;

import java.beans.PropertyEditorSupport;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pokeronline.service.RuoloService;

public class RuoloDTOEditor extends PropertyEditorSupport {

	@Autowired
	RuoloService ruoloService;

	@Override
	public void setAsText(String id) {
//		Set<RuoloDTO> ruoli = new HashSet()<>(0);
//		for (String id : ids) {
			
//		}

		Long idRuolo = Long.parseLong(id);
		this.setValue(ruoloService.caricaSingolo(idRuolo));
	}
}
