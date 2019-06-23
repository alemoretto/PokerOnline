package it.prova.pokeronline.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataRegistrazione;
	private StatoUtenzaDTO statoUtenza;
	private Set<RuoloDTO> ruoli = new HashSet<>(0);
	private Integer esperienzaAccumulata;
	private Double creditoAccumulato;
	private Set<TavoloDTO> tavoliCreati = new HashSet<>(0);

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

	public UtenteDTO(Long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
			StatoUtenzaDTO statoUtenza, Integer esperienzaAccumulata, Double creditoAccumulato, Set<RuoloDTO> ruoli) {
		this(id, nome, cognome, username, password);
		this.dataRegistrazione = dataRegistrazione;
		this.statoUtenza = statoUtenza;
		this.esperienzaAccumulata = esperienzaAccumulata;
		this.creditoAccumulato = creditoAccumulato;
		this.ruoli = ruoli;

	}

	public static UtenteDTO buildUtenteDTOInstance(Utente utente) {
		UtenteDTO utenteDTO = new UtenteDTO(utente.getId(), utente.getNome(), utente.getCognome(), utente.getUsername(),
				utente.getPassword(), utente.getDataRegistrazione(),
				StatoUtenzaDTO.buildStatoUtenzaDTOInstance(utente.getStatoUtenza()), utente.getEsperienzaAccumulata(),
				utente.getCreditoAccumulato(),utente.getRuoli().stream().map(r -> RuoloDTO.buildRuoloDTOInstance(r)).collect(Collectors.toSet()));
		utente.getTavoliCreati().stream().map(t -> TavoloDTO.buildTavoloDTOInstance(t)).collect(Collectors.toSet());

		return utenteDTO;

	}

	public static Utente buildUtenteInstance(UtenteDTO input) {
		Utente utente = new Utente(input.getId(), input.getNome(), input.getCognome(), input.getUsername(),
				input.getPassword());
		utente.setDataRegistrazione(input.getDataRegistrazione());
		utente.setStatoUtenza(StatoUtenzaDTO.buildStatoUtenzaInstance(input.getStatoUtenza()));
		utente.setRuoli(input.getRuoli().stream().map(r -> RuoloDTO.buildRuoloInstance(r)).collect(Collectors.toSet()));
		utente.setEsperienzaAccumulata(input.getEsperienzaAccumulata() != null ? input.getEsperienzaAccumulata() : 0);
		utente.setCreditoAccumulato(input.getCreditoAccumulato() != null ? input.getCreditoAccumulato() : 0d);
//		TavoloDTO.buildTavoloInstance(t)
		utente.setTavoliCreati(input.getTavoliCreati().stream().map(t -> TavoloDTO.buildTavoloInstance(t)).collect(Collectors.toSet()));
		
		return utente;
	}

	public static Utente buildUtenteInstanceForFindByExample(UtenteDTO input) {
		Utente example = new Utente();
		example.setNome(StringUtils.isNotBlank(input.getNome()) ? input.getNome() : null);
		example.setCognome(StringUtils.isNotBlank(input.getCognome()) ? input.getCognome() : null);
		example.setUsername(StringUtils.isNotBlank(input.getUsername()) ? input.getUsername() : null);
		example.setPassword(StringUtils.isNotBlank(input.getPassword()) ? input.getPassword() : null);
		example.setDataRegistrazione(input.getDataRegistrazione() != null ? input.getDataRegistrazione() : null);
		example.setStatoUtenza(
				input.getStatoUtenza() != null ? StatoUtenzaDTO.buildStatoUtenzaInstance(input.getStatoUtenza())
						: null);
		example.setEsperienzaAccumulata(
				input.getEsperienzaAccumulata() != null ? input.getEsperienzaAccumulata() : null);
		example.setCreditoAccumulato(input.getCreditoAccumulato() != null ? input.getCreditoAccumulato() : null);

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

	public StatoUtenzaDTO getStatoUtenza() {
		return statoUtenza;
	}

	public void setStatoUtenza(StatoUtenzaDTO statoUtenza) {
		this.statoUtenza = statoUtenza;
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

	public Set<RuoloDTO> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<RuoloDTO> ruoli) {
		this.ruoli = ruoli;
	}

	public Set<TavoloDTO> getTavoliCreati() {
		return tavoliCreati;
	}

	public void setTavoliCreati(Set<TavoloDTO> tavoliCreati) {
		this.tavoliCreati = tavoliCreati;
	}

}

//package it.prova.pokeronline.dto;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import it.prova.pokeronline.model.Ruolo;
//import it.prova.pokeronline.model.StatoUtenza;
//import it.prova.pokeronline.model.Utente;

//public class UtenteDTO {
//
//	private Long id;
//	private String nome;
//	private String cognome;
//	private String username;
//	private String password;
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	private Date dataRegistrazione;
//	private StatoUtenza statoUtenza;
//	private Set<Ruolo> ruoli = new HashSet<>(0);
////	private List<Ruolo> ruoli = new ArrayList<>(0);
////	private List<String> ruoliS = new ArrayList<>(0);
//	private Integer esperienzaAccumulata;
//	private Double creditoAccumulato;
//
//	public UtenteDTO() {
//
//	}
//
//	public UtenteDTO(Long id, String nome, String cognome, String username, String password) {
//		super();
//		this.id = id;
//		this.nome = nome;
//		this.cognome = cognome;
//		this.username = username;
//		this.password = password;
//	}
//
//	public UtenteDTO(Long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
//			StatoUtenza statoUtenza, Integer esperienzaAccumulata, Double creditoAccumulato) {
//		this(id, nome, cognome, username, password);
//		this.dataRegistrazione = dataRegistrazione;
//		this.statoUtenza = statoUtenza;
//		this.esperienzaAccumulata = esperienzaAccumulata;
//		this.creditoAccumulato = creditoAccumulato;
////		this.ruoliS = ruoliS;
////		for (Ruolo ruolo : ruoli) {
////			this.getRuoli().add(ruolo);
////		}
//	}
//
//	public static UtenteDTO buildUtenteDTOInstance(Utente utente) {
////		List<String> ruoli = new ArrayList<>(0);
////		for (Ruolo ruolo : utente.getRuoli()) {
////			ruoli.add(Long.toString(ruolo.getId()));
////		}
//		UtenteDTO utenteDTO = new UtenteDTO(utente.getId(), utente.getNome(), utente.getCognome(), utente.getUsername(),
//				utente.getPassword(), utente.getDataRegistrazione(), utente.getStatoUtenza(), 
//				utente.getEsperienzaAccumulata(), utente.getCreditoAccumulato());
//
//		utenteDTO.setRuoli(utente.getRuoli());
//		return utenteDTO;
//
//	}
//
//	public static Utente buildUtenteInstanceForFindByExample(UtenteDTO input) {
//		Utente example = new Utente();
//		example.setNome(StringUtils.isNotBlank(input.getNome()) ? input.getNome() : null);
//		example.setCognome(StringUtils.isNotBlank(input.getCognome()) ? input.getCognome() : null);
//		example.setUsername(StringUtils.isNotBlank(input.getUsername()) ? input.getUsername() : null);
//		example.setPassword(StringUtils.isNotBlank(input.getPassword()) ? input.getPassword() : null);
//		example.setDataRegistrazione(input.getDataRegistrazione() != null ? input.getDataRegistrazione() : null);
//		example.setStatoUtenza(input.getStatoUtenza() != null ? input.getStatoUtenza(): null);
//		example.setEsperienzaAccumulata(input.getEsperienzaAccumulata() != null ? input.getEsperienzaAccumulata() : null);
//		example.setCreditoAccumulato(input.getCreditoAccumulato() != null ? input.getCreditoAccumulato() : null);
////		for (String ruolo : input.getRuoliS()) {
////			example.getRuoli().add(new Ruolo(Long.parseLong(ruolo)));
////		}
//		return example;
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
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Date getDataRegistrazione() {
//		return dataRegistrazione;
//	}
//
//	public void setDataRegistrazione(Date dataRegistrazione) {
//		this.dataRegistrazione = dataRegistrazione;
//	}
//
//	public StatoUtenza getStatoUtenza() {
//		return statoUtenza;
//	}
//
//	public void setStatoUtenza(StatoUtenza statoUtenza) {
//		this.statoUtenza = statoUtenza;
//	}
//
//	public Integer getEsperienzaAccumulata() {
//		return esperienzaAccumulata;
//	}
//
//	public void setEsperienzaAccumulata(Integer esperienzaAccumulata) {
//		this.esperienzaAccumulata = esperienzaAccumulata;
//	}
//
//	public Double getCreditoAccumulato() {
//		return creditoAccumulato;
//	}
//
//	public void setCreditoAccumulato(Double creditoAccumulato) {
//		this.creditoAccumulato = creditoAccumulato;
//	}
//
//	public Set<Ruolo> getRuoli() {
//		return ruoli;
//	}
//
//	public void setRuoli(Set<Ruolo> ruoli) {
//		this.ruoli = ruoli;
//	}
//
//}
