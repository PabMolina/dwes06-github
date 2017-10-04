package Figuras;

public class Circunferencia {

	private double radio;

	public Circunferencia(double radio) {
		
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	
	public double calcularArea(double radio) {
		double area;
		area=(Math.PI*(Math.pow(radio, 2)));
		return area;
	}
	
	public double calcularPerimetro(double radio) {
		double perimetro;
		perimetro=2*Math.PI*radio;
		return perimetro;
	}
	
	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + "]";
	}

}
