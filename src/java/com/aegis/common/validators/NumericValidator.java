package com.aegis.common.validators;

import java.util.regex.Matcher;
import javax.faces.context.FacesContext;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("numericValidator")
public class NumericValidator implements Validator{
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String Numeric_PATTERN = 
        "([0-9 ]+)";

	public NumericValidator(){
		  pattern = Pattern.compile(Numeric_PATTERN);
	  }

//	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
//		String data = String.valueOf(value);
//		if(!(data.equalsIgnoreCase("")) && data.equalsIgnoreCase(null))
//		{
//			boolean flag = false;
//			//boolean flagspecial = false;
//			//FacesMessage message = new FacesMessage();
//			matcher = pattern.matcher(data);
//			if(!matcher.matches()){ 
//			flag = true;
//			} 
//		
//			if (flag) { 
//			String msg = "Please enter numeric values only.";
//			throw new ValidatorException(new FacesMessage(msg));
//			/*message.setSeverity(FacesMessage.SEVERITY_ERROR);
//			message.setSummary("Please enter valid Email ID."); 
//			context.addMessage("signUpForm", message);
//			throw new ValidatorException(message);*/
//		}
//	  }
//	}
         public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException{
        String number = (String) o;
         
        Boolean flag = number.contains(" ");
        if (flag == false) {
            throw new ValidatorException(new FacesMessage("Enter Valid Number(Ex: 000000 )"));
        } else {
            String ar[] = number.split("[ ]");
//            System.out.println("ar[0] size:: "+ar[0].length()+" No:: "+number);
            if (ar[0].length() > 2 || ar[0].length() < 2) {
                throw new ValidatorException(new FacesMessage("Enter Valid Number(Ex: 0000000 )"));
            }
        } 
    }
}
