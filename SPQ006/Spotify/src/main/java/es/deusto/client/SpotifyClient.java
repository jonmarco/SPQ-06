package es.deusto.client;

import es.deusto.client.GUI.Login;
import es.deusto.client.GUI.VInteractuar;
import es.deusto.client.RemoteControl.ServiceLocator;

public class SpotifyClient {
	
	
	
	// agrupamos el codigo del ServiceLocator en esta clase
	private static ServiceLocator rsl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
			System.exit(0);
		}	
		
		rsl = ServiceLocator.getInstance();
		rsl.setService(args[0], args[1], args[2]);
		

		new VInteractuar();
		
		
		
		
		// try catch service locator
		
		
		
	}
			
		
	
	
	
	
}
