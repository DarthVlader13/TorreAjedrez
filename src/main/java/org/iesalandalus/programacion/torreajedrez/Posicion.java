package org.iesalandalus.programacion.torreajedrez;

public class Posicion {

//CREAMOS LOS ATRIBUTOS FILA Y COLUMNA
	private int fila;
	private char columna;
	/**
	 * @return the fila
	 */
	public int getFila() {
		return fila;
	}
	/**
	 * @param fila the fila to set
	 */
	public void setFila(int fila) {
		if (fila <1 || fila >8) {
			throw new IllegalArgumentException ("ERROR: Fila no válida.");
		}else {
			this.fila = fila;
		}
	}
	/**
	 * @return the columna
	 */
	public char getColumna() {
		return columna;
	}
	/**
	 * @param columna the columna to set
	 */
	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException ("ERROR: Columna no válida.");
		}else {	
			this.columna = columna;	
		}
	}
	
//GENERAMOS GETTERS AND SETTERS
	
}
