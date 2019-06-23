package it.prova.pokeronline.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.TavoloRepository;
import it.prova.pokeronline.repository.UtenteRepository;

@Service
public class TavoloServiceImpl implements TavoloService {

	@Autowired
	private TavoloRepository tavoloRepository;

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> listAllTavoli() {
		return (List<Tavolo>) tavoloRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tavolo caricaSingolo(Long id) {
		return tavoloRepository.findOne(id);
	}

	@Override
	public void aggiorna(Tavolo tavoloInstance) {
		tavoloRepository.save(tavoloInstance);
	}

	@Override
	public void inserisciNuovo(Tavolo tavoloInstance) {
		tavoloRepository.save(tavoloInstance);
	}

	@Override
	public void rimuovi(Tavolo tavoloInstance) {
		tavoloRepository.delete(tavoloInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> findByExample(Tavolo exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		// Match string
		// containing
		// pattern
		// .withIgnoreCase();
		
		return (List<Tavolo>) tavoloRepository.findAll(Example.of(exampleInput, matcher));
	}

	public List<Tavolo> findByGiocatori(Set<Utente> giocatori){
		return tavoloRepository.findByGiocatori(giocatori);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> findByExamplePartita(Tavolo exampleInput) {
		Double cifraMin = exampleInput.getCifraMin() != null ? exampleInput.getCifraMin() : 0d ;
		exampleInput.setCifraMin(null);
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		return ((List<Tavolo>) tavoloRepository.findAll(Example.of(exampleInput, matcher))).stream().filter(t -> t.getCifraMin() >= cifraMin).collect(Collectors.toList());

	}
	
	
//	@Override
//	@Transactional(readOnly = true)
//	public List<Tavolo> findByExamplePartita(Tavolo exampleInput) {
//		Double cifraMin = exampleInput.getCifraMin() != null ? exampleInput.getCifraMin() : 0d ;
//		exampleInput.setCifraMin(null);
//		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
//		List<Tavolo> results = ((List<Tavolo>) tavoloRepository.findAll(Example.of(exampleInput, matcher))).stream().filter(t -> t.getCifraMin() >= cifraMin).collect(Collectors.toList());
//
//		Set<Utente> players = new HashSet<>(0);
//		for (Utente utente : exampleInput.getGiocatori()) {
//			Utente u = utenteRepository.findByUsername(utente.getUsername());
////			System.out.println(u);
//
//			players.add(u);
//		}
//		
////		List<Tavolo> results = tavoloRepository.findByGiocatori(players);
//		
//		return tavoloRepository.findByGiocatori(players);
//		
////		Set<Tavolo> res = new HashSet<>(0);
////		List<Tavolo> res = new ArrayList<>(0);
//		
//		
////		if(exampleInput.getGiocatori().size() > 0) {
////			results.stream().filter(t -> t.getGiocatori().size() > 0).collect(Collectors.toList());
////			System.out.println(results.size());
////			for (Tavolo tavolo : results) {
////				for (Utente g : tavolo.getGiocatori()) {
////					if (exampleInput.getGiocatori().contains(g)) {
////						res.add(tavolo);
////					}
////				}
////			}
//////			stream().filter(t -> {t.getGiocatori().stream().filter(g -> g.getUsername().contains("a2"))}).collect(Collectors.toList());
////			return res.stream().collect(Collectors.toList());
////			return res;
//
////		}
//		
////		return results;
//
//	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> listMieiTavoli(Utente creatore) {
		return tavoloRepository.findByCreatore(creatore);
	}

	@Override
	@Transactional(readOnly = true)
	public Tavolo caricaConGiocatori(Long id) {
		return tavoloRepository.caricaConGiocatori(id);
	}
	
}
