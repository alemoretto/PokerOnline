package it.prova.pokeronline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public interface TavoloRepository extends CrudRepository<Tavolo, Long>, QueryByExampleExecutor<Tavolo> {

	public List<Tavolo> findByCreatore(Utente creatore);

	@Query("SELECT t FROM Tavolo t JOIN FETCH t.giocatori where t.id = ?1")
	public Tavolo caricaConGiocatori(Long id);

//	@EntityGraph(attributePaths = { "giocatori" })
//	Tavolo findOneConGiocatori(Long id);

}
