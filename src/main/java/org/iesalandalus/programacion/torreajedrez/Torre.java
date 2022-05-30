package org.iesalandalus.programacion.torreajedrez;

public class Torre {

//CREAMOS LOS ATRIBUTOS
	private Color color;
	private Posicion posicion;

//CREAMOS CONSTRUCTOR POR DEFECTO
	public Torre() {
		setColor(Color.NEGRO);
		setPosicion(new Posicion(8, 'h'));
	}

//CREAMOS CONSTRUCTOR CON EL PARAMETRO COLOR
	public Torre(Color color) {
		setColor(color);
		if (color.equals(null)) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else {
			if (color.equals(Color.BLANCO)) {
				setPosicion(new Posicion(1, 'h'));
			} else {
				setPosicion(new Posicion(8, 'h'));
			}
		}
	}

//CREAMOS CONSTRUCTOR CON LOS PARAMTROS COLOR Y COLUMNA
	public Torre(Color color, char columna) {
		setColor(color);
		if (columna == 'a' || columna == 'h') {
			if (color.equals(Color.BLANCO)) {
				setPosicion(new Posicion(1, columna));
			} else {
				setPosicion(new Posicion(8, columna));
			}
		} else if (color.equals(null)) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}

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
		if (color == null) {
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
		if (posicion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		this.posicion = posicion;
	}

}
