package it.prova.pokeronline.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Tavolo;

public class TavoloDTO {

	private Long id;
	private String denominazione;
//	private Utente creatore;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCreazione;
//	private Set<Utente> giocatori = new HashSet<>(0);
	private Integer esperienzaMin;
	private Double cifraMin;

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

	public static Tavolo buildTavoloInstanceForFindByExample(TavoloDTO input) {
		Tavolo example = new Tavolo();
		example.setDenominazione(StringUtils.isNotBlank(input.getDenominazione()) ? input.getDenominazione() : null);
		example.setDataCreazione(input.getDataCreazione() != null ? input.getDataCreazione() : null);
		example.setEsperienzaMin(input.getEsperienzaMin() != null ? input.getEsperienzaMin() : null);
		example.setCifraMin(input.getCifraMin() != null ? input.getCifraMin() : null);
		return example;
	}

}
