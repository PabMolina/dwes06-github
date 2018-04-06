package MatricesAcb;

public class array2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] equipos = {"Real Madrid", "Barcelona", "Unicaja", "Estudiantes", "Joventut"};
		int [][] matriz = new int [5][10];
		int cont=0;
		int min=100;
		
		for(int i=0;i<5;i++) {
			
			matriz[i][0]= (int) (Math.random()*50+51);
			
	
			
			for(int j=0;j<10;j++) {
				
				matriz[i][j]= (int)(Math.random()*50+51);
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println(equipos[i]);
		}
		for(int i=0; i<5; i++) {
			cont=0;
			for(int j=0; j<10; j++) {
				if(matriz[i][j]>=60 && matriz[i][j]<=90) {
					cont++;
				}
				if(matriz[i][j]<min) {
					
					min=matriz[i][j];
				}
				
			}
			System.out.println("Hay " + cont + " jugadores con puntuaciones entre 60 y 90 y la puntuación mínima en el " 
			+ equipos[i] +" es de " + min + " puntos.");
			min=100;
		}
		
		
	}

}
