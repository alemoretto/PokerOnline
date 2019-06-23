package it.prova.pokeronline.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.prova.pokeronline.dto.StatoUtenzaDTO;
import it.prova.pokeronline.dto.UtenteDTO;

public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UtenteDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required", "Campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required", "Campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required", "Campo obbligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace  (errors, "password", "required", "Campo obbligatorio");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ruoli", "required", "Campo obbligatorio.");
//		ValidationUtils.rejectIfEmpty(errors, "statoUtenza", "required", "Seleziona uno stato");
		
		UtenteDTO utenteDTO = (UtenteDTO) arg0;
		if (utenteDTO.getStatoUtenza().getId() == -1L) {
			errors.rejectValue("statoUtenza", "required", "Seleziona uno stato");
		}
		
	}
}
