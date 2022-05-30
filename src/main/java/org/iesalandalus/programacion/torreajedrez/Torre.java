package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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

//CREAMOS MÉTODO MOVER CON LOS PARÁMETROS DIRECCIÓN Y PASOS
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 1) {
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		} else if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		} else {
			switch (direccion) {
			case ARRIBA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case ABAJO:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case IZQUIERDA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			case DERECHA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() - pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char) (posicion.getColumna() + pasos)));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
				break;
			default:
				throw new NullPointerException("ERROR: La dirección no puede ser nula");
			}
		}
	}

//CREAMOS MÉTODO ENROCAR CON EL PARÁMETRO DIRECCIÓN
	public void enrocar(Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		} else {
			switch (direccion) {
			case ENROQUE_CORTO:
				if (posicion.getColumna() == 'h' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
					setPosicion(new Posicion(posicion.getFila(), 'f'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			case ENROQUE_LARGO:
				if (posicion.getColumna() == 'a' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
					setPosicion(new Posicion(posicion.getFila(), 'd'));
				} else {
					throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
				}
				break;
			default:
				break;
			}
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

//CREAMOS MÉTODO HASHCODE/EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

//CREAMOS MÉTODO TOSTRING
	@Override
	public String toString() {
		return posicion + ", color=" + color;
	}

}
