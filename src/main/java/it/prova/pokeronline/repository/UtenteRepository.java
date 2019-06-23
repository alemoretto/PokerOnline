package it.prova.pokeronline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, QueryByExampleExecutor<Utente> {

	Utente findByUsernameAndPassword(String username, String password);

	@Query("SELECT u FROM Utente u JOIN FETCH u.statoUtenza JOIN FETCH u.ruoli WHERE u.id = ?1")
	public Utente caricaSingoloConStatoERuoli(Long id);
}
