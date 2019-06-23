package it.prova.pokeronline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ruolo {
	
	public static final String ADMIN_ROLE = "ADMIN_ROLE"; 
	public static final String CLASSIC_PLAYER_ROLE = "Giocatore";
	public static final String SPECIAL_PLAYER_ROLE = "Giocatore Speciale";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	
	public Ruolo() {
		
	}
	public Ruolo(Long id) {
		this.id = id;
	}
	public Ruolo(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	@Override
    public int hashCode() {
        return new Long(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Ruolo)) {
            return false;
        }
        return this.id == ((Ruolo)obj).getId();
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
