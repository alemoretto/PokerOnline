package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.Utente;

public interface UtenteService {

	public List<Utente> listAllUtenti();
	
	public Utente caricaSingolo(Long id);
	
	public void aggiorna(Utente utenteInstance);
	
	public void inserisciNuovo(Utente utenteInstance);
	
	public void rimuovi(Utente utenteInstance);
	
	public List<Utente> findByExample(Utente example);

	public Utente eseguiAccesso(String username, String password);

	public Utente caricaSingoloConStatoERuoli(Long id);
	
	public Utente caricaSingoloCompleto(Long id);
	
	public Utente findByUsername(String username);

}
