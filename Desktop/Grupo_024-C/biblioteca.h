#ifndef BIBLIOTECA_H_
#define BIBLIOTECA_H_
#include <stdbool.h>

typedef struct{
	
	char* nombre;
	char* login;
	char* contrasenia;	
}Persona;

typedef struct{
	int disponible;
	char* nombre;
	char* isbn;
	char* autor;
	char* genero;
}Libro;


void visualizarPersona(Persona p);
void visualizarLibro(Libro l);
Libro cambiarDisponibilidad(Libro l);

void aniadirUsuario(char path[], Persona p);
void aniadirAdministrador(char path[]);
int existeUsuario(char path[], char * login, char * contrasenia);
int esAdministrador(char path[], char * login);
#endif




