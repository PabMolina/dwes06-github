package Figuras;

public class Problema {

	public static void main(String[] args) {
		
		double areaFigura;
		double perimetroFigura;
		Circunferencia cir1=new Circunferencia(4.8);
		Circunferencia cir2=new Circunferencia(1.5);
		Cuadrado cua1=new Cuadrado(4.2);
		Triangulo tri1=new Triangulo(8, 15);
		
		System.out.println("Calculamos el área de la figura");
		areaFigura=(cir1.calcularArea( )*0.5)+tri1.calcularArea(8, 15)+(cua1.calcularArea(4.2))+(cir2.calcularArea(1.5)*0.75);
		System.out.println("El resultado es:"+areaFigura);
		System.out.println("Calculamos el perimetro de la figura");
		perimetroFigura=(cir1.calcularPerimetro(radio))
	}
	
}
