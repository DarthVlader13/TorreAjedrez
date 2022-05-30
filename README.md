# Tarea Torre Ajedrez
## Profesor: Andr�s Rubio del R�o
## Alumno: Jos� Francisco Hern�ndez Allen

La tarea va a consistir en modelar el movimiento de una torre de ajedrez por el tablero de dicho juego.
<div align="center">

<img src="src/main/resources/posicionInicialTorre.png"/>
<img src="src/main/resources/movimientoTorre.png"/>

<p style="font-size: xx-small">Im�genes obtenidas de la web: (https://www.123ajedrez.com/reglas-basicas/la-torre) (Enrique Moreno)</p>
</div>

En la primera imagen puedes observar cu�l es el posicionamiento inicial v�lido para las torres dependiendo de su color.

En la segunda imagen puedes apreciar cu�les son los movimientos v�lidos para una torre. Adem�s, de estos movimientos mostrados en la imagen, otro posible movimiento de la torre es el conocido como enroque, pudiendo ser un enroque corto o un enroque largo:
</div>

<div align="center">
<img src="src/main/resources/PosicionSinEnroque.png" width="238" height="238"/>
<img src="src/main/resources/Enroque.png" width="238" height="238"/>
<img src="src/main/resources/EnroqueCortoYLargo.png" width="238" height="238"/>
<p style="font-size: xx-small">Im�genes obtenidas de la web: (https://www.123ajedrez.com/reglas-basicas/enroque) (Enrique Moreno)</p>
</div>

En este repositorio hay un esqueleto de proyecto gradle que ya lleva incluidos todos los test necesarios que el programa debe pasar.

Para ello te pongo un diagrama de clases para el mismo y poco a poco te ir� explicando los diferentes pasos a seguir:
<div align="center"><img src="src/main/resources/TorreAjedrez.png" alt="Diagrama de clases para torre de ajedrez"/>
</div>

1. Lo primero que debes hacer es un `fork` del repositorio donde he colocado el esqueleto de este proyecto.
2. Clona tu repositorio remoto reci�n copiado en GitHub a un repositorio local que ser� donde ir�s realizando lo que a continuaci�n se te pide. Modifica el archivo `README.md` para que incluya tu nombre en el apartado "Alumno". Realiza tu primer commit.
3. Crea un enumerado llamado `Color`, dentro del paquete adecuado, que contenga los valores: `BLANCO` y `NEGRO`. Realiza un commit.
4. Crea un enumerado llamado `Direccion`, dentro del paquete adecuado, que contenga los valores: `ARRIBA`, `ABAJO`, `IZQUIERDA`, `DERECHA`, `ENROQUE_CORTO`, `ENROQUE_LARGO`. Realiza un commit.
5. Crea la clase `Posicion`. Crea los atributos `fila` (int) y `columna` (char) con la visibilidad adecuada. Realiza un commit.
6. Crea los m�todos `get` y `set` para los atributos. Recuerda que para el m�todo `set` se debe tener en cuenta que los valores indicados sean correctos (las filas van del 1 al 8 -ambos inclusive- y las columnas de la 'a' a la 'h' -ambas inclusive-) y si no se lance una excepci�n del tipo `IllegalArgumentException` con el mensaje adecuado. En caso de que la posici�n no sea la correcta no deben modificarse los atributos. Realiza un commit.
7. Crea un constructor para esta clase que acepte como par�metros la fila y la columna y que los asigne a los atributos si son correctos. Si no son correctos debe lanzar una excepci�n del tipo `IllegalArgumentException` con el mensaje adecuado. Para ello utiliza los m�todos set anteriormente creados. Realiza un commit.
8. Crea el constructor copia para esta clase. Realiza un commit.
9. Crea los m�todos `equals` y `hashCode` para esta clase. Realiza un commit.
10. Crea el m�todo `toString` que devolver� un `String` y ser� la representaci�n de la fila y la columna de forma adecuada (fila=valorf, columna=valorc). Realiza un commit.
11. Crea la clase `Torre`, dentro del paquete adecuado, cuyos atributos ser�n un color (del tipo enumerado `Color`) y posicion (de la clase `Posicion`), con la visibilidad adecuada. Realiza un commit.
12. Crea los m�todos `get` y `set` para cada atributo con la visibilidad adecuada. Estos m�todos siempre comprobar�n la validez de los par�metros pasados y si no son correctos deber� lanzar la excepci�n adecuada (`NullPointerException` o `IllegalArgumentException`) con el mensaje adecuado. Realiza un commit.
13. Crea un constructor por defecto para esta clase que cree una torre negra en la posici�n '8h'. Realiza un commit.
14. Crea un constructor para la clase que acepte como par�metro el color y que crear� una torre de dicho color cuya posici�n ser� '1h' si es blanca o '8h' si es negra. Realiza un commit.
15. Crea un constructor para la clase que acepte como par�metros el color y la columna inicial. La columna inicial debe ser v�lida (de lo contrario debe lanzar la excepci�n `IllegalArgumentException` con un mensaje adecuado). Este constructor crear� una torre del color dado y colocado en dicha columna ('a' o 'h') y cuya fila ser� la 1 si es blanca y la 8 si es negra. Realiza un commit.
16. Crea el m�todo `mover` que acepte como par�metro una `Direccion` y la cantidad de pasos a mover en dicha direcci�n. Los pasos deben ser positivos y la direcci�n no puede ser nula o de lo contrario debe lanzar una excepci�n adecuada (`NullPointerException` o `IllegalArgumentException`) con el mensaje adecuado. Si no puede realizar dicho movimiento, debido a que la torre se sale del tablero, se debe lanzar una excepci�n del tipo `OperationNotSupportedException` con un mensaje adecuado y no modificar� la posici�n de la torre. Realiza un commit.
17. Crea el m�todo `enrocar` que acepte como par�metro una `Direcci�n` v�lida para enrocar teniendo en cuenta que:�
	1. En el enroque en el flanco de rey (enroque corto), las blancas mueven su rey desde e1 a g1 y la torre desde h1 a f1, y en el enroque en el flanco de dama (enroque largo) mueven su rey desde e1 a c1 y la torre desde a1 a d1.
	2. En el enroque en el flanco de rey (enroque corto), las negras mueven su rey desde e8 a g8 y la torre desde h8 a f8, y en el enroque en el flanco de dama (enroque largo) mueven su rey desde e8 a c8 y la torre desde a8 a d8.
18. Crea los m�todos `equals` y `hashCode` para esta clase. Realiza un commit.
19. Crea el m�todo `toString` que devuelva un `String` que ser� la representaci�n de dicho objeto (color y posici�n). Realiza un commit.
20. Crea los diferentes m�todos que se indican en el diagrama de clases para permitir que el m�todo `main` nos muestre un men� que nos permitir� crear una torre por defecto, crear una torre de un color, crear una torre de un color en una columna inicial dada ('c' o 'f'), mover la torre y salir. Despu�s de cada operaci�n se nos mostrar� el estado actual de nuestra torre. El men� se repetir� mientras no elijamos la opci�n salir. En todo caso se debe validar que todas las entradas al programa son correctas. Para ello implementa los siguientes m�todos:
    1. `void mostrarTorre()`: mostrar� por consola la representaci�n de la torre representado por el atributo de clase `torre` (crea el atributo si a�n no lo has hecho). Realiza un commit.
    2. `void mostrarMenu()`: mostrar� por consola el men� con las diferentes opciones de nuestro programa. Realiza un commit.
    3. `int elegirOpcion()`: Nos mostrar� un mensaje para que elijamos una opci�n del men� anteriormente creado y nos pedir� que introduzcamos por teclado la opci�n hasta que �sta sea valida. Devolver� la opci�n elegida. Realiza un commit.
    4. `Color elegirColor()`: Nos preguntar� que elijamos un color mientras �ste no sea v�lido y dependiendo de la opci�n elegida devolver� un color u otro. Realiza un commit.
    5. `char elegirColumnaInicial()`: Nos preguntar� que elijamos la columna inicial mientras �sta no sea v�lida y devolver� la columna elegida. Realiza un commit.
    6. `void mostrarMenuDirecciones()`: Mostrar� por consola un men� con las diferentes direcciones que podemos elegir. Realiza un commit.
    7. `Direccion elegirDireccion()`: Nos mostrar� un mensaje para que elijamos una opci�n del men� anteriormente creado y nos pedir� que introduzcamos por teclado la opci�n hasta que �sta sea valida. Devolver� la direcci�n elegida. Realiza un commit.
    8. `void crearTorreDefecto()`: Asignar� al atributo de clase torre una nueva instancia de una torre creada con el constructor por defecto. Realiza un commit.
    9. `void crearTorreColor()`: Asignar� al atributo de clase torre una nueva instancia de una torre creada con el constructor al que le pasamos el color. Este m�todo debe utilizar m�todos ya implementados anteriormente. Realiza un commit.
    10. `void crearTorreColorColumna()`: Asignar� al atributo de clase torre una nueva instancia de una torre creada con el constructor al que le pasamos el color y la columna inicial. Este m�todo debe utilizar m�todos ya implementados anteriormente. Realiza un commit.
    11. `void mover()`: Mostrar� un men� con las posibles direcciones, nos preguntar� por la direcci�n y la cantidad de pasos a mover y mover� la torre seg�n esos par�metros. Este m�todo debe utilizar m�todos ya implementados anteriormente. Realiza un commit.
    12. `void ejecutarOpcion(int)`: Depediendo de la opci�n pasada como par�metro, actuar� en consecuencia. Este m�todo debe utilizar m�todos ya implementados anteriormente. Realiza un commit.
    13. `void main(String[])`: M�todo principal de nuestra aplicaci�n que deber� realizar lo que se pide en el apartado 20 y que debe apoyarse en los m�todos anteriormente implementados. Realiza un commit y realiza el push a tu repositorio remoto en GitHub.


#### Se valorar�:

    La indentaci�n debe ser correcta en cada uno de los apartados.
    El nombre de las variables debe ser adecuado.
    Se debe utilizar la clase `Entrada` para realizar la entrada por teclado.
    El programa debe pasar todas las pruebas que van en el esqueleto del proyecto y toda entrada del programa ser� validada, para evitar que el programa termine abruptamente debido a una excepci�n.
    La correcci�n ortogr�fica tanto en los comentarios como en los mensajes que se muestren al usuario.