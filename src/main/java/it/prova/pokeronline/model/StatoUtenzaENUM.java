//package it.prova.pokeronline.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public enum StatoUtenza {
//
//	CREATO("Creato"),
//	ATTIVO("Attivo"),
//	INATTIVO("Inattivo");
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String descrizione;
//	private String codice;
//	
//	private StatoUtenza(String descrizione) {
//		this.descrizione = descrizione;
//		this.codice = this.name();
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDescrizione() {
//		return descrizione;
//	}
//
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//
//	public String getCodice() {
//		return codice;
//	}
//
//	public void setCodice(String codice) {
//		this.codice = codice;
//	}
//	
//}
