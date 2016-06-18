#ifndef PELICULA_H
#define PELICULA_H
#include "Objeto.h"

class Pelicula : public Objeto{

	private: 	
	
		int duracion;
		char* tipo;
	
	public :
		Pelicula();
		Pelicula(int id,char *nombre,char *autor,char *fecha,int paginas,char* genero);
		Pelicula(const Objeto& objeto, int paginas, char* genero);
		Pelicula introducirPelicula();
		void imprimirPelicula();
		
	
	
};



#endif
