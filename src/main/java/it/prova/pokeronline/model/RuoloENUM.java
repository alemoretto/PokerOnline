package it.prova.pokeronline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum Ruolo {
	
	ADMIN_ROLE("Amministratore"), 
	CLASSIC_PLAYER_ROLE("Giocatore"),
	SPECIAL_PLAYER_ROLE("Giocatore Speciale");
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
		
	private Ruolo(String descrizione) {
		this.descrizione = descrizione;
		this.codice = this.name();
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
