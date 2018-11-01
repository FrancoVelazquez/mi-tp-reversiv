package juego;

/**
 * Juego Reversi
 * 
 * Reglas:
 * 
 * https://es.wikipedia.org/wiki/Reversi https://es.wikihow.com/jugar-a-Othello
 * 
 */
public class Reversi {

	private Casillero tablero[][];

	/**
	 * pre : 'dimension' es un número par, mayor o igual a 4. post: empieza el
	 * juego entre el jugador que tiene fichas negras, identificado como
	 * 'fichasNegras' y el jugador que tiene fichas blancas, identificado como
	 * 'fichasBlancas'. El tablero tiene 4 fichas: 2 negras y 2 blancas. Estas
	 * fichas están intercaladas en el centro del tablero.
	 * 
	 * @param dimensionTablero
	 *            : cantidad de filas y columnas que tiene el tablero.
	 * @param fichasNegras
	 *            : nombre del jugador con fichas negras.
	 * @param fichasBlancas
	 *            : nombre del jugador con fichas blancas.
	 */
	public Reversi(int dimensionTablero, String fichasNegras,
			String fichasBlancas) {

		if (dimensionTablero > 4 && dimensionTablero <= 10) {
			tablero = new Casillero[dimensionTablero][dimensionTablero];
		} else {
			throw new Error("Inserte Dimension Comprendida Entre 4 y 10");
		}

		if (dimensionTablero % 2 != 0) {
			throw new Error("La Dimension Debe Ser Par");
		}

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = Casillero.LIBRE;

			}

		}

		tablero[dimensionTablero / 2][dimensionTablero / 2] = Casillero.BLANCAS;
		tablero[dimensionTablero / 2][dimensionTablero / 2 - 1] = Casillero.NEGRAS;
		tablero[dimensionTablero / 2 - 1][dimensionTablero / 2] = Casillero.NEGRAS;
		tablero[dimensionTablero / 2 - 1][dimensionTablero / 2 - 1] = Casillero.BLANCAS;

	}

	/**
	 * post: devuelve la cantidad de filas que tiene el tablero.
	 */
	public int contarFilas() {

		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad de columnas que tiene el tablero.
	 */
	public int contarColumnas() {

		return tablero.length;
	}

	/**
	 * post: devuelve el nombre del jugador que debe colocar una ficha o null si
	 * terminó el juego.
	 */
	public String obtenerJugadorActual() {

		return "negras";
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()], columnas está en el
	 * intervalo [1, contarColumnas()]. post: indica quién tiene la posesión del
	 * casillero dado por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */
	public Casillero obtenerCasillero(int fila, int columna) {

		return tablero[fila - 1][columna - 1];
	}

	public boolean puedeColocarFicha(int fila, int columna) {

		return (tablero[fila - 1][columna - 1] != Casillero.LIBRE);
	}

	/**
	 * pre : la posición indicada por (fila, columna) puede ser ocupada por una
	 * ficha. 'fila' está en el intervalo [1, contarFilas()]. 'columna' está en
	 * el intervalor [1, contarColumnas()]. y aún queda un Casillero.VACIO en la
	 * columna indicada. post: coloca una ficha en la posición indicada.
	 * 
	 * @param fila
	 * @param columna
	 */
	public void colocarFicha(int fila, int columna) {
		if (puedeColocarFicha(fila, columna)) {

		}
	}

	/**
	 * post: devuelve la cantidad de fichas negras en el tablero.
	 */
	public int contarFichasNegras() {

		return 0;
	}

	/**
	 * post: devuelve la cantidad de fichas blancas en el tablero.
	 */
	public int contarFichasBlancas() {

		return 0;
	}

	/**
	 * post: indica si el juego terminó porque no existen casilleros vacíos o
	 * ninguno de los jugadores puede colocar una ficha.
	 */
	public boolean termino() {

		return false;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {

		return false;
	}

	/**
	 * pre : el juego terminó. post: devuelve el nombre del jugador que ganó el
	 * juego.
	 */
	public String obtenerGanador() {

		return null;
	}

	private boolean comprobarCasilleroDeArriba(int fila, int columna) {
		boolean casilleroDeArribaVacio = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (fila - 2 >= 0) {
					casilleroDeArribaVacio = (tablero[fila - 2][columna - 1] == Casillero.LIBRE);
				}

			}
		}
		return casilleroDeArribaVacio;
	}

	private boolean comprobarCasillerDeAbajo(int fila, int columna) {
		boolean casilleroDeAbajoVacio = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (fila == tablero.length || fila > tablero.length) {
					casilleroDeAbajoVacio = (tablero[fila][columna - 1] == Casillero.LIBRE);

				}

			}
		}
		return casilleroDeAbajoVacio;
	}

	private boolean comprobarCasillerosDeIzquierda(int fila, int columna) {
		boolean casilleroDeIzquierdaVacio = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (columna - 2 >= 0) {
					casilleroDeIzquierdaVacio = (tablero[fila - 1][columna - 2] == Casillero.LIBRE);
				}
			}
		}
		return casilleroDeIzquierdaVacio;

	}
	private boolean comprobarCasillerosDeDerecha(int fila, int columna) {

		boolean casilleroDerechoVacio = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (columna <= tablero.length) {
					casilleroDerechoVacio = (tablero[fila][columna - 2] == Casillero.LIBRE);
				}
			}
		}
		return casilleroDerechoVacio;

	}
	private boolean comprobarCasillerDiagonalSuperiorDerecho(int fila,
			int columna) {
		boolean casilleroDiagonalSuperiorDerecho = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (fila - 2 >= 0 && columna <= tablero.length) {
					casilleroDiagonalSuperiorDerecho = tablero[fila - 2][columna] == Casillero.LIBRE;
				}
			}
		}
		return casilleroDiagonalSuperiorDerecho;
	}
	private boolean comprobarCasillerDiagonlSuperiorIzquierdo(int fila,
			int columna) {
		boolean casilleroDiagonalSuperiorIzquierdo = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (fila - 2 >= 0 && columna - 2 < tablero.length) {
					casilleroDiagonalSuperiorIzquierdo = tablero[fila - 2][columna - 2] == Casillero.LIBRE;
				}
			}
		}
		return casilleroDiagonalSuperiorIzquierdo;

	}
	private boolean comprobarCasilleroDiagonalInferiorIzquierdo(int fila,
			int columna) {
		boolean casilleroDiagonalInferiorIzquierdo = false;
		if (filasYColumnasValidas(fila, columna)) {
			if (tablero[fila - 1][columna - 1] != Casillero.LIBRE) {
				if (fila - 2 >= 0 && columna - 2 < tablero.length) {
					casilleroDiagonalInferiorIzquierdo = tablero[fila - 2][columna - 2] == Casillero.LIBRE;
				}
			}

		}
		return casilleroDiagonalInferiorIzquierdo;
	}
	private boolean comprobarCasileroDiagonalInferiorDerecho(int fila, int columna){
		
		boolean casilleroDiagonalInferiorDerecho =false;
		if(filasYColumnasValidas(fila, columna)){
			if(tablero[fila-1][columna-1] != Casillero.LIBRE){
				if(fila <=0 && columna <= tablero.length){
					casilleroDiagonalInferiorDerecho = tablero[fila][columna] == Casillero.LIBRE;
				}
			}
		}return casilleroDiagonalInferiorDerecho;
	}
	private boolean filasYColumnasValidas(int fila, int columna) {
		return ((fila > 0 && fila < tablero.length) && (columna > 0 && columna < tablero.length));
	}
}
