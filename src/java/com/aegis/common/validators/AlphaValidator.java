package com.aegis.common.validators;

import java.util.regex.Matcher;
import javax.faces.context.FacesContext;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("alphaValidator")
public class AlphaValidator implements Validator{
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String Alpha_PATTERN = 
        "([A-Za-z ]+)";

	public AlphaValidator(){
		  pattern = Pattern.compile(Alpha_PATTERN);
	  }

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String data = String.valueOf(value);
		if(! data.equalsIgnoreCase(""))
		{
			boolean flag = false;
			matcher = pattern.matcher(data);
			if(!matcher.matches()){ 
				flag = true;
			} 
			if (flag) { 
				String msg = "Please enter alphabets only";
				throw new ValidatorException(new FacesMessage(msg));
			}
	  }
	}
}
