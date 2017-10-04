package Figuras;

import Figuras.Figura.colores;

public class Problema {

	public static void main(String[] args) {
		
		double areaFigura;
		double perimetroFigura;
		Circunferencia cir1=new Circunferencia("CIRCUNFERENCIA1",colores.naranja,4.8);
		Circunferencia cir2=new Circunferencia("CIRCUNFERENCIA2",colores.verde,1.5);
		Cuadrado cua1=new Cuadrado("CUADRADO",colores.rojo,4.2);
		Triangulo tri1=new Triangulo("TRIANGULO",colores.amarillo,8, 15);
		
		System.out.println("Calculamos el área de la figura");
		areaFigura=(cir1.calcularArea()*0.5)+(cir2.calcularArea()*0.75)+cua1.calcularArea()+tri1.calcularArea();
		System.out.println("El resultado es:"+areaFigura);
		System.out.println("Calculamos el perimetro de la figura");
		perimetroFigura=(cir1.calcularPerimetro()*0.5)+(cir2.calcularPerimetro()*0.75)+(cua1.calcularPerimetro()*0.75)*(tri1.calcularPerimetro()-cua1.getLado()-(cir2.getRadio()*2));
		System.out.println("El resultado es: "+perimetroFigura);
	}
	
}
