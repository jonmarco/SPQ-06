package es.deusto.client;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;


@PerfTest(invocations=10)
@Required(max=2000)
public class LoginConnection {
	
	
	private String nombre="";
	private String email="";
	
	
	

	
	public LoginConnection()
	{
		
		
	}
	
	
	
	

}
