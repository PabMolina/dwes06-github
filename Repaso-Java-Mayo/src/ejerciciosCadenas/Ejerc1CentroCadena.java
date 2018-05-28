package ejerciciosCadenas;

public class Ejerc1CentroCadena {

	public static void main(String[] args) {
		String cadena, mitadDcha, mitadIzq;
		System.out.println("Introduce la cadena ");
		cadena=LeerTeclado.readString();
		System.out.println("La longitud de la cadena es "+cadena.length());
		int centro=(cadena.length())/2;
		char car=cadena.charAt(centro);
		System.out.println("El centro de la cadena es el car�cter "+ car +" y se encuentra en la posicion "+centro );
		mitadDcha=cadena.substring(centro);
		System.out.println("La mitad derecha de la cadena es "+mitadDcha);
		mitadIzq=cadena.substring(0, centro);
		System.out.println("La mitad izq de la cadena es "+mitadIzq);
		
		

	}

}
