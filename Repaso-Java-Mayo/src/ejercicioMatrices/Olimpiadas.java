package ejercicioMatrices;

public class Olimpiadas {

	public static void main(String[] args) {

		String[] atletas = new String[10];
		String[] pruebas = { "Curling", "Snowboard", "Esqui alpino", "Esqui de fondo", "Esqui acrobatico", "Salto" };
		int[][] puntuaciones = new int[10][6]; // 10 COLUMNAS, 6 FILAS
		int[] ganadores = new int[6];
		int oro = 0;
		int cont = 0;
//Ponemos nombre a cada atleta, según su posicion en el array.
		for (int i = 0; i < atletas.length; i++) {

			atletas[i] = "Atleta " + (i + 1);

		}
//Mostramos el nombre de cada atleta en una columna diferente.
		for (int i = 0; i < atletas.length; i++) {

			System.out.print(atletas[i] + " \t");

		}
		System.out.println(" \n ");
//Recorremos la matriz para ir añadiendo valores
		for (int j = 0; j < puntuaciones[0].length; j++) {//Primero las filas

			int max = 0; //Inicializamos aquí el máximo para que se reinicie a 0 cada vez que el bucle cambie de prueba (fila).

			for (int i = 0; i < puntuaciones.length; i++) {//Columnas

				puntuaciones[i][j] = (int) (Math.random() * 11 + 0); //Rellenamos cada columna [j] de la fila [i] con notas de 0 a 10.
//Guardamos la mejor puntuacion de cada prueba, para sacar los ganadores mas adelante.
				if (puntuaciones[i][j] > max) {

					max = puntuaciones[i][j];
					oro = i;

				}

				System.out.print(puntuaciones[i][j] + " \t \t");

			}
			System.out.println(pruebas[j] + " ");
			ganadores[j] = oro; // Asignamos el ganador de la fila, antes de cambiar a la siguiente en el bucle.

		}
		
		System.out.println("Introduce el nombre de una prueba");
		String prueba = LeerTeclado.readString();
		
		//Recorremos el array de pruebas para encontrar la prueba introducida por teclado
		
		for (int i = 0; i < pruebas.length; i++) {
			
			if (pruebas[i].equalsIgnoreCase(prueba)) {
				
				System.out.println("El ganador de la prueba de "+pruebas[i]+" es el Atleta "+(ganadores[i]+1));
				
			}
			
		}
		
		for (int i = 0; i < puntuaciones.length; i++) {
			for (int j = 0; j < puntuaciones[0].length; j++) {
				
				if (puntuaciones[i][j]>=9) {
					cont++;
				}
				
			}
			if (cont>=3){
				
				System.out.println("El atleta "+atletas[i]+" ha obtenido "+cont+" puntuaciones de 9 o superiores.");
			}
			cont = 0;
		}

	}

}
