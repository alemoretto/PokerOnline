package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public interface TavoloService {

	public List<Tavolo> listAllTavoli();
	
	public Tavolo caricaSingolo(Long id);
	
	public void aggiorna(Tavolo tavoloInstance);
	
	public void inserisciNuovo(Tavolo tavoloInstance);
	
	public void rimuovi(Tavolo tavoloInstance);
	
	public List<Tavolo> findByExample(Tavolo example);
	
	public List<Tavolo> listMieiTavoli(Utente creatore);
	
//	public void rimuoviSePossibile(Long id);
	
	public Tavolo caricaConGiocatori(Long id);
	
	//	public Tavolo findByIdAndGiocatori(Long id);

}
