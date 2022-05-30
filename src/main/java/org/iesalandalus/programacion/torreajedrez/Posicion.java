package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {

//CREAMOS LOS ATRIBUTOS FILA Y COLUMNA
	private int fila;
	private char columna;

//GENERAMOS GETTERS AND SETTERS

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
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
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
			throw new IllegalArgumentException("ERROR: La columna no válida.");
		} else {
			this.columna = columna;
		}
	}

//CREAMOS UN CONSTRUCTOR CON PARAMETROS DE ENTRADA
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

//CREAMOS UN CONSTRUCTOR COPIA
	public Posicion(Posicion e) {
		if (e == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		} else {
			setFila(e.getFila());
			setColumna(e.getColumna());
		}
	}

// CREAMOS MËTODOS HASHCODE/EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

//CREAMOS MÉTODO TOSTRING
	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}

}
