package es.deusto.client;

import java.io.BufferedReader;
import java.io.FileReader;

public class LecturaFichero {
	
	
	private String ruta;
	private BufferedReader bf = null;
	private int c;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public LecturaFichero(String _ruta)
	{
		this.ruta=_ruta;
	}

	public LecturaFichero(){
		
		
	
	}
	
	public void leerFichero(String _nombre)
	{
		 
		try
		{
			bf = new BufferedReader(new FileReader(_nombre));
			while( (c= bf.read()) != -1)
			{
				
				
		
				
				
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			
			
		}finally{
			
			
			
			
			
			
		}
		
		}
	

}
