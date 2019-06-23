package it.prova.pokeronline.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.pokeronline.model.Ruolo;

public class RuoloDTO {

	public static final String ADMIN_ROLE = "ADMIN_ROLE";
	public static final String CLASSIC_PLAYER_ROLE = "Giocatore";
	public static final String SPECIAL_PLAYER_ROLE = "Giocatore Speciale";

	private Long id;
	private String descrizione;
	private String codice;

	public RuoloDTO() {

	}

	public RuoloDTO(Long id) {
		this.id = id;
	}

	public RuoloDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public static RuoloDTO buildRuoloDTOInstance(Ruolo ruolo) {
		return new RuoloDTO(ruolo.getId(), ruolo.getDescrizione(), ruolo.getCodice());
	}

	public static Ruolo buildRuoloInstance(RuoloDTO ruolo) {
		return new Ruolo(ruolo.getId(), ruolo.getDescrizione(), ruolo.getCodice());
	}

	public static Set<RuoloDTO> buildSetFromStringArray(String[] ruoliString, List<RuoloDTO> tuttiIRUoli) {
		Set<RuoloDTO> ruoli = new HashSet<>(0);
		if (ruoliString != null && ruoliString.length > 0) {
			for (RuoloDTO ruolo : tuttiIRUoli) {
				for (String str : ruoliString) {
					if (str.equals(Long.toString(ruolo.getId()))) {
						ruoli.add(ruolo);
					}
				}
			}
		}
		return ruoli;
	}

//
//	@Override
//	public int hashCode() {
//		return new Long(id).hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null) {
//			return false;
//		}
//		if (!(obj instanceof RuoloDTO)) {
//			return false;
//		}
//		return this.id == ((RuoloDTO) obj).getId();
//	}

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
