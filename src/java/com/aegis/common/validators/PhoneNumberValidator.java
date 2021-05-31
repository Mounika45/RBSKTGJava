package com.aegis.common.validators;


	
	import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneNumberValidator")
	public class PhoneNumberValidator implements Validator {
		
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
					if (phNumber.length() != 11){
						String msg = "Phone no. must be of 11 digits.";
						throw new ValidatorException(new FacesMessage(msg));
					}
				}
		}

}