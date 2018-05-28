package ejerciciosCadenas;

public class Ejerc3CadenaPalindroma {

	public static void main(String[] args) {
		String cadena;
		System.out.println("Introduce la cadena ");
		cadena=LeerTeclado.readString();
		if (palindromo(cadena)) //version 1 introduciendo la cadena sin espacios
			System.out.println("La cadena es pal�ndroma y se lee igual hacia adelante que hacia atr�s");
		else
			System.out.println("La cadena no es pal�ndroma");
		if (palindroma2(cadena)) //version 2 introduciendo la cadena con espacios
			System.out.println("La cadena es pal�ndroma y se lee igual hacia adelante que hacia atr�s");
		else
			System.out.println("La cadena no es pal�ndroma");

	}
	
	public static boolean palindromo (String cad){//considera que no hay espacios
		boolean esPalindromo=true;
		int i=0, j=cad.length()-1;
		while (i<=(cad.length()/2) && esPalindromo){
			//if (cad.charAt(i)!=cad.charAt(j)) es mejor pasarlo a min�sculas
			if (Character.toLowerCase(cad.charAt(i))!=Character.toLowerCase(cad.charAt(j)))
				esPalindromo=false;
			else {
				i++;
				j--;
			}
		}
		return esPalindromo;
	}
	
	public static String borrarEspacios (String cad){ //borra los espacios de la cadena generando un string
		String cad2=new String();
		char c;
		for (int i=0; i<cad.length(); i++){
			if (cad.charAt(i)!=' '){
				c=cad.charAt(i);
				 cad2=cad2.concat(String.valueOf(c)); //pasa el char a String con valueOf para poder concatenar
			}
				
		}
		return cad2;
	}
	public static boolean palindroma2 (String cad){ //considera que hay espacios e invoca a borrarEspacios()
		String s2=borrarEspacios(cad); //borramos los espacios primero
		System.out.println("La cadena sin espacios es "+s2);
		boolean esPalindromo=true;
		int i=0, j=s2.length()-1;
		while (i<=s2.length()/2 && esPalindromo){
			//if (cad.charAt(i)!=cad.charAt(j)) es mejor pasarlo a min�sculas
			if (Character.toLowerCase(s2.charAt(i))!=Character.toLowerCase(s2.charAt(j)))
				esPalindromo=false;
			else {
				i++;
				j--;
			}
		}
	return esPalindromo;
	}
		
	}


