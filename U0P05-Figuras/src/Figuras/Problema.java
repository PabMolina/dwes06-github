package Figuras;

import Figuras.Figura.Color;

public class Problema {

	public static void main(String[] args) {
		
		Circunferencia cir1=new Circunferencia("Circunferencia1", Color.BLUE, 4.8);
		Circunferencia cir2=new Circunferencia("Circunferencia2", Color.RED, 1.5);
		Cuadrado cua1=new Cuadrado("Cuadrado1", Color.WHITE, 4.2);
		Triangulo tri1=new Triangulo("Triangulo1", Color.BLUE, 8,15);
		
		double areaTotal=0;
		double perimetroTotal;
	areaTotal=cir2.calcularArea()*0.75+cir1.calcularArea()*0.5+cua1.calcularArea()+tri1.calcularArea();
	perimetroTotal=tri1.calcularPerimetro()+cua1.getLado()*2+cir1.calcularPerimetro()*0.5-cir1.getRadio()*2+cir2.calcularPerimetro()*0.75-cir2.getRadio()*2;
		
	System.out.println("Datos de la circunferencia 1: "+cir1.toString());
	System.out.println("Datos de la circunferencia 2: "+cir2.toString());
	System.out.println("Datos del cuadrado: "+cua1.toString());
	System.out.println("Datos del triangulo: "+tri1.toString());
	System.out.println("El ï¿½rea de la figura es "+areaTotal);
	System.out.println("El perï¿½metro de la figura es "+perimetroTotal);
	
	
	GestorFiguras arrayListFiguras=new GestorFiguras();
	System.out.println("Aï¿½adimos las figuras");
	arrayListFiguras.añadirFigura(cir1);
	arrayListFiguras.añadirFigura(cir2);
	arrayListFiguras.añadirFigura(cua1);
	arrayListFiguras.añadirFigura(tri1);
	System.out.println("Mostramos las figuras");
	arrayListFiguras.mostrarFiguras();
	System.out.println("Borramos una figura");
	arrayListFiguras.eliminarFigura("Cuadrado1");
	System.out.println("Volvemos a mostrar las figuras");
	arrayListFiguras.mostrarFiguras();
	
	}

}
