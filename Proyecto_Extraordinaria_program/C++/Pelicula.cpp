#include <string.h>
#include <iostream>
#include "Pelicula.h"
#include "BD.h"

using namespace std;	
	

	
		Pelicula::Pelicula(){
			Objeto();
			
			this->duracion =0;
			
			this->tipo = new char[1];
			this->tipo[0] = '\0';
			
		}
	
	
	
	
		Pelicula::Pelicula(int id,char *nombre,char *autor,char *fecha,int duracion,char* tipo) : Objeto(id,nombre,autor,fecha){
    		this->duracion=duracion;
    	
    		this->tipo=new char[strlen(tipo)+1];
    		strcpy(this->tipo, tipo);   	
		}
		
		Pelicula::Pelicula(const Objeto& objeto, int duracion, char* tipo) : Objeto(objeto), duracion(duracion),tipo(tipo){
    		this->duracion=duracion;
    	
    		this->tipo=new char[strlen(tipo)+1];
    		strcpy(this->tipo, tipo);   	
		}
		
				
		Pelicula Pelicula::introducirPelicula(){
 	
 			
 		sqlite3 *db;

		int result = sqlite3_open("prueba.s3db", &db);
		if (result != SQLITE_OK) {
			cout<<"Error opening database"<<endl;
		}
 		
 		Pelicula pe;
 		
    	system("cls");
    	cout << "Teclee los datos del libro:" << endl;
    	cout << "ID: ";
        cin >> pe.id;
		fflush(stdin);
		cout << "Titulo: ";
        cin.getline(pe.nombre, 40);
		cout << "Autor: ";
    	cin.getline(pe.autor, 40);
        cout << "Fecha: ";
        cin.getline(pe.fecha, 40);
        cout << "Duracion: ";
        cin >> pe.duracion;
        fflush(stdin);
        cout << "tipo: ";
        cin.getline(pe.tipo, 20);
        fflush(stdin);
        cout << "Se va a registrar esta nueva pelicula." << endl;
        cout <<  endl;
        cout<<""<<endl;
        
        
        cout<<"-------------ESTE ES EL LIBRO INTRODUCIDO----------------------"<<endl;
        pe.imprimirPelicula();
        insertarPelicula(db,pe.id,pe.nombre,pe.autor,pe.fecha,pe.duracion,pe.tipo);
        
        
   	
   		
		return pe;
    }
		
		
		void Pelicula::imprimirPelicula(){
			
			
			cout<<"ID:"<<this->id<<endl;
			cout<<"Titulo:"<<this->nombre<<endl;
			cout<<"Autor:"<<this->autor<<endl;
			cout<<"Fecha:"<<this->fecha<<endl;
			cout<<"Duracion:"<<this->duracion<<endl;
			cout<<"Tipo:"<<this->tipo<<endl;
			
			
		}
		

		
		
		
		
		
		
		
