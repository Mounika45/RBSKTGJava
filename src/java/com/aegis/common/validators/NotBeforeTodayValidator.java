package com.aegis.common.validators;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("notBeforeToday")

public class NotBeforeTodayValidator implements Validator
{
  
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{
		Date date = (Date) value;
		Date today = new Date();
		if(date != null){
		String message ="";
		if (date.before(today)) {
			message = "Date may not be before than today.";
			throw new ValidatorException(new FacesMessage(message));
		}
		  
	  }
	}
  
}
