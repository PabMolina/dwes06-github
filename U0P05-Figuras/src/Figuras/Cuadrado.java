package Figuras;

public class Cuadrado {

	private double lado;

	public Cuadrado(double lado) {
	
		this.lado = 4.2;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}

}
