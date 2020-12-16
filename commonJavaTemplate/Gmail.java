package com.javachip.carrotcountry.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator {
		
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {

		return new PasswordAuthentication("dkajffkem@gmail.com", "ghduswkd11");
		
	}

}
