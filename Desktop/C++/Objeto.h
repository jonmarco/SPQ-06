#ifndef OBJETO_H
#define OBJETO_H

class Objeto{
	
	protected:
		
		int id;
		char *nombre;
		char *autor;
		char *fecha;
	    
	
	public :
		Objeto();
		Objeto(int id,char *nombre,char *autor,char *fecha);
		Objeto(const Objeto& objeto);
	
	
		
	
	    
	
};

#endif
