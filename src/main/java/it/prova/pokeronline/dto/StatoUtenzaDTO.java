package it.prova.pokeronline.dto;

import it.prova.pokeronline.model.StatoUtenza;

public class StatoUtenzaDTO {

	public final static String CREATO = "Creato";
	public final static String ATTIVO = "Attivo";
	public final static String INATTIVO = "Inattivo";
	
	private Long id;
	private String descrizione;
	private String codice;
	
	public StatoUtenzaDTO() {
		
	}

	public StatoUtenzaDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public static StatoUtenzaDTO buildStatoUtenzaDTOInstance(StatoUtenza stato) {
		return new StatoUtenzaDTO(stato.getId(), stato.getDescrizione(), stato.getCodice());
	}
	
	public static StatoUtenza buildStatoUtenzaInstance(StatoUtenzaDTO stato) {
		return new StatoUtenza(stato.getId(), stato.getDescrizione(), stato.getCodice());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	public String toString() {
		return descrizione;
	}
}
