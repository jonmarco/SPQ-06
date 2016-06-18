#include <stdio.h>
#include "biblioteca.h"
#include <stdbool.h>

void cl(){
    system("cls");
}

void paginaPrincipal(){
	char respuesta;
	
	printf("Eres usuario (s/n)?");
	scanf("%s", &respuesta);
	if(respuesta == 's'||respuesta == 'S'){	
		cl();
		iniciarSesion();
	}else if(respuesta == 'n'||respuesta == 'N'){
		cl();
		Persona personaNueva;
		printf("\n\n\t-----NUEVO USUARIO-----\n\n");
		
		printf("Introduce el nombre: ");
		scanf("%s", &personaNueva.nombre);

		printf("Introduce el usuario: ");
		scanf("%s", &personaNueva.login);
		printf("Introduce la contraseña: ");
		scanf("%s", &personaNueva.contrasenia);
		aniadirUsuario("Personas.txt", personaNueva);
		cl();
		
		iniciarSesion();		
	}else{
		cl();
		printf("\n\n\t-----BIENVENIDO A NUESTRA BIBLIOTECA-----\n\n");
		printf("Intentalo de nuevo\n");
		paginaPrincipal();
	}
}

void iniciarSesion(){
	char * usuario;
	printf("\n\n\t-----INICIAR SESION-----\n\n");
	printf("Usuario: ");
	scanf("%s", &usuario);
	char * contrasenia;
	printf("Contraseña: ");
	scanf("%s", &contrasenia);
	int existe = existeUsuario("Personas.txt", usuario, contrasenia);
	if(existe == 1){
		cl();
		int admin = (int)esAdministrador("Personas.txt", usuario);
		if(admin == 1){
			menuAdministrador();
		}else{
			menuUsuario();
		}
	}else{
		cl();
		printf("El usuario y/o la contraseña no son correctos. Vuelve a intentarlo.\n");
		iniciarSesion();
	}
}

void menuAdministrador(){
	printf("\n\n\t-----ADMINISTRADOR-----\n\n");
	printf("1. Añadir libro.\n");
	printf("2. Eliminar libro.\n");
	printf("3. Añadir nuevo administrador.\n\n");
	printf("Que escoges? ");
	int opcion;
	scanf("%d", &opcion);
	if (opcion==3){
		aniadirAdministrador("Personas.txt");
	}
}

void menuUsuario(){
	printf("\n\n\t-----OPCIONES DISPONIBLES-----\n\n");
	printf("1. Devolver un libro.\n");
	printf("2. Ver lista de libros disponibles.\n\n");
	printf("Que escoges? ");
	int opcion;
	scanf("%d", &opcion);
	if (opcion==1){
		cl();
		devolverLibro();
	}else if(opcion==2){
		cl();
		librosDisponibles();
	}else{
		cl();
		printf("Opcion incorrecta. Vuelve a intentarlo.\n");
		menuUsuario();
	}
}

void librosDisponibles(){
 	printf("\n\n\t-----LIBROS DISPONIBLES-----\n\n");
	printf("1. Por orden de titulo.\n");
	printf("2. Por orden de autor.\n");
	printf("3. Por orden de genero.\n\n");
	printf("Como quieres que se muestren? ");
	int opcion;
	scanf("%d", &opcion);
}
 
 void devolverLibro(){
 	printf("\n\n\t-----DEVOLVER LIBRO-----\n\n");
	printf("Introduce el ISBN del libro a devolver: ");
	char * isbn;
	scanf("%s", &isbn);
	cl();
	printf("Gracias. Esperamos que haya disfrutado de su lectura.\n");
	menuUsuario();	
 }

int main(void){
	printf("\n\n\t-----BIENVENIDO A NUESTRA BIBLIOTECA-----\n\n");
	paginaPrincipal();

	return 0;
}


