package ejercicio1;


public class Olimpiadas {


	public static void main(String[] args) {

		String prueba;

		String[] nombreAtleta = new String[10];

		String[] nombrePrueba = { "Curling", "Snowboard", "Esqui alpino", "Esqui de fondo", "Esqui acrobatico", "Salto" };

		int[][] puntuaciones = new int[10][6];

		int [] ganadores=new int[6];

		int oro=0;

		int contador=0;

		for (int i = 0; i < nombreAtleta.length; i++) {

			nombreAtleta[i] = "Atleta " + (i + 1);

		}


		for (int i = 0; i < nombreAtleta.length; i++) {

			System.out.print(nombreAtleta[i] + " \t ");

		}

		System.out.println(" \n");

		for (int j = 0; j < puntuaciones[0].length; j++) {

			int max = 0;

			for (int i = 0; i < puntuaciones.length; i++) {

				puntuaciones[i][j] = (int) (Math.random() * 11) + 0;

				

				if (max < puntuaciones[i][j]) {

					max=puntuaciones[i][j];

					oro=i;

				}


				System.out.print(puntuaciones[i][j] + " \t \t ");

			}

			System.out.println(nombrePrueba[j] + " ");

			ganadores[j]=oro;

	
		}


		System.out.println("Introduce la prueba");

		prueba=LeerTeclado.readString();

		

		for (int i = 0; i < puntuaciones.length; i++) {

			for (int j = 0; j < puntuaciones[i].length; j++) {

				if(puntuaciones[i][j]>=9){

					contador++;

					

				}

			}

			if(contador>=3) {

				System.out.println("El atleta"+(i+1)+" ha conseguido 3 puntuaciones mas altas que 9");
			

			}

			contador=0;

		}


		for(int i=0; i<nombrePrueba.length;i++) {

			if(nombrePrueba[i].equalsIgnoreCase(prueba)) {

				System.out.println("El ganador de la prueba "+prueba+" es el Atleta"+(ganadores[i]+1));

			}

		}

		

	}



}