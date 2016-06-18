#include <stdio.h>
#include <iostream>
#include <fstream>
#include "Usuario.h"
#include "Libro.h"
#include "Pelicula.h"
#include "sqlite3.h"
#include "BD.h"

using namespace std;

void actualizarBD(sqlite3 *db){
	
		char nombre[30];
		char login[30];
		char contrasenia[30];	

			
	int id=0;
	
	 ifstream ficheroEntrada("C:/Users/Ander Loizaga/Desktop/NuevoProyBiblioEXT/proyecto_extraordinaria_AnderJon/Usuarios.txt");
	
   
	 if (ficheroEntrada.is_open()) {
       
       id ++;

        while (! ficheroEntrada.eof() ) {
            	
				
				ficheroEntrada.getline (nombre, 30);
           
				ficheroEntrada.getline (login, 30);
				
				ficheroEntrada.getline (contrasenia, 30);
            
				insertarUsuario(db,nombre,login,contrasenia);
				
				
        }

        ficheroEntrada.close();
    }
	 
	 ficheroEntrada.close();

 
}
/*
int callbackLibro(void *data, int argc, char **argv, char **azColName){

	libro li;
    li.isbn = atol((char *) argv[0]);
	strcpy(li.titulo,(char *) argv[1] ? argv[1] : "NULL");
	strcpy(li.autor, (char *) argv[2] ? argv[2] : "NULL");
	strcpy(li.genero, (char *) argv[3] ? argv[3] : "NULL");
	visualizarLibro(li);
      
   return 0;
}

*/



//--------------------------------Insertar usuario------------------------------------------------------

int insertarUsuario(sqlite3 *db,char *nombre,char* login,char *contrasenia) {

	sqlite3_stmt *stmt;



	char sql[] = "insert into usuario (nombre,login,contrasenia) values (?,?,?)";
	int result = sqlite3_prepare_v2(db, sql, strlen(sql) + 1, &stmt, NULL) ;
	if (result != SQLITE_OK) {
		
		return result;
	}


	result = sqlite3_bind_text(stmt, 1, nombre, strlen(nombre), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}

	result = sqlite3_bind_text(stmt, 2, login, strlen(login), SQLITE_STATIC);
	if (result != SQLITE_OK) {
		
		return result;
	}
	
    result = sqlite3_bind_text(stmt, 3, contrasenia, strlen(contrasenia), SQLITE_STATIC);
	if (result != SQLITE_OK) {
		
		return result;
	}
	
	result = sqlite3_step(stmt);
	if (result != SQLITE_DONE) {
		
		return result;
	}

	result = sqlite3_finalize(stmt);
	if (result != SQLITE_OK) {
		
		return result;
	}
	
	return SQLITE_OK;
}

//------------------------------------Insertar libro---------------------------------------------

int insertarLibro(sqlite3 *db,int id, char *nombre,char* autor,char *fecha, int paginas, char* genero){
	sqlite3_stmt *stmt;
	
	char sql[] = "insert into Libro (id,nombre,autor,fecha, paginas, genero) values (?,?,?,?,?,?)";
	int result = sqlite3_prepare_v2(db, sql, strlen(sql) + 1, &stmt, NULL) ;
	if (result != SQLITE_OK) {
		
		return result;
	}
		result = sqlite3_bind_int(stmt, 1, id);
		if (result != SQLITE_OK) {
		
		return result;
	}
	
		result = sqlite3_bind_text(stmt, 2, nombre, strlen(nombre), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_text(stmt, 3, autor, strlen(autor), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_text(stmt, 4, fecha, strlen(fecha), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_int(stmt, 5, paginas);
		if (result != SQLITE_OK) {
		
		return result;
	}
			result = sqlite3_bind_text(stmt, 6, genero, strlen(genero), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_step(stmt);
	if (result != SQLITE_DONE) {
		
		return result;
	}

	result = sqlite3_finalize(stmt);
	if (result != SQLITE_OK) {
		
		return result;
	}
	
	return SQLITE_OK;
	
}

//------------------------------------Insertar Pelicula---------------------------------------------

int insertarPelicula(sqlite3 *db,int id, char *nombre,char* autor,char *fecha, int duracion, char* tipo){
	sqlite3_stmt *stmt;
	
	char sql[] = "insert into Pelicula (id,nombre,autor,fecha, duracion, tipo) values (?,?,?,?,?,?)";
	int result = sqlite3_prepare_v2(db, sql, strlen(sql) + 1, &stmt, NULL) ;
	if (result != SQLITE_OK) {
		
		return result;
	}
		result = sqlite3_bind_int(stmt, 1, id);
		if (result != SQLITE_OK) {
		
		return result;
	}
	
		result = sqlite3_bind_text(stmt, 2, nombre, strlen(nombre), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_text(stmt, 3, autor, strlen(autor), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_text(stmt, 4, fecha, strlen(fecha), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_bind_int(stmt, 5, duracion);
		if (result != SQLITE_OK) {
		
		return result;
	}
			result = sqlite3_bind_text(stmt, 6, tipo, strlen(tipo), SQLITE_STATIC);
	if (result != SQLITE_OK) {

		return result;
		
	}
		result = sqlite3_step(stmt);
	if (result != SQLITE_DONE) {
		
		return result;
	}

	result = sqlite3_finalize(stmt);
	if (result != SQLITE_OK) {
		
		return result;
	}
	
	return SQLITE_OK;
	
}

//------------------------------------Visualizar todos los libros-----------------------------------------------

/*
int visualizarTodosLibrosBD(sqlite3*db){
	char *zErrMsg = 0;
	int rc;
	const char *sql;
	const char* data = "";

	/* Create SQL statement 
	sql = "select * from libro order by id";

	/* Execute SQL statement 
	rc = sqlite3_exec(db, sql, callbackLibro, (void*)data, &zErrMsg);
	if( rc != SQLITE_OK ){
		cout <<  "SQL error: " << zErrMsg << endl;
		sqlite3_free(zErrMsg);
	}else{
		cout << "Libros visualizados correctamente." << endl;
	}
	return SQLITE_OK;
*/


//-------------------------------------------COMPROBAR SI EL USER YA EXISTE-----------------------------------

int verificar_existencia_de_usuario(sqlite3 *db, char* login){
	
	Usuario u;

	
	sqlite3_stmt *stmt;
	
	    char sql[] = "select login from usuario where login=?";
	    
	    int result = sqlite3_prepare_v2(db, sql, -1, &stmt, NULL) ;
	if (result != SQLITE_OK) {
		
		return result;
	}
	
	result = sqlite3_bind_text(stmt, 1, u.getLogin(), strlen(u.getLogin()), SQLITE_STATIC);
	if (result != SQLITE_OK) {
	
		return result;
		
	}
	    
	    if (result == SQLITE_ROW) {
		strcpy(u.getLogin(), (char *) sqlite3_column_text(stmt, 1));	
		
	      }
	      
	      if(login = u.getLogin()){
	      	
				cout<<" YA EXISTE ESE USUARIO !! VUELVA A INTENTARLO"<<endl;
	      	
		  }else{
		  	
		  	//	sleep(2500);
	      	cout<<"El usuario esta disponible"<<endl;
		  }
	      
		  

}

