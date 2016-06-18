#include "Objeto.h"
#include <string.h>
#include <iostream>

using namespace std;



		Objeto::Objeto(int id,char *nombre,char *autor,char *fecha){
					
			this->id=id;
	    	
			
			this->nombre=new char[strlen(nombre)+1];
	    	strcpy(this->nombre, nombre);
	    	
	    	
	    	this->autor=new char[strlen(autor)+1];
	    	strcpy(this->autor, autor);
	    	
	    	
	    	this->fecha=new char[strlen(fecha)+1];
	    	strcpy(this->fecha, fecha);
	    	
	       	
		}
		
		
		Objeto::Objeto(const Objeto& objeto){
		
		
			this->id = objeto.id;
		
			this->nombre=new char[strlen(objeto.nombre)+1];
			strcpy(this->nombre, objeto.nombre);
	    		    	
	    	this->autor=new char[strlen(objeto.autor)+1];
	    	strcpy(this->autor, objeto.autor);
	    	
	    	this->fecha=new char[strlen(objeto.fecha)+1];
	    	strcpy(this->fecha, objeto.fecha);
	    	
	     
		}
	
	
	
	Objeto::Objeto(){	

	this->id =0;

	this->nombre = new char[1];
	this->nombre[0] = '\0';
	
	this->autor = new char[1];
	this->autor[0] = '\0';
	
	this->fecha = new char[1];
	this->fecha[0] = '\0'; 
    
	
	
	}	 
		
		
		
		
		
