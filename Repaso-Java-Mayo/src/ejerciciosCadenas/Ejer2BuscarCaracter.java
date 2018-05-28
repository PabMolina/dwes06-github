package ejerciciosCadenas;

public class Ejer2BuscarCaracter {

	public static void main(String[] args) {
		String cadena;
		char caracter;
		
		System.out.println("Introduce la cadena");
		cadena=LeerTeclado.readString();
		System.out.println("Introduce el caracter a buscar");
		caracter=LeerTeclado.readCharacter();
		
		
		
		
		System.out.println("Buscamos todas las apariciones del car�cter en la cadena");
		buscarTodos (cadena, caracter);
		System.out.println();
		

	}
	
	
	
	public static void buscarTodos (String caden, char car){
		int pos=0;

		if (caden.indexOf(car,pos)==-1)
			System.out.println("El car�cter no se encuentra en la cadena");

		else 
			while (caden.indexOf(car, pos)!=-1)
			{	
				System.out.println("El car�cter se encuentra en la posici�n "+caden.indexOf(car,pos));
				pos=caden.indexOf(car,pos)+1;//buscamos a partir de la posicion donde se encontr� (pos)
			}

	}

}
