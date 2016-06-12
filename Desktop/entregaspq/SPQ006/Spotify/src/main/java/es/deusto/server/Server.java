package es.deusto.server;


import java.rmi.Naming;

import es.deusto.client.RemoteControl.ServiceLocator;
import es.deusto.server.remote.ISpotify;
import es.deusto.server.remote.Spotify;


public class Server {
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		System.out.println("Name: " + name);

		try {
			System.out.println("entramos en el try catch");
			
		
			Naming.rebind(name, Spotify.getInstance());
			System.out.println(" Spotify '" + name + "' encendido ");
			//GatewayLogin.getInstance().setService(args[3], args[4], args[5]);
			System.out.println("vamos al login");
			
			Spotify.getInstance().setLoginService(args[0], args[1], args[2]);
			//ServiceLocator.getInstance().setService(args[0], args[1], args[2]);// lo mismo para paypal y banco
			//(new Thread()).sleep(20000);
			//RemoteFacade.getInstance().setPagoService(args[0], args[1], args[5]);
			// para paypal los args serian args[0]args[1]args[5]
			// para banco los args serian args[0]args[1]args[4]
			System.in.read();
		} catch (Exception ex) {
			System.err.println(" # Excepcion en el servidor: "
					+ ex.getMessage());
		}
	}

}
