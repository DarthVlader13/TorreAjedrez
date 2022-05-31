package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

//DECLARAMOS LOS ATRIBUTOS
	private static Torre torre;

	public static void main(String[] args) {
		int contador = 1;
		int pulsador;

		System.out.println("Bienvenido a la simulación del movimiento de una Torre de ajedrez");
		do {
			mostrarMenu();
			pulsador = elegirOpcion();
			ejecutarOpcion(pulsador);

			if (pulsador != 5) {
				mostrarTorre();
			}

			if (pulsador == 5) {
				contador = 0;
			}
		} while (contador != 0);
	}

//CREAMOS MÉTODO MOSTRARTORRE
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e) {
			System.out.println("ERROR: La torre no está creada.");
		}
	}

//CREAMOS MÉTODO MOSTRARMENU
	private static void mostrarMenu() {
		System.out.println("A continuación, selecciona una de las opciones del menú:");
		System.out.println("1. Crear una torre por defecto.");
		System.out.println("2. Crear una torre eligiendo su color (BLANCA o NEGRA).");
		System.out.println("3. Crear torre eligiendo su color y posición inicial.");
		System.out.println("4. Mover torre.");
		System.out.println("5. Salir de la simulación.");

	}

//CREAMOS MÉTODO ELEGIROPCION
	private static int elegirOpcion() {
		int opcionMenu;
		do {
			System.out.println("Opción a ejecutar:");
			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		System.out.println("La opción elegida es la " + opcionMenu);
		return opcionMenu;
	}

//CREAMOS MÉTODO ELEGIRCOLOR
	private static Color elegirColor() {
		Color color = null;
		int opcionColor = 0;
		do {
			System.out.println("");
			System.out.println("Elección de color");
			System.out.println("Elige una de las siguientes opciones entre 1 y 2:");
			System.out.println("1. Blanca");
			System.out.println("2. Negra");
			opcionColor = Entrada.entero();
		} while (opcionColor != 1 && opcionColor != 2);

		switch (opcionColor) {
		case 1:
			color = Color.BLANCO;
			System.out.println("Has elegido que la torre sea de color blanca.");
			break;
		case 2:
			color = Color.NEGRO;
			System.out.println("Has elegido que la torre sea de color negra.");
			break;
		default:
			break;
		}
		return color;
	}

//CREAMOS MÉTODO COLUMNAINICIAL
	private static char elegirColumnaInicial() {
		char columnaInicial = 0;
		do {
			System.out.println("");
			System.out.println("Elección de columna inicial");
			System.out.println("Elige una de las siguientes opciones escribiendo a o h:");
			System.out.println("Columna a, Columna h.");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial != 'a' && columnaInicial != 'h');
		System.out.println("Has elegido la columna " + columnaInicial);
		return columnaInicial;
	}

//CREAMOS MÉTODO MOSTRARMENUDIRECCIONES
	private static void mostrarMenuDirecciones() {
		System.out.println("");
		System.out.println("Elección de dirección");
		System.out.println("Elige una de las siguientes opciones para elegir dirección:");
		System.out.println("1. Mover torre hacia arriba.");
		System.out.println("2. Mover torre hacia abajo.");
		System.out.println("3. Mover torre hacia izquierda.");
		System.out.println("4. Mover torre hacia derecha.");
		System.out.println("5. Realizar un enroque corto.");
		System.out.println("6. Realizar un enroque largo.");

	}

//CREAMOS MÉTODO ELEGIRDIRECCION
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		do {
			System.out.println("");
			System.out.println("Opción a ejecutar");
			opcionDireccion = Entrada.entero();
		} while (opcionDireccion < 1 || opcionDireccion > 6);

		switch (opcionDireccion) {
		case 1:
			direccion = Direccion.ARRIBA;
			System.out.println("Has elegido mover la torre hacia arriba.");
			break;
		case 2:
			direccion = Direccion.ABAJO;
			System.out.println("Has elegido mover la torre hacia abajo.");
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			System.out.println("Has elegido mover la torre hacia la izquierda.");
			break;
		case 4:
			direccion = Direccion.DERECHA;
			System.out.println("Has elegido mover la torre hacia la derecha.");
			break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
			System.out.println("Has elegido utilizar el enroque corto.");
			break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
			System.out.println("Has elegido utilizar el enroque largo.");
			break;
		default:
			break;
		}
		return direccion;
	}

//CREAMOS MÉTODO CREARTORREDEFECTO
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

//CREAMOS MÉTODO CREARTORRECOLOR
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}

//CREAMOS MÉTODO CREARTORRECOLORCOLUMNA
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}

//CREAMOS MÉTODO MOVER
	private static void mover() {
		Direccion direccion = null;
		int pasos;
		if (torre == null) {
			System.out.println("ERROR: No hay ninguna torre, creala antes para moverla.");
		} else {
			mostrarMenuDirecciones();
			direccion = elegirDireccion();

			if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
				try {
					torre.enrocar(direccion);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("");
				System.out.println("¿Cuantas posiciones quieres mover la torre?:");
				pasos = Entrada.entero();

				try {
					torre.mover(direccion, pasos);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

//CREAMOS MÉTODO EJECUTAROPCION
	private static void ejecutarOpcion(int opcionEjecucion) {
		switch (opcionEjecucion) {
		case 1:
			crearTorreDefecto();
			break;
		case 2:
			crearTorreColor();
			break;
		case 3:
			crearTorreColorColumna();
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.println("¡Gracias por usar nuestro simulador de una torre de ajedrez!");
			System.out.println("¡Hasta la próxima!");
			break;
		}
	}

}
