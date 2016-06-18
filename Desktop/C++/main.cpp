#include <iostream>
#include <stdint.h> 
#include "Libro.h"
#include "Objeto.h"
#include "Usuario.h"
#include "Pelicula.h"
#include "sqlite3.h"
#include "BD.h"
using namespace std;

void menuPrincipal(){

	int opc=0;
	
	cout << "******BIBLIOTECA******\n" << endl;
                  cout << "1. Introducir libro" << endl;
                  cout << "2. Imprimir libros" << endl;
                  cout << "3. Eliminar libro" << endl;
                  cout << "4. Visualizar todos los libros" << endl;
                  cout << "5. Eliminar todos los libro" << endl;
                  cout << "5. Introducir Una pelicula" << endl;
                  cout << "6. Registrar usuario" << endl;
                  cout << "7. Insertar alquiler" << endl;
                  cout << "8. Salir " << endl;
                  cout << "Teclee opcion:" << endl;
                  cin >> opc;
                   switch(opc){
                              case 1:{
                                   system("cls"); 
                              		cout << "----------------------Introducir Libro: --------------------------------" << endl;
                              		cout<<""<<endl;
								   Libro l1;
								   l1.introducirLibro();
								   cout << "-------------------------------------------------" << endl;
								   menuPrincipal();
								   //insertarLibroBD(db, l1);
                                   }break;
							  case 2:{
                              		cout << "IMPRIMIMOS LIBRO: " << endl;
									Libro l1(1,"Ander idiota", "Jon", "25/09/1993",234,"NOVELA");
									l1.imprimirLibro();
									menuPrincipal();
                                   }break;
                              case 4:{
                              		system("cls");
                                  // visualizarTodosLibrosBD(db);
                                   }break;
                              case 5:{
                              		cout << "----------------------Introducir Pelicula: --------------------------------" << endl;
                              		cout<<""<<endl;
                              		Pelicula p;
                              		p.introducirPelicula();
                              		cout << "-------------------------------------------------" << endl;
                              		menuPrincipal(); //para que vuelva al inicio
                              		}break;
                              case 6:{
                              		cout << "----------------------Registrar Usuario: --------------------------------" << endl;
                              		cout<<""<<endl;
                              		Usuario user;
                              		user.registrarUsuario();
                              		menuPrincipal();

                              		
							
                                   }break;


				}
	
}

int main() {
	
		sqlite3 *db;

	int result = sqlite3_open("prueba.s3db", &db);
	if (result != SQLITE_OK) {
		cout<<"Error opening database"<<endl;
		return result;
	}

	actualizarBD(db);
	menuPrincipal();
	
		result = sqlite3_close(db);
	if (result != SQLITE_OK) {
		cout<<"Error opening database"<<endl;
		cout<<sqlite3_errmsg(db)<<endl;
		return result;
	}
	
}
