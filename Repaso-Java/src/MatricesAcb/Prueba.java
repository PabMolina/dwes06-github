package MatricesAcb;
public class Prueba {



	public static void main(String[] args) {

		// TODO Auto-generated method stub



		String pruebas [] = {"curling", "snowboard" , "esquí alpino","esquí de fondo", "esquí acrobático" , "salto de esquí"};

		String atletas []= new String [10];

		

		int matriz [][]= new int[10][6];

		int mayor=0;

		int c=1;

		int pos=0;

		

		//recorremos el array atleta y le asignamos sus valores

		for (int i = 0; i < atletas.length; i++) {

			atletas[i]="Atleta"+(c++);

		}



		

		//rellenamos la matriz con valores aleatorios entre 0 y 10



		for (int i = 0; i < 10; i++) {

			System.out.println();

			matriz[i][0]= (int)(Math.random()*9+1);

			

			for (int j = 0; j < 6; j++) {

				matriz[i][j]= (int)(Math.random()*9+1);

				

				  System.out.print(matriz[i][j]+" | ");

				  

			}

			System.out.println(atletas[i]);

		}

		

		

		

		/*

		//BUSCAMOS LA POSICIÓN DEL ATLETA

		System.out.println("\nIntroduce el nombre de una prueba");

		String nombrePrueba=LeerTeclado.readString();

		

		int posicion=0;

		for (int i = 0; i < pruebas.length; i++) {

			if(atletas[i].equalsIgnoreCase(nombrePrueba)){

				posicion=i;

			}

		}

		System.out.println("posicion: "+posicion);

		 //*/

				

		

		//ver pruebas

		

		for (int i = 0; i < pruebas.length; i++) {

			System.out.println(pruebas[i]+ "-> "+i);

		}

		

	

		do{

			System.out.println("Introduce la posición de la prueba");

			pos=LeerTeclado.readInteger();

		}while(pos>5 && pos<0);

		boolean encontrado=true;

		

		for (int i = 0; i < 10; i++) {

		

			

			for (int j = 0; j < 6; j++) {

				if(matriz[pos][j]>mayor)

					mayor=matriz[pos][j];

			}

		}

		String prueba="";

		for (int i = 0; i < pruebas.length; i++) {

			prueba=pruebas[pos];

		}

		String atleta="";

		for (int i = 0; i < atletas.length; i++) {

			atleta=atletas[mayor];

		}

		System.out.println("En la prueba : "+prueba+"\n La mayor puntuación es: "+mayor+"\n Realizada por el atleta: "+atleta);

		

		

		

	}



}