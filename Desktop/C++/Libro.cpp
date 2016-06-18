#include <string.h>
#include <iostream>
#include <cstdlib>
#include "Libro.h"
#include "BD.h"

using namespace std;	
	

	
		Libro::Libro(){
			Objeto();
			
			this->paginas =0;
			
			this->genero = new char[1];
			this->genero[0] = '\0';
			
		}
	
	
	
	
		Libro::Libro(int id,char *nombre,char *autor,char *fecha,int paginas,char* genero) : Objeto(id,nombre,autor,fecha){
    		this->paginas=paginas;
    	
    		this->genero=new char[strlen(genero)+1];
    		strcpy(this->genero, genero);   	
		}
		
		Libro::Libro(const Objeto& objeto, int paginas, char* genero) : Objeto(objeto), paginas(paginas),genero(genero){
    		this->paginas=paginas;
    	
    		this->genero=new char[strlen(genero)+1];
    		strcpy(this->genero, genero);   	
		}
		
				
		Libro Libro::introducirLibro(){
 	
 		sqlite3 *db;

	int result = sqlite3_open("prueba.s3db", &db);
	if (result != SQLITE_OK) {
		cout<<"Error opening database"<<endl;
	}
 		
 		Libro li;
 		
    	system("cls");
    	cout << "Teclee los datos del libro:" << endl;
    	cout << "ID: ";
        cin >> li.id;
		fflush(stdin);
		cout << "Titulo: ";
        cin.getline(li.nombre, 40);
		cout << "Autor: ";
    	cin.getline(li.autor, 40);
        cout << "Fecha: ";
        cin.getline(li.fecha, 40);
        cout << "Paginas: ";
        cin >> li.paginas;
        fflush(stdin);
        cout << "Genero: ";
        cin.getline(li.genero, 20);
        
         fflush(stdin);
        cout << "Se va a registrar este nuevo libro." << endl;
        cout <<  endl;
        
        
        cout<<"-------------ESTE ES EL LIBRO INTRODUCIDO----------------------"<<endl;
		insertarLibro(db,li.id,li.nombre,li.autor,li.fecha,li.paginas,li.genero);	
        li.imprimirLibro();
        
   	
   		
		return li;
    }
		
		
		void Libro::imprimirLibro(){
			
			
			cout<<"ID:"<<this->id<<endl;
			cout<<"Titulo:"<<this->nombre<<endl;
			cout<<"Autor:"<<this->autor<<endl;
			cout<<"Fecha:"<<this->fecha<<endl;
			cout<<"Paginas:"<<this->paginas<<endl;
			cout<<"Genero:"<<this->genero<<endl;
			
			
		}
		

		
		
		
		
		
		
		
