package Figuras;

public class Circunferencia extends Figura{

	private double radio;

	public Circunferencia(String titulo,colores col,double radio) {
		super(titulo,col);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	
	public double calcularArea() {
		double area;
		area=(Math.PI*(Math.pow(radio, 2)));
		return area;
	}
	
	public double calcularPerimetro() {
		double perimetro;
		perimetro=2*Math.PI*radio;
		return perimetro;
	}
	
	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + "]";
	}

	

}
