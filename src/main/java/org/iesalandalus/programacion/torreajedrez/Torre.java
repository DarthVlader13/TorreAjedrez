package org.iesalandalus.programacion.torreajedrez;

public class Torre {

//CREAMOS LOS ATRIBUTOS
	private Color color;
	private Posicion posicion;
	
//GENERAMOS GETTERS AND SETTERS
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	private void setColor(Color color) {
		if (color==null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else {
			this.color = color;
		}
	}
	/**
	 * @return the posicion
	 */
	public Posicion getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion the posicion to set
	 */
	private void setPosicion(Posicion posicion) {
		if (posicion==null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		this.posicion = posicion;
	}
	
	
}
