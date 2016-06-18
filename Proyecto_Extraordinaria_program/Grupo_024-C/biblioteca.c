#include <stdio.h>
#include <stdlib.h>
#include "biblioteca.h"
#include <stdbool.h>


void visualizarPersona(Persona p){
	printf("----DATOS PERSONALES----\n");


	printf("Nombre: %s\n",p.nombre);

	printf("Usuario: %s\n",p.login);
	printf("Contraseña: %s\n\n",p.contrasenia);
}

void visualizarLibro(Libro l){
	printf("----DATOS DEL LIBRO----\n");
	printf("Esta disponible? ");
	if(l.disponible == 1){
			printf("Si\n");
	}else{
			printf("No\n");
	}
	printf("Nombre: %s\n",l.nombre);
	printf("ISBN: %s\n", l.isbn);
	printf("Autor: %s\n",l.autor);
	printf("Genero: %s\n\n",l.genero);
}

Libro cambiarDisponibilidad(Libro l){
	int k = l.disponible;
	if(k==true){
		l.disponible = false;
	}else{
		l.disponible = true;
	}
	
	return l;
}

void aniadirUsuario(char path[], Persona p){
	FILE* miArchivo;
	miArchivo = fopen(path, "a");
	if(miArchivo!=NULL){
		fprintf(miArchivo,"%s %s %s \n",&p.nombre,&p.login,&p.contrasenia);
	}
	
	fclose(miArchivo);
}
void aniadirAdministrador(char path[]){
	FILE* miArchivo;
	miArchivo = fopen(path, "a");
	Persona p;
	printf("\n\n\t-----NUEVO ADMINISTRADOR-----\n\n");
	printf("Introduce el nombre: ");
	scanf("%s", &p.nombre);
	printf("Introduce el usuario: ");
	scanf("%s", &p.login);
	printf("Introduce la contraseña: ");
	scanf("%s", &p.contrasenia);
	if(miArchivo!=NULL){
		fprintf(miArchivo," %s %s %s \n",&p.nombre,&p.login,&p.contrasenia);
	}
	
	fclose(miArchivo);
}

int existeUsuario(char path[], char * usuario, char * contrasenia){
	FILE* miArchivo;
	miArchivo = fopen(path, "r");
	char* lecturaContrasenia;
	char* lecturaUsuario;
	if(miArchivo!=NULL){
		int i;
		for(i=1;i<=7;i++){
			if (i==7){
				fscanf(miArchivo, "%s", &lecturaContrasenia);	
			}else{
				fscanf(miArchivo, "%s", &lecturaUsuario);
			}
		}
		if(lecturaUsuario==usuario){
			if(lecturaContrasenia==contrasenia){
				return 1;
			}else{
				return 0;
			}			
		}else{
			return 0;
		}
	}
	fclose(miArchivo);
}

int esAdministrador(char path[], char * login){
	FILE* miArchivo;
	miArchivo = fopen(path, "r");
	int lecturaAdmin;
	char* lecturalogin;
	char* comodin;
	if(miArchivo!=NULL){
		int i;
		for(i=1;i<=7;i++){
			if (i==1){
				fscanf(miArchivo, "%d", &lecturaAdmin);	
				
			}else if(i==6){
				fscanf(miArchivo, "%s", &lecturalogin);
			}else{
				fscanf(miArchivo, "%s", &comodin);
			}
		}
	}
	if(lecturalogin==login){
		return lecturaAdmin;
	}
	fclose(miArchivo);
}


