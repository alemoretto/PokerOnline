package it.prova.pokeronline.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataRegistrazione;
	private Integer esperienzaAccumulata;
	private Double creditoAccumulato;

	public UtenteDTO() {

	}

	public UtenteDTO(Long id, String nome, String cognome, String username, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public UtenteDTO(Long id, String nome, String cognome, String username, String password, Date dataRegistrazione, Integer esperienzaAccumulata, Double creditoAccumulato) {
		this(id, nome, cognome, username, password);
		this.dataRegistrazione = dataRegistrazione;
		this.esperienzaAccumulata = esperienzaAccumulata;
		this.creditoAccumulato = creditoAccumulato;
	}
	
	public static UtenteDTO buildUtenteDTOInstance(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO(utente.getId(), utente.getNome(), utente.getCognome(), utente.getUsername(),
				utente.getPassword(), utente.getDataRegistrazione(), utente.getEsperienzaAccumulata(), utente.getCreditoAccumulato());

		return utenteDTO;

	}

	public static Utente buildUtenteInstanceForFindByExample(UtenteDTO input) {
		Utente example = new Utente();
		example.setNome(StringUtils.isNotBlank(input.getNome()) ? input.getNome() : null);
		example.setCognome(StringUtils.isNotBlank(input.getCognome()) ? input.getCognome() : null);
		example.setUsername(StringUtils.isNotBlank(input.getUsername()) ? input.getUsername() : null);
		example.setPassword(StringUtils.isNotBlank(input.getPassword()) ? input.getPassword() : null);
		example.setDataRegistrazione(input.getDataRegistrazione() != null ? input.getDataRegistrazione(): null);
		example.setEsperienzaAccumulata(input.getEsperienzaAccumulata()!= null ? input.getEsperienzaAccumulata() : null);
		example.setCreditoAccumulato(input.getCreditoAccumulato()!= null ? input.getCreditoAccumulato() : null);
		return example;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public Integer getEsperienzaAccumulata() {
		return esperienzaAccumulata;
	}

	public void setEsperienzaAccumulata(Integer esperienzaAccumulata) {
		this.esperienzaAccumulata = esperienzaAccumulata;
	}

	public Double getCreditoAccumulato() {
		return creditoAccumulato;
	}

	public void setCreditoAccumulato(Double creditoAccumulato) {
		this.creditoAccumulato = creditoAccumulato;
	}


}
