
package com.aegis.common.validators;

import java.util.regex.Matcher;
import javax.faces.context.FacesContext;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("numericSpecialCharValidator")
public class NumericSpecialCharValidator implements Validator{
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String AlphaSpace_PATTERN =  "^([0-9][0-9\\s\\.\\,\\-\\(\\)\\:]+)$";

	public NumericSpecialCharValidator(){
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
				String msg = "Please Enter Numeric or Special Characters";
				throw new ValidatorException(new FacesMessage(msg));
			}
	  }
	}
}
