
#include <string.h>
#include <iostream>
#include <cstdlib>
#include "Usuario.h"
#include "BD.h"

using namespace std;

Usuario::Usuario(){
	
		    this->nombre = new char[1];
			this->nombre[0] = '\0';
			
			this->login = new char[1];
			this->login[0] = '\0';
			
			this->contrasenia = new char[1];
			this->contrasenia[0] = '\0';
}

Usuario::Usuario(char* nombre, char* login, char* contrasenia){
	
	
	this->nombre=new char[strlen(nombre)+1];
	    	strcpy(this->nombre, nombre);
	
	this->login=new char[strlen(login)+1];
	    	strcpy(this->login, login);
	    	
	    	this->contrasenia=new char[strlen(contrasenia)+1];
	    	strcpy(this->contrasenia, contrasenia);
}

Usuario Usuario::registrarUsuario(){
	
	
	sqlite3 *db;

	int result = sqlite3_open("prueba.s3db", &db);
	if (result != SQLITE_OK) {
		cout<<"Error opening database"<<endl;
	}
	
	 	Usuario us;
        fflush(stdin);
		cout << "Nombre: ";
    	cin.getline(us.nombre, 40);
    	fflush(stdin);
    	cout << "Usuario: ";
    	cin.getline(us.login, 40);
    	verificar_existencia_de_usuario(db,us.login); //para comrpobar si el login que se introduce existe o no existe
    	cout<<""<<endl;
	    cout<<""<<endl;
    	fflush(stdin);
        cout << "Contrasenia: ";
        cin.getline(us.contrasenia, 20);
        fflush(stdin);
        cout << "Se va a registrar este nuevo usuario." << endl;
        cout <<  endl;
        cout<<"---------------El usuario introducido es:------------------------"<<endl;
        cout<<""<<endl;
        
        insertarUsuario(db,us.nombre,us.login,us.contrasenia); // EL METODO QUE REGISTRA UN USUARIO EN LA BD
      
        us.imprimir();
        
   	//	visualizarUsuario(us);
   		
		return us;
	
}

void Usuario::imprimir(){
	
			cout<<"Nombre:"<<this->nombre<<endl;
			cout<<"Usuario:"<<this->login<<endl;
			cout<<"Contrasenia:"<<this->contrasenia<<endl;

}
char* Usuario::getNombre(){
	
	return this->nombre;
}

char* Usuario::getLogin(){
	
	return this->login;
}

char* Usuario::getContrasenia(){
	
	return this->contrasenia;
}
