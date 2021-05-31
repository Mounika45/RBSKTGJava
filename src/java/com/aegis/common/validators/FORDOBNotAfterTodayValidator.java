package com.aegis.common.validators;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.*;

@FacesValidator("fordobnotAfterToday")
public class FORDOBNotAfterTodayValidator implements Validator {

	public void validate(FacesContext context, UIComponent component,
		Object value) throws ValidatorException {
		Date date = (Date) value;
		Date today = new Date();
		if(date != null){
			SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
			String year1=simpleDateformat.format(date);
			Integer year=null;
			year=Integer.parseInt(year1);
			String message ="";
			if (date.after(today)) {
				message = "Date may not be later than today.";
				throw new ValidatorException(new FacesMessage(message));
			}else{
			if(year<1899){
				message = "Year may not be less than 1900.";
				throw new ValidatorException(new FacesMessage(message));
			}
		}
	}
	}
}
