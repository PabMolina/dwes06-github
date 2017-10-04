package Figuras;

public class Cuadrado {

	private double lado;

	public Cuadrado(double lado) {
	
		this.lado =lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double calcularArea(double lado) {
		double area;
		area=lado*lado;
		return area;
	}
	
	public double calcularPerimetro(double lado) {
		double perimetro;
		perimetro=lado*4;
		return perimetro;
	}
	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}

}
