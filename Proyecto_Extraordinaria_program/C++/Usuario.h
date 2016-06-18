#ifndef USUARIO_H
#define USUARIO_H

class Usuario{
	
	private:
		
		char* nombre;
		char* login;
		char* contrasenia;
		
	
	public:
		Usuario();
		Usuario(char* nombre, char* login, char* contrasenia);
		Usuario registrarUsuario();
		virtual void imprimir();
		char* getNombre();
		char* getLogin();
		char* getContrasenia();
	
	
};



#endif


