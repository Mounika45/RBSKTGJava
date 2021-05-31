package com.aegis.common.validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;


@FacesValidator("notbeforefromdate")
public class NotBeforeFromDateValidator implements Validator {

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Date date = (Date) value;
		UIInput fromDateComponent = (UIInput) component.getAttributes().get("periodofServiceFromFather");
		if(date !=null){
			String dateString = (String) fromDateComponent.getSubmittedValue();
			String pattern = "yyyy/MM/dd hh:mm";
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date today=null;
			try {
	    	   today = dateFormat.parse(dateString);      
	          } catch (java.text.ParseException e) {
				e.printStackTrace();
			}
		     
	       if (date == null || today == null) {
	            return;
	       }
	       if (date.after(today)) {
			String message = "Date may not be later than today.";
			throw new ValidatorException(new FacesMessage(message));
	       }
	}
   }
}
