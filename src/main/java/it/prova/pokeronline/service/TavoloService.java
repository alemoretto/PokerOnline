package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.Tavolo;

public interface TavoloService {

	public List<Tavolo> listAllTavoli();
	
	public Tavolo caricaSingolo(Long id);
	
	public void aggiorna(Tavolo tavoloInstance);
	
	public void inserisciNuovo(Tavolo tavoloInstance);
	
	public void rimuovi(Tavolo tavoloInstance);
	
	public List<Tavolo> findByExample(Tavolo example);

}
