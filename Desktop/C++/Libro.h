#ifndef LIBRO_H
#define LIBRO_H
#include "Objeto.h"

class Libro : public Objeto{

	private: 	
	
		int paginas;
		char* genero;
	
	public :
		Libro();
		Libro(int id,char *nombre,char *autor,char *fecha,int paginas,char* genero);
		Libro(const Objeto& objeto, int paginas, char* genero);
		Libro introducirLibro();
		virtual void imprimirLibro();
		
	
	
};



#endif
