package it.prova.pokeronline.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public class TavoloDTO {

	private Long id;
	private String denominazione;
	private Utente creatore;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCreazione;
	private Set<Utente> giocatori = new HashSet<>(0);
	private Integer esperienzaMin;
	private Double cifraMin;
	private String players;

	public TavoloDTO(Long id, String denominazione, Date dataCreazione, Integer esperienzaMin, Double cifraMin) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.dataCreazione = dataCreazione;
		this.esperienzaMin = esperienzaMin;
		this.cifraMin = cifraMin;
	}

	public TavoloDTO() {
	}

	public static TavoloDTO buildTavoloDTOInstance(Tavolo tavolo) {
		TavoloDTO tavoloDTO = new TavoloDTO(tavolo.getId(),tavolo.getDenominazione(),tavolo.getDataCreazione(),
				tavolo.getEsperienzaMin(), tavolo.getCifraMin());
		tavoloDTO.setCreatore(tavolo.getCreatore());
		tavoloDTO.setGiocatori(tavolo.getGiocatori());
		
		return tavoloDTO;
		
	}
	
	public static Tavolo buildTavoloInstance(TavoloDTO tavoloDTO) {
		Tavolo tavolo = new Tavolo(tavoloDTO.getId(),tavoloDTO.getDenominazione(), tavoloDTO.getCreatore(), tavoloDTO.getDataCreazione(),
				tavoloDTO.getEsperienzaMin(), tavoloDTO.getCifraMin());
		
		tavolo.setGiocatori(tavolo.getGiocatori());
		
		return tavolo;
		
	}
	
	public static Tavolo buildTavoloInstanceForFindByExample(TavoloDTO input) {
		Tavolo example = new Tavolo();
		example.setDenominazione(StringUtils.isNotBlank(input.getDenominazione()) ? input.getDenominazione() : null);
		example.setDataCreazione(input.getDataCreazione() != null ? input.getDataCreazione() : null);
		example.setEsperienzaMin(input.getEsperienzaMin() != null ? input.getEsperienzaMin() : null);
		example.setCifraMin(input.getCifraMin() != null ? input.getCifraMin() : null);
		return example;
	}
	
	public static Tavolo buildTavoloInstanceForFindPartita(TavoloDTO input) {
		Tavolo example = new Tavolo();
		example.setDenominazione(StringUtils.isNotBlank(input.getDenominazione()) ? input.getDenominazione() : null);
		example.setDataCreazione(input.getDataCreazione() != null ? input.getDataCreazione() : null);
		example.setCifraMin(input.getCifraMin() != null ? input.getCifraMin() : null);
		example.setCreatore(input.getCreatore() != null ? input.getCreatore() : null);
		List<String> uu = null;
		Set<Utente> users = null;
		try {
			if (input.getPlayers() != null) {
				
			String[] arr = input.getPlayers().split("\\s+");
			for (String string : arr) {
				example.getGiocatori().add(new Utente(string));
			}
			}
		} catch (PatternSyntaxException ex) {
		}
		
		return example;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Integer getEsperienzaMin() {
		return esperienzaMin;
	}

	public void setEsperienzaMin(Integer esperienzaMin) {
		this.esperienzaMin = esperienzaMin;
	}

	public Double getCifraMin() {
		return cifraMin;
	}

	public void setCifraMin(Double cifraMin) {
		this.cifraMin = cifraMin;
	}

	public Utente getCreatore() {
		return creatore;
	}

	public void setCreatore(Utente creatore) {
		this.creatore = creatore;
	}

	public Set<Utente> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Utente> giocatori) {
		this.giocatori = giocatori;
	}

	
	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String toString() {
		return denominazione;
	}
	
}
