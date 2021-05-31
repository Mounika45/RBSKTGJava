package com.aegis.common.validators;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pinNumberValidator")
	public class PinNumberValidator implements Validator {
		
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			if(value!=null)
			{
				String phNumber = value.toString();
				if(!phNumber.equalsIgnoreCase(""))
				{
					if (phNumber.length() != 6)
					{
						String msg="Pin code of 6 digits";
						throw new ValidatorException(new FacesMessage(msg));
					}
				}
			}
	}

}