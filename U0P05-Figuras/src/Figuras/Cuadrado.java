package Figuras;

public class Cuadrado extends Figura{

	double lado;
	
	public Cuadrado(String titulo,Color color,double lado){
		super(titulo,color);
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	/**
	 * Método para calcular el área del cuadrado
	 * @return el área del cuadrado
	 */
	public double calcularArea(){
		return Math.pow(lado, 2);
	}
	/**
	 * Método para calcular el perímetro del cuadrado
	 * @return el perímetro del cuadrado
	 */
	public double calcularPerimetro(){
		return lado*4;
	}
	

	@Override
	public String toString() {
		return super.toString()+" Cuadrado [lado=" + lado + "]";
	}
	
}
