//package it.prova.pokeronline.validator;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import it.prova.pokeronline.dto.UtenteDTO;
//
//public class TavoloValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return TavoloDTO.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object arg0, Errors errors) {
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "denominazione", "required", "Campo obbligatorio.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataCreazione", "required", "Campo obbligatorio.");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cifraMin", "required", "Campo obbligatorio.");
//
//	}
//}
