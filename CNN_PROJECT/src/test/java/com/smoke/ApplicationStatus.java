package com.smoke;

import org.testng.annotations.Test;

import com.generic.DriverScripts;

public class ApplicationStatus {
	
	@Test
	public void setup() {
	
		DriverScripts obj =new DriverScripts();
		obj.getdriver("https://www.cnn.com/business");
		
		
		
	}

}
