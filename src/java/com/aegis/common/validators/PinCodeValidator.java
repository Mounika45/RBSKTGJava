package com.aegis.common.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pinCodeValidator")

public class PinCodeValidator  implements Validator{

	private Pattern pattern;
	private Matcher matcher;

	public void validate(FacesContext context, UIComponent component, Object value)throws ValidatorException {
		String pinNumber ="";
		if(value!=null){
			pinNumber = String.valueOf(value);	
			}
			if(! pinNumber.equalsIgnoreCase("")){
				
			String expression = "\\d+?";// one or more times
			 pattern = Pattern.compile(expression);
			 matcher = pattern.matcher(pinNumber);
			
			if (!matcher.matches()) {
				String msg = "Invalid entry, only numeric values are accepted.";
				throw new ValidatorException(new FacesMessage(msg));
			}
			if (pinNumber.length()!=5){
				String msg = "Pin code should be of 5 digits.";
				throw new ValidatorException(new FacesMessage(msg));
			}
				
		}
		
	}
	

}
