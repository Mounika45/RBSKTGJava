package com.aegis.common.validators;


	
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	import javax.faces.application.FacesMessage;
	import javax.faces.component.UIComponent;
	import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
	import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("mobileNumberValidator")
	public class MobileNumberValidator implements Validator {
		
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			String phNumber = (String) value;
			if(!phNumber.equalsIgnoreCase("")){
				
			String expression = "\\d+?";// one or more times
			Pattern pattern = Pattern.compile(expression);
			Matcher matcher = pattern.matcher(phNumber);
			
			if (! matcher.matches()) {
				String msg = "Invalid entry, only numeric values are accepted.";
				throw new ValidatorException(new FacesMessage(msg));
			}
			if (phNumber.length() != 10){
				String msg = "Mobile no. should be of 10 digits.";
				throw new ValidatorException(new FacesMessage(msg));
			}
				
		}
	}

}