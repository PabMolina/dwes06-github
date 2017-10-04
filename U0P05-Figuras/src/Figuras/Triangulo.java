package Figuras;

public class Triangulo {

	private double base;
	private double altura;
	
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = 8;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = 15;
	}
	public Triangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}

}
