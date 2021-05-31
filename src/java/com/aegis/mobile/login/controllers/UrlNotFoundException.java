/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.login.controllers;

import com.aegis.mobile.beans.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Baby
 */
public class UrlNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UrlNotFoundException(String key) {
        super(key + " not available");
    }

   

}
