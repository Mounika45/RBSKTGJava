package com.aegis.common.validators;



import java.util.regex.Matcher;
import javax.faces.context.FacesContext;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator{
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" +
        "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator(){
		  pattern = Pattern.compile(EMAIL_PATTERN);
	  }

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String data = String.valueOf(value);
		if(!data.equalsIgnoreCase(""))
		{
			boolean flag = false;
			boolean flagspecial = false;
			//FacesMessage message = new FacesMessage();
			matcher = pattern.matcher(data);
			if(!matcher.matches()){ 
			flag = true;
			} 
		String delimPlus = "0123456789";
		if (!flag) {
			for (int i = 0; i < delimPlus.length(); i++) {
				if (data.charAt(0) == delimPlus.charAt(i)) {
					flagspecial = true;
					break;
				}
			}
		}
		if(flagspecial) {
			String msg = "Email can't start with a numeric value.";
			throw new ValidatorException(new FacesMessage(msg));
			/*message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Email can't start with a numeric value");
			message.setDetail("Email can't start with a numeric value");
			context.addMessage("signUpForm", message);
			throw new ValidatorException(message);*/
		}
		if (flag) { 
			String msg = "Please enter valid Email ID.";
			throw new ValidatorException(new FacesMessage(msg));
			/*message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Please enter valid Email ID."); 
			context.addMessage("signUpForm", message);
			throw new ValidatorException(message);*/
		}
	  }
	}
}
