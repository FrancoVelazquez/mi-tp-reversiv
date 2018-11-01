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

		return Casillero.LIBRE;
	}

	public boolean puedeColocarFicha(int fila, int columna) {

		return false;
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
				if (fila - 2 == 0 || fila - 2 >= 0) {
					casilleroDeArribaVacio = (tablero[fila - 2][columna - 1] != Casillero.LIBRE);
				}

			}
		}
		return casilleroDeArribaVacio;
	}
	
	private boolean comprobarCasillerDeAbajo(int fila, int columna){
		boolean casilleroDeAbajoVacio = false;
		if (filasYColumnasValidas(fila, columna)){
			if (tablero[fila -1][columna -1] != Casillero.LIBRE){
				if(fila == tablero.length || fila > tablero.length){
					casilleroDeAbajoVacio =(tablero[fila][columna-1]!= Casillero.LIBRE);
					
				}
				
			}
		}return casilleroDeAbajoVacio;
	}

	private boolean filasYColumnasValidas(int fila, int columna) {
		return ((fila > 0 && fila < tablero.length) && (columna > 0 && columna < tablero.length));
	}
}
