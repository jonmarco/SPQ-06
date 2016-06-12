/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.deusto.client.Controller;


import java.util.ArrayList;

import es.deusto.client.RemoteControl.ServiceLocator;
import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.ReproduccionDTO;



public class InteractuarController {
    
    
    public static InteractuarController instance = null;
    
    private static String nombre ="";
    
    public static InteractuarController getInstance()
    {
        if(instance == null)
        {
            instance = new InteractuarController();
        }
     
     return instance;
    }
    
    public boolean login(String user, String pass) {
    	try
        {
          boolean lb = ServiceLocator.getInstance().getService().login(user, pass);
          if(lb)
        	  nombre = user;
          return lb;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    	return false;
    }
    
    
    public CancionDTO buscarCancion(int _id_cancion)
    {
        CancionDTO cbuscada=null;
       
        try
        {
            cbuscada= ServiceLocator.getInstance().getService().buscarCancion(_id_cancion);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return cbuscada;
    }
    
    
    
    public ArrayList<CancionDTO> buscarCanciones(String _nombrecancion)
    {
    	ArrayList<CancionDTO> listacancionesusuario=null;
        
        try
        {
         listacancionesusuario= ServiceLocator.getInstance().getService().
                 buscarCanciones(_nombrecancion);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return listacancionesusuario;
        
    }
    
 
    
    public void aniadirReproduccion(int _id_usuario, String _id_cancion)
    {
        
        try
        {
            ServiceLocator.getInstance().getService()
                    .aniadirReproduccion(_id_usuario, _id_cancion);
        }catch(Exception e)
        {
           e.printStackTrace();
        }
            
            
            
    }
    
    public ArrayList<ReproduccionDTO> usuarioReproducciones(String _id_usuario)
    {
        ArrayList<ReproduccionDTO>lReproduccionDTO=null;
        
        try
        {
        	lReproduccionDTO= ServiceLocator.getInstance().getService()
                    .usuarioReproducciones(_id_usuario);
        }catch(Exception e)
        {
           e.printStackTrace();
        }
            
            
        return lReproduccionDTO;
            
    }

	public static String getNombre() {
		return nombre;
	}
        
 
}