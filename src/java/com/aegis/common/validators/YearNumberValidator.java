package com.aegis.common.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("yearNumberValidator")
	public class YearNumberValidator implements Validator {
		
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			String phNumber = "";
			if(value!=null){
				 phNumber = value.toString();
			}
			if(!phNumber.equalsIgnoreCase("")){
			if (phNumber.length() != 4){
				String msg = "Year can not be less than 4 digits.";
				throw new ValidatorException(new FacesMessage(msg));
				
			}
				
		}
	}

}