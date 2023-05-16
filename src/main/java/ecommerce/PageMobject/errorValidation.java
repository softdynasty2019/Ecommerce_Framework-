package ecommerce.PageMobject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ecommerce.testComponent.copy.BeseTest;

public class errorValidation extends BeseTest {
	
	@Test
	
	public void errorMessgaes () throws IOException {
		
		launchApplication();
		//Assert.assertEquals
		Assert.assertEquals("Incorrect email or password.",lanpage.getErrorMeg());
		
		
		
		
		
		
		
		
		
	}

}
