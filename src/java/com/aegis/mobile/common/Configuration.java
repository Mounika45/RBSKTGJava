/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.common;

/**
 *
 * @author Baby
 */
public class Configuration {
    	private static final String EXTERNAL_PROVIDERS_FILE = "otp.providers";

	public static String getExternalOTPProviders() {
		return System.getProperty(EXTERNAL_PROVIDERS_FILE);
	}
}
