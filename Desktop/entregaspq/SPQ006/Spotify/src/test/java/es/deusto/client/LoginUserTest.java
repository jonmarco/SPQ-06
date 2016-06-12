package es.deusto.client;


import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.Assert;

//contiperf
//nos permite usar los test Junit como test de rendimiento
//especificamos los datos de ejecucion


@PerfTest(invocations=10)

@Required(max=3000)
public class LoginUserTest {

	
	// activamos contiperfrule
	@Rule
	public ContiPerfRule cont = new ContiPerfRule();
	
	
	
	// we check that de data in txt is correct
	@SuppressWarnings("deprecation")
	@Test
	public void datacorrect() throws Exception
	{
		
		String mail="inigo@gmail.com";
		String pass="inigoalonso";
		
		Validar valid = new Validar();
		
		valid.validarNombre(mail);
		valid.validarNombre(pass);
		Assert.assertEquals(true, valid.validarEmail(mail));
		Assert.assertEquals(true, valid.validarPassword(pass));
		
	}

}

