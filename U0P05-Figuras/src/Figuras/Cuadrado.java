package Figuras;

public class Cuadrado extends Figura{

	private double lado;

	public Cuadrado(String titulo,colores col,double lado) {
		super(titulo,col);
		this.lado =lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double calcularArea() {
		double area;
		area=lado*lado;
		return area;
	}
	
	public double calcularPerimetro() {
		double perimetro;
		perimetro=lado*4;
		return perimetro;
	}
	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}

}
