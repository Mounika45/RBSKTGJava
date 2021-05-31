/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.common;

/**
 *
 * @author pavani
 */
import com.aegis.mobile.beans.ErrorDetail;
import com.google.gson.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class ExceptionControllerAdvice {

	
       /* @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> exceptionHandler(Exception ex) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorDetail>(error, HttpStatus.OK);
	}
        
        
        
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleGeneralException(Exception ex) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorDetail>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
        
        @ResponseStatus(HttpStatus.FORBIDDEN)
        @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleForbiddenException(Exception ex) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.FORBIDDEN.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorDetail>(error, HttpStatus.FORBIDDEN);
	}*/
        
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetail> handleBadRequestException(NullPointerException ex) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<ErrorDetail>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
