#ifndef BD_H
#define BD_H
#include "Usuario.h"
#include "Libro.h"
#include "Pelicula.h"
#include "sqlite3.h"
#include <string.h>
#include <vector>


void actualizarBD(sqlite3 *db);
int insertarUsuario(sqlite3 *db,char *nombre,char* login,char *contrasenia);
int insertarLibro(sqlite3 *db,int id, char *nombre,char* autor,char *fecha, int paginas, char* genero);
int insertarPelicula(sqlite3 *db,int id, char *nombre,char* autor,char *fecha, int duracion, char* tipo);
//int visualizarTodosLibrosBD(sqlite3*db);
int verificar_existencia_de_usuario(sqlite3 *db, char* login);




#endif
