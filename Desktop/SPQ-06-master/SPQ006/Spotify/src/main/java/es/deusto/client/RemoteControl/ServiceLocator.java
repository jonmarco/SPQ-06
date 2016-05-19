
package es.deusto.client.RemoteControl;

import java.rmi.Naming;

import es.deusto.server.remote.ISpotify;


@SuppressWarnings("deprecation")
public class ServiceLocator {
    
    
    public static ServiceLocator instance = null;
    
    private ISpotify servicio;
    
    public static ServiceLocator getInstance()
    {
        if(instance == null)
        {
            instance = new ServiceLocator();
        }
     
     return instance;
    }
    
    
    public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new java.rmi.RMISecurityManager());
		}

		try {
                    // direccion de la IP, Puerto y Nombre del server
			String URL = "//" + ip + ":" + port + "/" + serverName;
			System.out.println("IP:" + ip + "Puerto:" + port + "ServerName:" +serverName);
                       // returns a reference to a rmi object associated with the specified name
			this.servicio = (ISpotify) Naming.lookup(URL);
			
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}
	}

	public ISpotify getService() {
		return this.servicio;
	}
    
    
  
    
}
