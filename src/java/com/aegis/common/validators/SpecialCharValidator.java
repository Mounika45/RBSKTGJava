
package com.aegis.common.validators;

import java.util.regex.Matcher;
import javax.faces.context.FacesContext;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("specialCharValidator")
public class SpecialCharValidator implements Validator{
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String AlphaSpace_PATTERN =  "^([a-zA-Z][a-zA-Z\\s\\.\\,\\-\\(\\)\\:]+)$";

	public SpecialCharValidator(){
		  pattern = Pattern.compile(AlphaSpace_PATTERN);
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
				String msg = "Please Enter Aphabets or Special Characters";
				throw new ValidatorException(new FacesMessage(msg));
			}
	  }
	}
}
