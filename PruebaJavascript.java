
//import java.util.Random;

public class MatDama {

	/*
	 * Pasos para alcanzar la cima 1. Crear una matriz de ceros M 2. Generar numeros
	 * aleatorios para M(fila, columna) 3. Marcar la posicion obtenida en el paso
	 * dos 4. verificar si es una posicion segura (linea fila y columna) 5.
	 * verificar si la posicion es segura en sus diagonales 6. confirmar los cambios
	 * a la matriz original
	 */

	// Generar rangos estaticos para aleatoriedad
	protected final static int NMIN = 0;
	protected final static int NMAX = 7;

	// Generar tamaño estatico para el tamaño mxn en la matriz
	protected final static int TAMANO = 8;
	
	// Establecer la catidad de reinas en el tablero
	protected final static int CANTIDAD = 7;

	
	public static void main(String[] args) {

		int[][] matrizOriginal = crearMatriz();
		int[][] matrizCopia = agregarReina(matrizOriginal);
		
		imprimirMatriz(matrizCopia);

	}
	
	public static int[][] agregarReina(int[][] mtzc) {
		
		int[][] mtzc2 = new int[TAMANO][TAMANO];
		for (int h = 1; h <= CANTIDAD; h++) {
			
			System.out.println("\n***************** Agregando a la reina N° -> "+h+"******************\n");
			
			int fila = numeroRamdom();
			int columna = numeroRamdom();
			
			
			
			boolean g = false;
			
				while(!g) {
					System.out.println("Comprobando la seguridad en la fila:| " + fila + " | columna:| " + columna+" |");
					g = comprobarSeguridad(mtzc, fila, columna);
					//System.out.println(g+"\n");
					if(g) { 
						System.out.println("------------- Las ubicaciones son *Seguras* --------------\n");
						mtzc2 = rellenarMatriz(mtzc, fila, columna);
					}else {
						System.out.println("En la ubicación Fila:| "+fila+" | Columna:| "+columna+" | la reina queda en peligro.\n Buscando una nueva posición...\n");
						fila = numeroRamdom();
						columna = numeroRamdom();
					}
					
				}
			
		}
		
		return mtzc2;
	}
	

	public static int numeroRamdom() {
		int numero = NMIN + (int) (Math.random() * ((NMAX - NMIN) + 1));
		return numero;
	}

	public static int[][] crearMatriz() {

		int[][] matz = new int[10][10];
		for (int i = 0; i < TAMANO; i++) {
			for (int k = 0; k < TAMANO; k++) {
				matz[i][k] = 0;
			}
		}
		return matz;
	}

	public static int[][] rellenarMatriz(int[][] matz, int f, int c) {
		matz[f][c] = 1;
		// descomentar para ver las iteraciones
		//imprimirMatriz(matz);
		return matz;
	}

	public static void imprimirMatriz(int[][] matz) {

		for (int i = 0; i < TAMANO; i++) {
			for (int k = 0; k < TAMANO; k++) {
				System.out.print(" | " + matz[i][k]);
				if (k == TAMANO-1) System.out.print(" |");
			}
			System.out.println();
		}
	}
	
	public static boolean filaaSegura(int[][] mtzc, int fila, int col) {
		for (int f = 0; f < TAMANO; f++) {
			//System.out.println("Hola "+mtzc[fila][f]);
			if (mtzc[fila][f] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean columnaSegura(int[][] mtzc, int col, int fil) {
		
		//System.out.println("> F: "+fil+" C: "+col);
		
		for (int c = 0; c < TAMANO; c++) {
			//System.out.println("----> "+mtzc[c][col]);
			if (mtzc[c][col] == 1) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean diagonalSuperiorIzquierdaSegura(int[][] mtzc, int fila, int col) {
		int c = col;
		int f = fila;

		//System.out.println("Diagonal superior --> F: "+f+" C: "+c);
		
		int cDecremento = (c>0)?--c:c;
		int fDecremento = (f>0)?--f:f;
		if (cDecremento > 0 && fDecremento > 0) {
			
			for (;f>=0 && c>=0; f--, c--) {
				//System.out.println("Valor c -> "+c+" Valor f -> "+f);
				if (mtzc[f][c] == 1) {
					return false;
				}
			}
			
		}else {
			if (mtzc[fDecremento][cDecremento] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int aumentarPosicion(int pos, int tam) {
		if(pos<tam) {
			return ++pos;
		}else {
			return pos;
		}
	}
	
	public static int disminuirPosicion(int pos) {
		if(pos>0) {
			return --pos;
		}else {
			return pos;
		}
	}
	
	
	public static boolean diagonalInferiorIzquierdaSegura(int[][] mtzc, int fila, int col) {
		int c = col;
		int f = fila;
		//System.out.println("Diagonal Inferior --> F: "+f+" C: "+c);
		
		int cDecremento = (c>=0)?c:--c;
		int fIncremento = (f<TAMANO)?f:++f;
		if (cDecremento > 0) {
			
			for (;f<TAMANO && c>=0; f++, c--) {
				//System.out.println("Valor c -> "+c+" Valor f -> "+f);
				if (mtzc[f][c] == 1) {
					return false;
				}
			}
			
		}else {
			if (mtzc[fIncremento][cDecremento] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean diagonalInferiorDerechaSegura(int[][] mtzc, int fila, int col) {
		int c = col;
		int f = fila;
		//System.out.println("Diagonal Inferior derecha --> F: "+f+" C: "+c);
			
			for (;f<TAMANO && c<TAMANO; f++, c++) {
				//System.out.println("Valor c -> "+c+" Valor f -> "+f);
				if (mtzc[f][c] == 1) {
					return false;
				}
			}
		
		return true;
	}
	
	public static boolean diagonalSuperiorDerechaSegura(int[][] mtzc, int fila, int col) {
		int c = col;
		int f = fila;
		//System.out.println("Diagonal superior derecha --> F: "+f+" C: "+c);
		
		int cIncremento = (c<TAMANO)?c:++c;
		int fDecremento = (f>=0)?f:--f;
		if (cIncremento > 0) {
			
			for (;c<TAMANO && f>=0; c++, f--) {
				//System.out.println("Valor c -> "+c+" Valor f -> "+f);
				if (mtzc[f][c] == 1) {
					return false;
				}
			}
			
		}else {
			if (mtzc[fDecremento][cIncremento] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean comprobarSeguridad(int[][] mtzc, int fila, int col) {
		
		boolean fSegura = filaaSegura(mtzc, fila, col);
		boolean cSegura = columnaSegura(mtzc, col, fila);
		boolean dsSegura = diagonalSuperiorIzquierdaSegura(mtzc, fila, col);
		boolean diSegura = diagonalInferiorIzquierdaSegura(mtzc, fila, col);
		boolean dsSupDSegura = diagonalInferiorDerechaSegura(mtzc, fila, col);
		boolean dsSupIzSegura = diagonalSuperiorDerechaSegura(mtzc, fila, col);
		
		if (fSegura) System.out.println("|fila Segura|"); else System.out.println("|fila Peligrosa|") ;
		if (cSegura) System.out.println("|columna Segura|"); else System.out.println("|columna Peligrosa|") ;
		if (dsSegura) System.out.println("|diag sup izq Segura|"); else System.out.println("|diag sup izq Peligrosa|") ;
		if (diSegura) System.out.println("|diag inf izq Segura|"); else System.out.println("|diag inf izq Peligrosa|") ;
		if (dsSupDSegura) System.out.println("|diag sup der Segura|"); else System.out.println("|diag sup der Peligrosa|") ;
		if (dsSupIzSegura) System.out.println("|diag sup der Segura|"); else System.out.println("|diag sup der Peligrosa|") ;
		
		if (fSegura && cSegura && dsSegura && diSegura && dsSupIzSegura && dsSupDSegura) {
			return true;
		}else {
			return false;
		}

	}

}
