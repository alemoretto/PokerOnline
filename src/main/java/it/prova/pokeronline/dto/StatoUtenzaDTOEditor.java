package it.prova.pokeronline.dto;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pokeronline.service.StatoUtenzaService;

public class StatoUtenzaDTOEditor extends PropertyEditorSupport{

	@Autowired
	StatoUtenzaService statoUtenzaService;
	
	    //This will be called when user HTTP Post to server a field bound to DepartmentVO
	    @Override
	    public void setAsText(String id)
	    {
	    	Long idStatoUtenza = Long.parseLong(id);
	    	if (idStatoUtenza == -1L) {
	    		this.setValue(null);
				return;
			}
	        this.setValue(statoUtenzaService.caricaSingolo(idStatoUtenza));
	    }
	}
	
